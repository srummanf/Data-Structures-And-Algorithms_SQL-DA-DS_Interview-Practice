""" """

import os
import json
from pathlib import Path

def save_filenames_to_json(folder_path, output_filename):
    """
    Read all file names from a folder and save them to a JSON file in ./data directory.
    
    Args:
        folder_path (str): Path to the folder to scan for files
        output_filename (str): Name of the output JSON file (without extension)
    """
    try:
        # Ensure the data directory exists in current folder
        data_dir = Path("data")
        data_dir.mkdir(exist_ok=True)
        
        # Get the folder path
        folder = Path(folder_path)
        
        if not folder.exists():
            print(f"Error: Folder '{folder_path}' does not exist.")
            return
        
        if not folder.is_dir():
            print(f"Error: '{folder_path}' is not a directory.")
            return
        
        # Get all file names (excluding directories)
        file_names = []
        for item in folder.iterdir():
            if item.is_file():
                file_names.append(item.name)
        
        # Create the data structure
        data = {
            "folder_path": str(folder.absolute()),
            "total_files": len(file_names),
            "file_names": sorted(file_names)  # Sort for consistent output
        }
        
        # Create output file path
        output_path = data_dir / f"{output_filename}.json"
        
        # Save to JSON file
        with open(output_path, 'w', encoding='utf-8') as f:
            json.dump(data, f, indent=2, ensure_ascii=False)
        
        print(f"Successfully saved {len(file_names)} file names to {output_path}")
        
    except PermissionError:
        print("Error: Permission denied. Make sure you have write access to ./data directory.")
    except Exception as e:
        print(f"An error occurred: {e}")

def main():
    # Example usage
    folder_to_scan = "./Data Structures and Algorithms/Algorithms/Two Pointer and Sliding Window"
    output_name = "fileName"
    
    if not output_name:
        output_name = "filenames"
    
    save_filenames_to_json(folder_to_scan, output_name)

if __name__ == "__main__":
    main()