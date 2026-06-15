"""
Company Update Script
Unified script that:
1. Refactors input.json to create retrievedTags.json (from refactoring.py logic)
2. Merges retrievedTags.json with existing companyTags.json (from jsonMerger.py logic)
3. Saves the merged result to both data/companyTags.json and JSON Merger/companyTags.json

Usage:
1. Place this script inside Python Scripts/ directory
2. Update input.json manually in Refactoring/
3. Run this script from Python Scripts/ directory
4. The script will automatically handle the refactoring and merging
"""

import json
import os
import sys
from pathlib import Path

# ========== REFACTORING LOGIC (from refactoring.py) ==========
def refactor_json(input_filename, output_filename):
    """
    Reads a JSON file and refactors it to group problems by company names.
    
    Args:
        input_filename (str): Name of the input JSON file
        output_filename (str): Name of the output JSON file
    """
    
    # Read the input JSON file
    try:
        with open(input_filename, 'r', encoding='utf-8') as file:
            data = json.load(file)
    except FileNotFoundError:
        print(f"Error: File '{input_filename}' not found.")
        return False
    except json.JSONDecodeError:
        print(f"Error: Invalid JSON format in '{input_filename}'.")
        return False
    
    # Initialize the refactored structure
    refactored_data = {}
    
    # Process each problem in the data array
    for problem in data.get('data', []):
        problem_info = {
            "problem_name": problem.get('title', ''),
            "leetcode_number": str(problem.get('id', '')),
            "leetcode_link": f"https://leetcode.com/problems/{problem.get('slug', '')}/",
            "solution_yt_link": "https://youtu.be/example",  # Placeholder as not provided in input
            "intuition": "",  # Empty as not provided in input
            "key_steps": ""  # Empty as not provided in input
        }
        
        # Add this problem to each company that uses it
        for company in problem.get('companies', []):
            company_name = company.get('name', '')
            
            if company_name not in refactored_data:
                refactored_data[company_name] = []
            
            # Check if this problem is already added for this company (avoid duplicates)
            existing_problem = next(
                (p for p in refactored_data[company_name] 
                 if p['leetcode_number'] == problem_info['leetcode_number']), 
                None
            )
            
            if not existing_problem:
                refactored_data[company_name].append(problem_info.copy())
    
    # Sort companies alphabetically and problems by leetcode number
    sorted_refactored_data = {}
    for company in sorted(refactored_data.keys()):
        sorted_refactored_data[company] = sorted(
            refactored_data[company], 
            key=lambda x: int(x['leetcode_number']) if x['leetcode_number'].isdigit() else 0
        )
    
    # Write the refactored JSON to the output file
    try:
        with open(output_filename, 'w', encoding='utf-8') as file:
            json.dump(sorted_refactored_data, file, indent=2, ensure_ascii=False)
        
        print(f"✅ Successfully created '{output_filename}'.")
        print(f"📊 Processed {len(data.get('data', []))} problems")
        print(f"🏢 Found {len(sorted_refactored_data)} companies")
        
        # Display summary
        print("\n📋 Company Summary:")
        for company, problems in sorted_refactored_data.items():
            print(f"   {company}: {len(problems)} problems")
        
        return True
            
    except Exception as e:
        print(f"Error writing to '{output_filename}': {str(e)}")
        return False

# ========== JSON MERGER LOGIC (from jsonMerger.py) ==========
def load_json(file_path):
    """Load JSON data from file"""
    try:
        with open(file_path, 'r', encoding='utf-8') as file:
            return json.load(file)
    except FileNotFoundError:
        print(f"Error: File '{file_path}' not found.")
        return None
    except json.JSONDecodeError as e:
        print(f"Error: Invalid JSON in file '{file_path}': {e}")
        return None
    except Exception as e:
        print(f"Error reading file '{file_path}': {e}")
        return None

def merge_items(item1, item2):
    """Merge two items, preferring non-empty values from item1 or item2"""
    merged_item = item2.copy()  # Start with item2 as base
    
    # Override with non-empty values from item1
    for key, value in item1.items():
        if value and str(value).strip():  # Check if value is not empty or just whitespace
            merged_item[key] = value
        elif key not in merged_item:  # If key doesn't exist in item2, use item1's value
            merged_item[key] = value
    
    return merged_item

def merge_arrays_without_duplicates(arr1, arr2, unique_key='leetcode_number'):
    """Merge two arrays without duplicates based on a unique key"""
    # Create dictionaries to track items by unique key
    items_dict = {}
    
    # Process second array first (as base)
    for item in arr2:
        if unique_key in item:
            items_dict[item[unique_key]] = item.copy()
    
    # Process first array, merging with existing items or adding new ones
    for item in arr1:
        if unique_key in item:
            unique_value = item[unique_key]
            if unique_value in items_dict:
                # Merge items, preferring non-empty values from first array
                items_dict[unique_value] = merge_items(item, items_dict[unique_value])
            else:
                items_dict[unique_value] = item.copy()
    
    # Convert back to list, maintaining order (first array items first, then new items from second array)
    merged = []
    seen = set()
    
    # Add items from first array first (to maintain order preference)
    for item in arr1:
        if unique_key in item and item[unique_key] not in seen:
            seen.add(item[unique_key])
            merged.append(items_dict[item[unique_key]])
    
    # Add remaining items from second array
    for item in arr2:
        if unique_key in item and item[unique_key] not in seen:
            seen.add(item[unique_key])
            merged.append(items_dict[item[unique_key]])
    
    return merged

def merge_json_data(json1, json2):
    """Merge two JSON objects"""
    merged = {}
    
    # Get all keys from both JSONs
    all_keys = set(json1.keys()) | set(json2.keys())
    
    for key in all_keys:
        val1 = json1.get(key, [])
        val2 = json2.get(key, [])
        
        # If both values are lists, merge them without duplicates
        if isinstance(val1, list) and isinstance(val2, list):
            merged[key] = merge_arrays_without_duplicates(val1, val2)
        # If only one exists, use that one
        elif val1 and not val2:
            merged[key] = val1
        elif val2 and not val1:
            merged[key] = val2
        # If both exist but aren't lists, prefer the second one (json2)
        else:
            merged[key] = val2
    
    return merged

def save_json(data, filename):
    """Save JSON data to file"""
    try:
        # Create directory if it doesn't exist
        os.makedirs(os.path.dirname(filename), exist_ok=True)
        
        with open(filename, 'w', encoding='utf-8') as file:
            json.dump(data, file, indent=2, ensure_ascii=False)
        print(f"Merged JSON saved successfully as '{filename}'")
        return True
    except Exception as e:
        print(f"Error saving file '{filename}': {e}")
        return False

def main():
    """Main function"""
    print("🔄 Company Update Tool")
    print("=" * 50)
    
    # Define paths - script is now inside Python Scripts/
    script_dir = Path(__file__).parent  # This is Python Scripts/
    dsahub_dir = script_dir.parent      # This is dsahub/
    
    input_file = script_dir / "Refactoring" / "input.json"
    retrieved_tags_file = script_dir / "JSON Merger" / "retrievedTags.json"
    existing_company_tags = script_dir / "JSON Merger" / "companyTags.json"
    
    # Output paths
    data_company_tags = dsahub_dir / "data" / "companyTags.json"
    merger_company_tags = script_dir / "JSON Merger" / "companyTags.json"
    
    print(f"📂 Working directory: {script_dir}")
    print(f"📄 Input file: {input_file}")
    
    # Step 2: Check if input file exists
    if not input_file.exists():
        print(f"\n❌ Input file '{input_file}' not found!")
        print("💡 Please make sure input.json exists in Refactoring/")
        sys.exit(1)
    
    # Step 2: Run refactoring logic
    print(f"\n🚀 Step 1: Processing input.json and creating retrievedTags.json")
    if not refactor_json(str(input_file), str(retrieved_tags_file)):
        print("❌ Refactoring failed!")
        sys.exit(1)
    
    # Step 3: Run merger logic
    print(f"\n🔄 Step 2: Merging with existing companyTags.json")
    
    # Load the newly created retrievedTags.json
    retrieved_data = load_json(str(retrieved_tags_file))
    if retrieved_data is None:
        print("❌ Failed to load retrievedTags.json!")
        sys.exit(1)
    
    # Load existing companyTags.json (if it exists)
    existing_data = {}
    if existing_company_tags.exists():
        existing_data = load_json(str(existing_company_tags))
        if existing_data is None:
            existing_data = {}
            print("⚠️  Using empty data for existing companyTags.json due to load error")
    else:
        print("ℹ️  No existing companyTags.json found, starting fresh")
    
    print("Merging JSON data...")
    
    # Merge the JSON data (retrievedTags.json with existing companyTags.json)
    merged_data = merge_json_data(retrieved_data, existing_data)
    
    # Step 4: Save to both locations
    print(f"\n💾 Step 3: Saving merged data to output locations")
    
    success1 = save_json(merged_data, str(data_company_tags))
    success2 = save_json(merged_data, str(merger_company_tags))
    
    if success1 and success2:
        print("\n🎉 Company update completed successfully!")
    else:
        print("\n❌ Some files failed to save!")
        sys.exit(1)
    
    # Print summary
    print("\n📊 Summary:")
    for key, value in merged_data.items():
        if isinstance(value, list):
            print(f"  {key}: {len(value)} items")
        else:
            print(f"  {key}: {type(value).__name__}")
    
    print(f"\n📁 Output files:")
    print(f"  • {data_company_tags}")
    print(f"  • {merger_company_tags}")

if __name__ == "__main__":
    main()