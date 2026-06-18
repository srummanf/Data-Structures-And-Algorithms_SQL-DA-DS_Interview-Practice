/**
 * Problem statement
You have been given two integers ‘N’ and ‘K’. Consider a set ‘X’ of all possible strings of ‘N’ number of digits such that all strings contain digits only in range 0 to ‘K’ inclusive.

For example, If ‘N’ is 2 and ‘K’ is ‘2’ then the set ‘X’ will be-

‘X’ = { 00, 01, 02, 10, 11, 12, 20, 21, 22 }.
Your task is to find a string of minimum possible length such that it contains all strings from set ‘X as any of its substring.

Note:

If there are more than one possible such strings, then you can output any of them.
Detailed explanation ( Input/output format, Notes, Images )
Sample Input 1:
2
2 1
1 0
Sample Output 1:
00110
0
Explanation of Sample Input 1:
Test case 1:
Total possible 2-digit strings that have {0, 1} digits only are {00, 01, 10,11}, the string ‘00110’ contains all these numbers as a substring and has the minimum possible size, ‘11001’ is also a correct string.

Test case 2:
Only possible string is 0 so the string with the minimum possible size is ‘0’ itself.
Sample Input 2:
1
1 1
Sample Output 2:
10
Explanation of Sample Input 2:
Test case 1:
The total possible 1-digit numbers are 1 and 0, the string ‘10’ is the smallest string that contains both these strings as a substring. 

String ‘01’ is also a valid answer.
 */

import java.util.HashMap;

public class deBruijnSequence {

    public static String getMinString(int n, int k) {
        StringBuilder answer = new StringBuilder(); // Use StringBuilder for efficient string manipulation
        
        // Initialize answer with "000...0" n times
        for (int i = 0; i < n; i++) {
            answer.append("0");
        }
        
        HashMap<String, Boolean> visited = new HashMap<>(); // HashMap to keep track of visited nodes
        visited.put(answer.toString(), true); // Mark initial node as visited
        
        // Run dfs to find a Hamiltonian Path
        dfs(n, k, answer, visited);
        
        return answer.toString(); // Return the minimum string
    }
    
    private static boolean dfs(int n, int k, StringBuilder answer, HashMap<String, Boolean> visited) {
        // If all nodes have been visited
        if (visited.size() == Math.pow(k + 1, n)) {
            return true; // Hamiltonian Path found
        }
        
        // Loop through possible digits
        for (int i = 0; i <= k; i++) {
            String currNode = answer.substring(1) + i; // Create new node by adding digit i to answer's suffix
            if (!visited.containsKey(currNode)) { // If current node hasn't been visited
                visited.put(currNode, true); // Mark current node as visited
                answer.append(i); // Append digit i to answer
                
                // If adding digit i leads to a valid path
                if (dfs(n, k, answer, visited)) {
                    return true;
                }
                
                // If adding digit i didn't lead to a valid path, backtrack
                visited.remove(currNode);
                answer.deleteCharAt(answer.length() - 1);
            }
        }
        
        return false; // No valid path found
    }
}
