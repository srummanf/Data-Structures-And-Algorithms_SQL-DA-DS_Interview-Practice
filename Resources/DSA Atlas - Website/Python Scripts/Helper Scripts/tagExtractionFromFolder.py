"""
LeetCode Company-wise Problems CSV to JSON Converter

This script processes CSV files containing LeetCode problems organized by company
and converts them into a structured JSON format for easy consumption.

Features:
- Automatically detects CSV directory structure
- Fetches LeetCode question IDs from external API
- Generates structured JSON with problem metadata
- Includes error handling and progress tracking
- Creates solution links for algo.monster

Input Structure:
CompanyCSV/
├── Company1/
│   └── 5. All.csv
├── Company2/
│   └── 5. All.csv
└── ...

CSV Format:
Difficulty | Title | Frequency | Acceptance Rate | Link | Topics

Output: retrievedTags.json
{
  "CompanyName": [
    {
      "problem_name": "Problem Title",
      "leetcode_number": "123",
      "leetcode_link": "https://leetcode.com/problems/problem-title/",
      "solution_yt_link": "https://algo.monster/liteproblems/123",
      "intuition": "",
      "key_steps": ""
    }
  ]
}

Data Source:
Based on the repository: https://github.com/liquidslr/leetcode-company-wise-problems
API Endpoint: https://leetcode-api-pied.vercel.app/problem/{problem_name}

Author: Generated for LeetCode problem organization
Usage: python script.py
"""

import os
import csv
import json
import requests
import time
from urllib.parse import urlparse

def extract_problem_name_from_url(url):
    """Extract problem name from LeetCode URL"""
    try:
        parsed_url = urlparse(url)
        path_parts = parsed_url.path.split('/')
        if 'problems' in path_parts:
            problem_index = path_parts.index('problems')
            if problem_index + 1 < len(path_parts):
                return path_parts[problem_index + 1]
    except:
        pass
    return None

def get_leetcode_number(problem_name):
    """Get LeetCode question ID from the API"""
    try:
        api_url = f"https://leetcode-api-pied.vercel.app/problem/{problem_name}"
        response = requests.get(api_url, timeout=10)
        
        if response.status_code == 200:
            data = response.json()
            return data.get('questionId', '')
        else:
            print(f"API request failed for {problem_name}: Status {response.status_code}")
            return ''
    except Exception as e:
        print(f"Error fetching data for {problem_name}: {str(e)}")
        return ''

def process_csv_file(csv_path):
    """Process a single CSV file and return list of problems"""
    problems = []
    
    try:
        with open(csv_path, 'r', encoding='utf-8') as file:
            csv_reader = csv.DictReader(file)
            
            for row in csv_reader:
                title = row.get('Title', '').strip()
                link = row.get('Link', '').strip()
                
                if title and link:
                    # Extract problem name from URL
                    problem_name_from_url = extract_problem_name_from_url(link)
                    
                    if problem_name_from_url:
                        print(f"Processing: {title}")
                        
                        # Get LeetCode number from API
                        leetcode_number = get_leetcode_number(problem_name_from_url)
                        
                        # Create problem entry
                        problem_entry = {
                            "problem_name": title,
                            "leetcode_number": leetcode_number,
                            "leetcode_link": link,
                            "solution_yt_link": f"https://algo.monster/liteproblems/{leetcode_number}" if leetcode_number else "",
                            "intuition": "",
                            "key_steps": ""
                        }
                        
                        problems.append(problem_entry)
                        
                        # Add small delay to avoid overwhelming the API
                        time.sleep(0.1)
                    else:
                        print(f"Could not extract problem name from URL: {link}")
                        
    except Exception as e:
        print(f"Error processing CSV file {csv_path}: {str(e)}")
    
    return problems

def process_company_folders(base_path):
    """Process all company folders and generate JSON"""
    result = {}
    
    # Check if base path exists
    if not os.path.exists(base_path):
        print(f"Error: Base path '{base_path}' does not exist!")
        return result
    
    # Iterate through all folders in the base path
    for folder_name in os.listdir(base_path):
        folder_path = os.path.join(base_path, folder_name)
        
        # Skip if not a directory
        if not os.path.isdir(folder_path):
            continue
        
        csv_file_path = os.path.join(folder_path, "5. All.csv")
        
        # Check if the CSV file exists
        if os.path.exists(csv_file_path):
            print(f"\nProcessing folder: {folder_name}")
            problems = process_csv_file(csv_file_path)
            
            if problems:
                result[folder_name] = problems
                print(f"Added {len(problems)} problems for {folder_name}")
            else:
                print(f"No problems found for {folder_name}")
        else:
            print(f"CSV file not found in {folder_name}: {csv_file_path}")
    
    return result

def save_json_file(data, output_file):
    """Save data to JSON file"""
    try:
        with open(output_file, 'w', encoding='utf-8') as file:
            json.dump(data, file, indent=2, ensure_ascii=False)
        print(f"\nJSON file saved successfully: {output_file}")
    except Exception as e:
        print(f"Error saving JSON file: {str(e)}")

def main():
    # Hardcode your filepath here
    filepath = "../Parsed Data/Leetcode Companywise CSV by liquidslr" 
    
    if not filepath:
        print("Please set the 'filepath' variable to your CompanyCSV folder path")
        return
    
    print("Starting CSV to JSON conversion...")
    print(f"Base path: {filepath}")
    
    # Process all company folders
    result_data = process_company_folders(filepath)
    
    if result_data:
        # Save to JSON file
        output_file = "retrievedTags.json"
        save_json_file(result_data, output_file)
        
        # Print summary
        total_problems = sum(len(problems) for problems in result_data.values())
        print(f"\nConversion completed!")
        print(f"Total companies processed: {len(result_data)}")
        print(f"Total problems processed: {total_problems}")
    else:
        print("No data was processed. Please check your file paths and CSV structure.")

if __name__ == "__main__":
    main()