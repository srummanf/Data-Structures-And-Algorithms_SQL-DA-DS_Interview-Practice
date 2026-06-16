import re
import json
from urllib.parse import urlparse

def extract_leetcode_number_from_url(url):
    """Extract leetcode problem number from URL"""
    # Pattern to match leetcode problem URLs and extract problem name
    pattern = r'https://leetcode\.com/problems/([^/]+)/'
    match = re.search(pattern, url)
    if match:
        problem_slug = match.group(1)
        # Try to find a number in the problem slug (some problems have numbers)
        number_match = re.search(r'(\d+)', problem_slug)
        if number_match:
            return number_match.group(1)
        else:
            # For problems without clear numbers, we'll need to map them
            # For now, return empty string
            return ""
    return ""

def extract_leetcode_number_from_solution(solution_url):
    """Extract leetcode problem number from solution URL"""
    # Pattern to match solution URLs like _2176.java or _1.java
    pattern = r'/_(\d+)\.java'
    match = re.search(pattern, solution_url)
    if match:
        return match.group(1)
    
    # Also try pattern for other file types
    pattern = r'/_(\d+)\.(cpp|js|py)'
    match = re.search(pattern, solution_url)
    if match:
        return match.group(1)
    
    return ""

def extract_problem_name_from_link(link_text):
    """Extract problem name from markdown link"""
    # Pattern to match [Problem Name](URL)
    pattern = r'\[([^\]]+)\]\([^)]+\)'
    match = re.search(pattern, link_text)
    if match:
        return match.group(1)
    return ""

def extract_url_from_link(link_text):
    """Extract URL from markdown link"""
    # Pattern to match [Text](URL)
    pattern = r'\[([^\]]+)\]\(([^)]+)\)'
    match = re.search(pattern, link_text)
    if match:
        return match.group(2)
    return ""

def parse_readme_to_json(readme_content):
    """Parse README content and convert to JSON format"""
    result = {}
    
    # Split content into lines
    lines = readme_content.split('\n')
    
    current_company = None
    in_table = False
    
    for i, line in enumerate(lines):
        line = line.strip()
        
        # Check if this is a company header (## Company Name)
        if line.startswith('## ') and not line.startswith('## Company Index'):
            current_company = line[3:].strip()  # Remove '## '
            result[current_company] = []
            in_table = False
            continue
        
        # Check if we're starting a table (header row)
        if current_company and '|' in line and 'Occurence' in line and 'Problem' in line:
            in_table = True
            continue
            
        # Skip table separator line
        if current_company and in_table and line.startswith('|') and '---' in line:
            continue
            
        # Process table data rows
        if current_company and in_table and line.startswith('|') and '---' not in line and line.count('|') >= 4:
            # Split the table row
            columns = [col.strip() for col in line.split('|')[1:-1]]  # Remove first and last empty elements
            
            if len(columns) >= 3:
                occurrence = columns[0].strip()
                problem_cell = columns[1].strip()
                difficulty = columns[2].strip()
                solution_cell = columns[3].strip() if len(columns) > 3 else ""
                
                # Extract problem name and URL
                problem_name = extract_problem_name_from_link(problem_cell)
                leetcode_url = extract_url_from_link(problem_cell)
                leetcode_number = extract_leetcode_number_from_url(leetcode_url)
                
                # Extract solution URL (could be multiple solutions)
                solution_links = []
                if solution_cell:
                    # Handle multiple solution links
                    solution_urls = re.findall(r'\]\(([^)]+)\)', solution_cell)
                    if solution_urls:
                        solution_links = solution_urls
                
                # If we couldn't get leetcode number from problem URL, try solution URL
                if not leetcode_number and solution_links:
                    leetcode_number = extract_leetcode_number_from_solution(solution_links[0])
                
                # Create the problem entry
                problem_entry = {
                    "problem_name": problem_name,
                    "leetcode_number": leetcode_number,
                    "leetcode_link": leetcode_url,
                    "solution_yt_link": solution_links[0] if solution_links else "",
                    "intuition": "",
                    "key_steps": ""
                }
                
                result[current_company].append(problem_entry)
        
        # Reset when we hit a new section or end of table
        if line.startswith('## ') or (line == '' and in_table):
            in_table = False
    
    return result

def main():
    # Hardcoded README file path
    readme_file_path = "company.md"  # Change this to your README file path
    
    try:
        # Read the README file content
        with open(readme_file_path, 'r', encoding='utf-8') as file:
            readme_content = file.read()
        
        print(f"Successfully read README file from: {readme_file_path}")
        
    except FileNotFoundError:
        print(f"Error: README file not found at path: {readme_file_path}")
        print("Please update the readme_file_path variable with the correct path.")
        return
    except Exception as e:
        print(f"Error reading README file: {str(e)}")
        return
    
    # Parse the README content
    parsed_data = parse_readme_to_json(readme_content)
    
    # Save to JSON file as parsedTag.json
    output_file = "parsedTag.json"
    try:
        with open(output_file, 'w', encoding='utf-8') as json_file:
            json.dump(parsed_data, json_file, indent=2, ensure_ascii=False)
        
        print(f"Successfully parsed README and saved to {output_file}")
        print(f"Found {len(parsed_data)} companies:")
        for company, problems in parsed_data.items():
            print(f"  - {company}: {len(problems)} problems")
        
        # Display sample output
        print(f"\nSample output from {output_file}:")
        print(json.dumps(parsed_data, indent=2)[:500] + "...")
        
    except Exception as e:
        print(f"Error saving to {output_file}: {str(e)}")
        return

if __name__ == "__main__":
    main()