class Solution {
    public String minWindow(String source, String target) {
        // Array to store the frequency of characters needed from the target string
        int[] charFrequencyInTarget = new int[128];
        // Array to store the frequency of characters in the current window of the source string
        int[] charFrequencyInWindow = new int[128];
      
        int sourceLength = source.length();
        int targetLength = target.length();
      
        // Populate the frequency array for the target string
        for (int i = 0; i < targetLength; ++i) {
            charFrequencyInTarget[target.charAt(i)]++;
        }
      
        int matchCount = 0; // Count of characters that matches from target
        int left = 0; // The start index of the current window
        int minWindowStart = -1; // The start index of the minimum window
        int minLength = Integer.MAX_VALUE; // Length of the smallest window
      
        // Iterate over the source string
        for (int right = 0; right < sourceLength; ++right) {
            // Include the current character in the window
            charFrequencyInWindow[source.charAt(right)]++;
          
            // If the character is needed and we have not more than needed, increase the match count
            if (charFrequencyInTarget[source.charAt(right)] >= charFrequencyInWindow[source.charAt(right)]) {
                matchCount++;
            }
          
            // When we have all characters from the target in our window
            while (matchCount == targetLength) {
                int windowLength = right - left + 1; // Get the current window's length
              
                // Update minimum length and starting index if a new minimum is found
                if (windowLength < minLength) {
                    minLength = windowLength;
                    minWindowStart = left;
                }
              
                // The character at window start is going to be removed since window is moving forward
                char charAtStart = source.charAt(left);
              
                // If the character is one that is needed and after removing there are not enough of it, decrease match count
                if (charFrequencyInTarget[charAtStart] >= charFrequencyInWindow[charAtStart]) {
                    matchCount--;
                }
              
                // Remove the character from the window
                charFrequencyInWindow[charAtStart]--;
                left++; // Move the window forward
            }
        }
      
        // Return the minimum window substring or an empty string if no such window exists
        return minWindowStart < 0 ? "" : source.substring(minWindowStart, minWindowStart + minLength);
    }
}