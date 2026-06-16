"""
JSON Refactoring Script for LeetCode Problems

This script transforms LeetCode problem data from a flat structure to a company-grouped structure.

Input Format:
- Reads input.json with structure: {"data": [{"id": 1, "title": "Problem", "slug": "problem", "companies": [{"name": "Google"}]}]}

Output Format:
- Creates refactoredJSON.json grouped by companies: {"Google": [{"problem_name": "Problem", "leetcode_number": "1", ...}]}

Key Features:
- Groups problems by company names
- Removes duplicate problems per company
- Sorts companies alphabetically and problems by LeetCode number
- Generates LeetCode URLs from problem slugs
- Adds placeholder fields for solution links, intuition, and key steps

Usage:
Place input.json in the same directory and run the script.
Output will be saved as refactoredJSON.json with processing statistics.

JSON Source:
https://github.com/seanprashad/leetcode-patterns/blob/main/src/data/questions.json
"""


import json
import os

def refactor_json(input_filename):
    """
    Reads a JSON file and refactors it to group problems by company names.
    
    Args:
        input_filename (str): Name of the input JSON file
    """
    
    # Read the input JSON file
    try:
        with open(input_filename, 'r', encoding='utf-8') as file:
            data = json.load(file)
    except FileNotFoundError:
        print(f"Error: File '{input_filename}' not found in the current directory.")
        return
    except json.JSONDecodeError:
        print(f"Error: Invalid JSON format in '{input_filename}'.")
        return
    
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
    
    # Write the refactored JSON to a new file
    output_filename = 'refactoredJSON.json'
    try:
        with open(output_filename, 'w', encoding='utf-8') as file:
            json.dump(sorted_refactored_data, file, indent=2, ensure_ascii=False)
        
        print(f"✅ Successfully created '{output_filename}' in the current directory.")
        print(f"📊 Processed {len(data.get('data', []))} problems")
        print(f"🏢 Found {len(sorted_refactored_data)} companies")
        
        # Display summary
        print("\n📋 Company Summary:")
        for company, problems in sorted_refactored_data.items():
            print(f"   {company}: {len(problems)} problems")
            
    except Exception as e:
        print(f"Error writing to '{output_filename}': {str(e)}")

def main():
    """
    Main function to run the JSON refactoring process.
    """
    print("🔄 JSON Refactoring Tool")
    print("=" * 50)
    
    # Show current directory and files for debugging
    current_dir = os.getcwd()
    print(f"📁 Current directory: {current_dir}")
    
    # Hardcoded JSON file path - update this to the correct path
    input_file = "Python Scripts/Refactoring/input.json"  # Path to input file
    
    # Check if file exists before processing
    if os.path.exists(input_file):
        print(f"\n🚀 Processing: {input_file}")
        refactor_json(input_file)
    else:
        print(f"\n❌ File '{input_file}' not found!")
        print("💡 Make sure the path is correct.")
        
        # Try to find the file in common locations
        possible_paths = [
            "input.json",
            "Refactoring/input.json", 
            "Python Scripts/input.json",
            "Python Scripts/Refactoring/input.json"
        ]
        
        print("\n🔍 Checking possible locations:")
        for path in possible_paths:
            if os.path.exists(path):
                print(f"   ✅ Found: {path}")
            else:
                print(f"   ❌ Not found: {path}")

if __name__ == "__main__":
    main()