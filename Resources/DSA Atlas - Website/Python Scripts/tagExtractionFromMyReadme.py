import re
import json
import os
from urllib.parse import urlparse
from typing import Dict, List, Set
from pathlib import Path

class DSADataExtractor:
    def __init__(self, readme_path: str = "docs/DSA-Sheet-by-SRF.md", 
                 output_path: str = "data/parsedCompanyTagsFromMyPractice.json"):
        self.readme_path = readme_path
        self.output_path = output_path
        self.company_data = {}
        
    def extract_leetcode_number(self, link: str) -> str:
        """Extract leetcode problem number from markdown link format or URL"""
        if not link or link == "---":
            return "N/A"
        
        # Handle markdown link format: [LeetCode 1208](URL)
        markdown_match = re.search(r'\[([^\]]+)\]', link)
        if markdown_match:
            link_text = markdown_match.group(1)  # Extract text inside brackets
            # Tokenize and find number after "LeetCode"
            tokens = link_text.split()
            for i, token in enumerate(tokens):
                if token.lower() == "leetcode" and i + 1 < len(tokens):
                    # Get next token which should be the number
                    next_token = tokens[i + 1]
                    number_match = re.search(r'(\d+)', next_token)
                    if number_match:
                        return number_match.group(1)
            
            # If no "LeetCode" keyword found, look for any number in the bracket text
            number_match = re.search(r'(\d+)', link_text)
            if number_match:
                return number_match.group(1)
        
        # Extract number from URL like https://leetcode.com/problems/problem-name/
        if "leetcode.com" in link:
            # Try to extract number from URL path
            match = re.search(r'/problems/([^/]+)/', link)
            if match:
                problem_slug = match.group(1)
                # Look for number in the slug
                number_match = re.search(r'(\d+)', problem_slug)
                return number_match.group(1) if number_match else "N/A"
        
        # Fallback: Extract from any text like "LeetCode 1423"
        number_match = re.search(r'(\d+)', link)
        return number_match.group(1) if number_match else "N/A"
    
    def clean_link(self, link: str) -> str:
        """Clean and validate links, extract URL from markdown format"""
        if not link or link.strip() in ["---", "*---*", ""]:
            return "N/A"
        
        link = link.strip()
        
        # Extract URL from markdown link format: [text](URL)
        markdown_url_match = re.search(r'\[([^\]]*)\]\(([^)]+)\)', link)
        if markdown_url_match:
            return markdown_url_match.group(2)  # Return the URL part
        
        # If it's already a plain URL, return as is
        return link
    
    def parse_companies(self, company_str: str) -> List[str]:
        """Parse company string and return list of companies"""
        if not company_str or company_str.strip() in ["---", ""]:
            return []
        
        # Split by comma and clean each company name
        companies = [company.strip() for company in company_str.split(',')]
        # Remove empty strings and invalid entries
        companies = [company for company in companies if company and company not in ["---", ""]]
        return companies
    
    def parse_markdown_table(self) -> None:
        """Parse the markdown table and extract data"""
        # Get the directory where this script is located
        script_dir = Path(__file__).parent
        readme_full_path = script_dir / self.readme_path
        
        try:
            with open(readme_full_path, 'r', encoding='utf-8') as file:
                content = file.read()
        except FileNotFoundError:
            print(f"Error: File '{readme_full_path}' not found.")
            return
        
        # Split content by lines and process line by line
        lines = content.split('\n')
        
        print(f"📊 Processing {len(lines)} lines from README.md")
        
        # Find lines that look like table data rows
        table_rows = []
        for line in lines:
            # Check if line has the table format (starts and ends with |, has enough | separators)
            if line.strip().startswith('|') and line.strip().endswith('|') and line.count('|') >= 6:
                # Skip header rows and separator rows
                if not any(x in line for x in ['Problem', 'Link', 'Intuition', 'Key Steps', 'Company', 'Video']) and \
                   not line.strip().replace('|', '').replace('-', '').replace(' ', '') == '':
                    table_rows.append(line)
        
        print(f"📊 Found {len(table_rows)} valid table rows")
        
        for i, line in enumerate(table_rows):
            # Split by | and clean up
            cells = [cell.strip() for cell in line.split('|')[1:-1]]  # Remove empty first and last elements
            
            if len(cells) >= 6:
                problem_name = cells[0].strip()
                leetcode_link = self.clean_link(cells[1].strip())
                intuition = cells[2].strip()
                key_steps = cells[3].strip()
                company_str = cells[4].strip()
                video_link = self.clean_link(cells[5].strip())
                
                print(f"\n📝 Processing row {i+1}:")
                print(f"   Problem: {problem_name}")
                print(f"   Companies: {company_str}")
                
                # Skip empty rows
                if not problem_name or problem_name in ["---", ""]:
                    print("   ⏭️  Skipping empty problem name")
                    continue
                
                # Extract leetcode number
                leetcode_number = self.extract_leetcode_number(cells[1].strip())  # Use original link for number extraction
                print(f"   LeetCode Number: {leetcode_number}")
                print(f"   LeetCode Link: {leetcode_link}")
                print(f"   Video Link: {video_link}")
                
                # Parse companies
                companies = self.parse_companies(company_str)
                print(f"   Parsed Companies: {companies}")
                
                # Create problem data
                problem_data = {
                    "problem_name": problem_name,
                    "leetcode_number": leetcode_number,
                    "leetcode_link": leetcode_link,
                    "solution_yt_link": video_link,
                    "intuition": intuition,
                    "key_steps": key_steps
                }
                
                # Add to each company
                for company in companies:
                    if company not in self.company_data:
                        self.company_data[company] = []
                    
                    # Check for duplicates ONLY within this specific company
                    existing_problems = {
                        (p["problem_name"], p["leetcode_number"]) 
                        for p in self.company_data[company]
                    }
                    
                    problem_tuple = (problem_name, leetcode_number)
                    if problem_tuple not in existing_problems:
                        self.company_data[company].append(problem_data)
                        print(f"✅ Added '{problem_name}' to {company}")
                    else:
                        print(f"⚠️  '{problem_name}' already exists in {company}, skipping")
            else:
                print(f"⚠️  Row {i+1} doesn't have enough columns: {len(cells)}")
    
    def save_to_json(self) -> None:
        """Save extracted data to JSON file"""
        # Get the directory where this script is located and create output path relative to it
        script_dir = Path(__file__).parent
        output_full_path = script_dir / self.output_path
        
        # Create data directory if it doesn't exist
        os.makedirs(output_full_path.parent, exist_ok=True)
        
        try:
            with open(output_full_path, 'w', encoding='utf-8') as file:
                json.dump(self.company_data, file, indent=2, ensure_ascii=False)
            print(f"✅ Data successfully extracted and saved to '{output_full_path}'")
            print(f"📊 Total companies: {len(self.company_data)}")
            
            # Print summary
            for company, problems in self.company_data.items():
                print(f"   - {company}: {len(problems)} problem(s)")
                
        except Exception as e:
            print(f"❌ Error saving to JSON: {e}")
    
    def load_existing_data(self) -> None:
        """Load existing JSON data to merge with new data"""
        script_dir = Path(__file__).parent
        output_full_path = script_dir / self.output_path
        
        if os.path.exists(output_full_path):
            try:
                with open(output_full_path, 'r', encoding='utf-8') as file:
                    existing_data = json.load(file)
                    
                # Clear existing data and start fresh to avoid duplicates
                self.company_data = {}
                            
                print("📥 Starting fresh extraction (existing file will be overwritten).")
            except Exception as e:
                print(f"⚠️ Warning: Could not load existing data: {e}")
        else:
            print("📄 No existing file found. Creating new extraction.")
    
    def extract_and_save(self) -> None:
        """Main method to extract data and save to JSON"""
        print("🚀 Starting DSA data extraction...")
        
        # Start fresh (don't load existing data to avoid merge issues)
        self.load_existing_data()
        
        # Parse markdown and extract new data
        self.parse_markdown_table()
        
        # Remove empty company entries
        self.company_data = {k: v for k, v in self.company_data.items() if v}
        
        # Save combined data
        self.save_to_json()
        
        print("✨ Extraction completed!")

def main():
    """Main function to run the extractor"""
    # You can customize these paths as needed
    extractor = DSADataExtractor(
        readme_path="../docs/DSA-Sheet-by-SRF.md",
        output_path="../data/parsedCompanyTagsFromMyPractice.json"
    )
    
    extractor.extract_and_save()

if __name__ == "__main__":
    main()