/*
1207. Unique Number of Occurrences
 * Given an array of integers arr, return true if the number of occurrences of each value in the array is unique or false otherwise.

 

Example 1:

Input: arr = [1,2,2,1,1,3]
Output: true
Explanation: The value 1 has 3 occurrences, 2 has 2 and 3 has 1. No two values have the same number of occurrences.
Example 2:

Input: arr = [1,2]
Output: false
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class UniqueNumberofOccurrences {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> m = new HashMap<>();
        ArrayList<Integer> ar = new ArrayList<>();
        for(int x : arr){
            m.put(x, m.getOrDefault(x, 0) + 1);
        }
        for(Map.Entry<Integer, Integer> e : m.entrySet()){
            ar.add(e.getValue());
        }
        Collections.sort(ar);
        int n = ar.size();
        for(int i = 0; i<n-1; i++){
            if(ar.get(i) == ar.get(i+1)){
                return false;
            }
        }
        return true;
        
    }
// Sol 2
    public boolean uniqueOccurrences2(int[] arr) {
        // Create a hashmap to store the counts of each number.
        Map<Integer, Integer> countMap = new HashMap<>();
      
        // Iterate over the array and populate the countMap.
        for (int number : arr) {
            // If the number is already in the map, increment its count, otherwise insert it with count 1.
            countMap.merge(number, 1, Integer::sum);
        }
      
        // Create a hashset containing all the values (occurrence counts) from the countMap.
        HashSet<Integer> occurrenceSet = new HashSet<>(countMap.values());
      
        // If the size of the set (unique occurrences) is the same as the size of the map (unique numbers),
        // it means that all occurrence counts are unique and we return true. Otherwise, return false.
        return occurrenceSet.size() == countMap.size();
    }
}
