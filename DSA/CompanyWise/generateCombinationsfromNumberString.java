 /**
 * Sure! Here's the documentation for the given Java code, including detailed explanations, flowchart, and edge case considerations.

## Problem Statement

You are given a string `S` of length `N` which consists of digits from 0 to 9 only. If the mapping of characters from a to z is like a = 1, b = 2, c = 3… z = 26, you need to convert the given string of digits into a string of characters using the mapping.

Print all the possible strings that can be generated from the given string `S` in non-decreasing sorted lexicographical order.

### Example

Input:
```
2
112
123
```

Output:
```
aab aal ak bkb 
aaw abc aw lc 
```

## Code Explanation

### Import Statements

```java
import java.util.*;
```

### Main Class

```java
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        scanner.nextLine(); // consume the remaining newline character
        List<String> results = new ArrayList<>();

        for (int t = 0; t < T; t++) {
            String S = scanner.nextLine();
            List<String> combinations = new ArrayList<>();
            generateCombinations(S, 0, "", combinations);
            Collections.sort(combinations);
            results.add(String.join(" ", combinations));
        }

        for (String result : results) {
            System.out.println(result);
        }
    }

    private static void generateCombinations(String S, int index, String current, List<String> combinations) {
        if (index == S.length()) {
            combinations.add(current);
            return;
        }

        // Single digit
        int num1 = S.charAt(index) - '0';
        if (num1 >= 1 && num1 <= 9) {
            generateCombinations(S, index + 1, current + (char) ('a' + num1 - 1), combinations);
        }

        // Double digit
        if (index + 1 < S.length()) {
            int num2 = Integer.parseInt(S.substring(index, index + 2));
            if (num2 >= 10 && num2 <= 26) {
                generateCombinations(S, index + 2, current + (char) ('a' + num2 - 1), combinations);
            }
        }
    }
}
```

### Detailed Explanation

1. **Input Handling**: 
    - Read the number of test cases `T`.
    - Read each string `S` for each test case.
   
2. **Generating Combinations**: 
    - Use the `generateCombinations` method to recursively generate all possible combinations of characters for the given string `S`.
    - The method considers both single-digit and double-digit mappings.
    - It adds the corresponding character to the current string if the mapping is valid (i.e., between 1 and 26).

3. **Sorting and Storing Results**:
    - After generating all combinations for a test case, sort the combinations lexicographically and store them in the results list.

4. **Output**:
    - Print the results for all test cases.

### Function: `generateCombinations`

- **Parameters**:
    - `String S`: The input string.
    - `int index`: The current index in the string.
    - `String current`: The current combination being generated.
    - `List<String> combinations`: The list to store all possible combinations.
    
- **Recursive Logic**:
    - Base Case: If `index == S.length()`, add `current` to `combinations`.
    - Single Digit Mapping: Convert the single digit to a character and recursively call the function.
    - Double Digit Mapping: Convert the double digits to a character and recursively call the function if valid.

### Flowchart

1. Start
2. Read number of test cases `T`
3. For each test case:
    - Read string `S`
    - Initialize empty list `combinations`
    - Call `generateCombinations(S, 0, "", combinations)`
    - Sort `combinations` lexicographically
    - Store the sorted combinations in `results`
4. Print all results
5. End

### Edge Cases

- **Single Digit Strings**: The code handles single digit strings by considering them as valid mappings if they are between 1 and 9.
- **Only Valid Mappings**: Strings that only have valid single or double digit mappings will be processed correctly.
- **Leading Zeros**: Not necessary to handle separately as input consists of valid digits from 0 to 9 and each character in `S` will be processed correctly.

### Dry Run for Input `112`

- Initial call to `generateCombinations("112", 0, "", combinations)`
- Recursive steps:
    - `generateCombinations("112", 1, "a", combinations)` and so on.
    - Continue generating combinations until all possible strings are generated.
- Sort and print combinations: `["aab", "aal", "ak", "bkb"]`

By following these steps, the code ensures all valid combinations are generated and sorted lexicographically for each test case.
 */

import java.util.*;

public class generateCombinationsfromNumberString {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int T = scanner.nextInt();
    scanner.nextLine(); // consume the remaining newline character
    List<String> results = new ArrayList<>();

    for (int t = 0; t < T; t++) {
      String S = scanner.nextLine();
      List<String> combinations = new ArrayList<>();
      generateCombinations(S, 0, "", combinations);
      Collections.sort(combinations);
      results.add(String.join(" ", combinations));
    }

    for (String result : results) {
      System.out.println(result);
    }
  }

  private static void generateCombinations(
    String S,
    int index,
    String current,
    List<String> combinations
  ) {
    if (index == S.length()) {
      combinations.add(current);
      return;
    }

    // Single digit
    int num1 = S.charAt(index) - '0';
    if (num1 >= 1 && num1 <= 9) {
      generateCombinations(
        S,
        index + 1,
        current + (char) ('a' + num1 - 1),
        combinations
      );
    }

    // Double digit
    if (index + 1 < S.length()) {
      int num2 = Integer.parseInt(S.substring(index, index + 2));
      if (num2 >= 10 && num2 <= 26) {
        generateCombinations(
          S,
          index + 2,
          current + (char) ('a' + num2 - 1),
          combinations
        );
      }
    }
  }
}
/***
 * import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Example usage
        String s = "112";
        String[] result = getAllStrings(s);
        System.out.println(Arrays.toString(result));
    }

    public static String[] getAllStrings(String s) {
        List<String> combinations = new ArrayList<>();
        generateCombinations(s, 0, "", combinations);
        Collections.sort(combinations);
        return combinations.toArray(new String[0]);
    }

    private static void generateCombinations(String s, int index, String current, List<String> combinations) {
        if (index == s.length()) {
            combinations.add(current);
            return;
        }

        // Single digit
        int num1 = s.charAt(index) - '0';
        if (num1 >= 1 && num1 <= 9) {
            generateCombinations(s, index + 1, current + (char) ('a' + num1 - 1), combinations);
        }

        // Double digit
        if (index + 1 < s.length()) {
            int num2 = Integer.parseInt(s.substring(index, index + 2));
            if (num2 >= 10 && num2 <= 26) {
                generateCombinations(s, index + 2, current + (char) ('a' + num2 - 1), combinations);
            }
        }
    }
}

 */
