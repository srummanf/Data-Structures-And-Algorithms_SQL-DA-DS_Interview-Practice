"""
JSON Merger Script for Company-Grouped LeetCode Problems

This script intelligently merges two JSON files containing company-grouped LeetCode problems without creating duplicates.

Input Format:
- Two JSON files with structure: {"CompanyName": [{"leetcode_number": "1", "problem_name": "Problem", ...}]}

Merge Logic:
- Combines arrays from both files for each company
- Prevents duplicate problems using leetcode_number as unique identifier  
- When duplicates found, merges item properties preferring non-empty values from first file
- Maintains order: first file items first, then new items from second file

Key Features:
- Smart property merging (prefers non-empty values)
- Duplicate prevention based on leetcode_number
- Handles missing companies in either file
- Preserves data integrity during merge process

Usage:
Set jsonPath1 and jsonPath2 variables to your file paths.
Output saved as mergedJSON.json with merge statistics.
"""

import json
import sys
from pathlib import Path

def load_json(file_path):
    """Load JSON data from file"""
    try:
        with open(file_path, 'r', encoding='utf-8') as file:
            return json.load(file)
    except FileNotFoundError:
        print(f"Error: File '{file_path}' not found.")
        sys.exit(1)
    except json.JSONDecodeError as e:
        print(f"Error: Invalid JSON in file '{file_path}': {e}")
        sys.exit(1)
    except Exception as e:
        print(f"Error reading file '{file_path}': {e}")
        sys.exit(1)

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

def save_json(data, filename='mergedJSON.json'):
    """Save JSON data to file"""
    try:
        with open(filename, 'w', encoding='utf-8') as file:
            json.dump(data, file, indent=2, ensure_ascii=False)
        print(f"Merged JSON saved successfully as '{filename}'")
    except Exception as e:
        print(f"Error saving file '{filename}': {e}")
        sys.exit(1)

def main():
    """Main function"""
    # Get the directory where this script is located
    script_dir = Path(__file__).parent
    
    # Fixed the filename typo here and use full paths
    jsonPath1 = script_dir / "companyTags.json"
    jsonPath2 = script_dir / "retrievedTags.json"  
    if not jsonPath1 or not jsonPath2:
        print("Error: Please set the jsonPath1 and jsonPath2 variables with your file paths")
        sys.exit(1)
    
    json1_path = jsonPath1
    json2_path = jsonPath2
    
    print(f"Loading JSON files...")
    print(f"File 1: {json1_path}")
    print(f"File 2: {json2_path}")
    
    # Load JSON files
    json1_data = load_json(json1_path)
    json2_data = load_json(json2_path)
    
    print("Merging JSON data...")
    
    # Merge the JSON data
    merged_data = merge_json_data(json1_data, json2_data)
    
    # Save the merged data
    save_json(merged_data)
    
    print("Merge completed successfully!")
    
    # Print summary
    print("\nSummary:")
    for key, value in merged_data.items():
        if isinstance(value, list):
            print(f"  {key}: {len(value)} items")
        else:
            print(f"  {key}: {type(value).__name__}")

if __name__ == "__main__":
    main()