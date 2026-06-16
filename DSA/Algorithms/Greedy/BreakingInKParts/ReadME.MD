
# * **Code to return a single valid combination** (i.e., one solution where the sum of the parts is `N`, and each part lies between `a` and `b`).
* **Code to return all valid combinations**.

### Code to return a single valid combination:

This code uses a greedy approach to return one valid solution that satisfies the conditions.

Code 1

```java
class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int m = rolls.length;
        int totalSum = mean * (m + n);
        int rollsSum = 0;
      
        for (int roll : rolls) {
            rollsSum += roll;
        }
      
        int missingSum = totalSum - rollsSum;
      
        if (missingSum < n || missingSum > 6 * n) {
            return new int[0];
        }
      
        int[] result = new int[n];
        int quotient = missingSum / n;
        int remainder = missingSum % n;
      
        for (int i = 0; i < n; i++) {
            result[i] = quotient + (i < remainder ? 1 : 0);
        }
      
        return result;
    }
}
```

Code 2

```java
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static List<Integer> findOneCombination(int N, int k, int a, int b) {
        List<Integer> result = new ArrayList<>();
        int remainingSum = N;

        for (int i = 0; i < k; i++) {
            int maxPart = Math.min(b, remainingSum - (k - 1 - i) * a); // Ensure the sum can be completed
            int part = Math.max(a, remainingSum - (k - 1 - i) * b); // Ensure the minimum is respected
            result.add(part);
            remainingSum -= part;
        }

        return result;
    }

    public static void main(String[] args) {
        int N = 9;
        int k = 4;
        int a = 1;
        int b = 6;
      
        List<Integer> oneCombination = findOneCombination(N, k, a, b);
        System.out.println(oneCombination);
    }
}
```

### Code to return all valid combinations:

This code uses recursion to find all possible combinations that sum to `N` with `k` parts, each between `a` and `b`.

```java
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void findAllCombinations(int N, int k, int a, int b, List<Integer> current, List<List<Integer>> result) {
        if (k == 0) {
            if (N == 0) {
                result.add(new ArrayList<>(current));
            }
            return;
        }

        for (int i = a; i <= b; i++) {
            if (N - i >= 0) {
                current.add(i);
                findAllCombinations(N - i, k - 1, a, b, current, result);
                current.remove(current.size() - 1); // Backtrack
            }
        }
    }

    public static List<List<Integer>> getAllCombinations(int N, int k, int a, int b) {
        List<List<Integer>> result = new ArrayList<>();
        findAllCombinations(N, k, a, b, new ArrayList<>(), result);
        return result;
    }

    public static void main(String[] args) {
        int N = 9;
        int k = 4;
        int a = 1;
        int b = 6;

        List<List<Integer>> allCombinations = getAllCombinations(N, k, a, b);
        for (List<Integer> combination : allCombinations) {
            System.out.println(combination);
        }
    }
}
```

### Explanation:

1. **Single Combination Code**:

   - This code tries to find one valid combination by ensuring that the sum is spread evenly across all parts, without violating the constraints.
2. **All Combinations Code**:

   - This code generates all possible combinations recursively using backtracking, exploring all possible values for each part and storing valid results.

You can try running these codes to get the desired results!
