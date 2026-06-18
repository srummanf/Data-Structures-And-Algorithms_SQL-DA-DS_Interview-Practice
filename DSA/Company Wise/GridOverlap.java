/**
 * ### Problem Statement

You are given two binary grids `MAT1` and `MAT2` of size `N x N` each. Both grids contain either 0 or 1 in each cell.

You can perform four types of operations on `MAT1`:
- Right Shift
- Left Shift
- Up Shift
- Down Shift

For any cell A in `MAT1` with a 1 and cell B in `MAT2` with a 1, we can define a linear transformation L as the difference in their coordinates `(difference in X-coordinates of A and B, difference in Y-coordinates of A and B)`. Cells that come under the same overlapping zone will have the same value of L.

### Algorithm

1. Store all cells with 1s in `MAT1` in a list.
2. Store all cells with 1s in `MAT2` in another list.
3. Declare a hashmap `frequency` to store the count of the linear transformation.
4. For each element in the first list, calculate the value of L for each element in the second list using two nested loops.
    - Increment `frequency[L]` by 1.
5. The maximum count of an element in the hashmap `frequency` will be the answer.

### Example

**Input:**

```
MAT1:
1 1 0
0 0 0
0 0 0

MAT2:
0 1 1
0 0 0
0 0 0
```

**Output:** `2`

**Explanation:**

Let's step through the code and visualize how it works for the provided example.

### Code

```java
import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

public class Solution {
    public static int gridOverlap(ArrayList<ArrayList<Integer>> mat1, ArrayList<ArrayList<Integer>> mat2, int n) {
        // List to store coordinates of 1s in mat1
        List<int[]> onesInMAT1 = new ArrayList<>();
        // List to store coordinates of 1s in mat2
        List<int[]> onesInMAT2 = new ArrayList<>();

        // Populate the lists with coordinates of 1s
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (mat1.get(i).get(j) == 1) {
                    onesInMAT1.add(new int[]{i, j});
                }
                if (mat2.get(i).get(j) == 1) {
                    onesInMAT2.add(new int[]{i, j});
                }
            }
        }

        // HashMap to store the frequency of linear transformations
        Map<String, Integer> frequency = new HashMap<>();

        // Calculate the linear transformations and update frequency
        for (int[] cell1 : onesInMAT1) {
            for (int[] cell2 : onesInMAT2) {
                int dx = cell2[0] - cell1[0];
                int dy = cell2[1] - cell1[1];
                String key = dx + "," + dy;
                frequency.put(key, frequency.getOrDefault(key, 0) + 1);
            }
        }

        // Find the maximum frequency
        int maxOverlap = 0;
        for (int count : frequency.values()) {
            maxOverlap = Math.max(maxOverlap, count);
        }

        return maxOverlap;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> mat1 = new ArrayList<>();
        mat1.add(new ArrayList<>(Arrays.asList(1, 1, 0)));
        mat1.add(new ArrayList<>(Arrays.asList(0, 0, 0)));
        mat1.add(new ArrayList<>(Arrays.asList(0, 0, 0)));

        ArrayList<ArrayList<Integer>> mat2 = new ArrayList<>();
        mat2.add(new ArrayList<>(Arrays.asList(0, 1, 1)));
        mat2.add(new ArrayList<>(Arrays.asList(0, 0, 0)));
        mat2.add(new ArrayList<>(Arrays.asList(0, 0, 0)));

        int n = 3;
        System.out.println(gridOverlap(mat1, mat2, n));  // Output: 2
    }
}
```

### Detailed Explanation

1. **Initialization and Input Parsing:**

   We initialize two lists, `onesInMAT1` and `onesInMAT2`, to store the coordinates of cells with 1s in `MAT1` and `MAT2` respectively.

2. **Populating the Lists:**

   We iterate over all cells in both matrices. If a cell contains a 1, we add its coordinates `(i, j)` to the corresponding list.

   - For `MAT1`, the coordinates of 1s are `[ (0, 0), (0, 1) ]`.
   - For `MAT2`, the coordinates of 1s are `[ (0, 1), (0, 2) ]`.

3. **Calculating Linear Transformations and Frequencies:**

   We use nested loops to iterate over each pair of cells from `onesInMAT1` and `onesInMAT2`. For each pair, we calculate the linear transformation `(dx, dy)` where `dx` is the difference in X-coordinates and `dy` is the difference in Y-coordinates. We store the transformation as a string key `dx,dy` in the hashmap `frequency` and update its count.

   - For cell `(0, 0)` in `MAT1` and `(0, 1)` in `MAT2`, the transformation is `(0, 1)`.
   - For cell `(0, 0)` in `MAT1` and `(0, 2)` in `MAT2`, the transformation is `(0, 2)`.
   - For cell `(0, 1)` in `MAT1` and `(0, 1)` in `MAT2`, the transformation is `(0, 0)`.
   - For cell `(0, 1)` in `MAT1` and `(0, 2)` in `MAT2`, the transformation is `(0, 1)`.

   The `frequency` hashmap will contain:

   ```
   {
       "0,1": 2,
       "0,2": 1,
       "0,0": 1
   }
   ```

4. **Finding the Maximum Frequency:**

   We iterate over the values in the hashmap `frequency` to find the maximum frequency, which represents the maximum overlap of 1s between the two grids for a given transformation.

   - Maximum overlap is `2` for the transformation `(0, 1)`.

### Conclusion

The output is `2`, indicating that the maximum number of overlapping 1s between `MAT1` and `MAT2` after performing any of the four types of shifts is `2`. This solution effectively uses hashing to count linear transformations and find the maximum overlap, ensuring efficient computation even for larger matrices.
 */

 import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

public class GridOverlap {
    public static int gridOverlap(ArrayList<ArrayList<Integer>> mat1, ArrayList<ArrayList<Integer>> mat2, int n) {
        // List to store coordinates of 1s in mat1
        List<int[]> onesInMAT1 = new ArrayList<>();
        // List to store coordinates of 1s in mat2
        List<int[]> onesInMAT2 = new ArrayList<>();

        // Populate the lists with coordinates of 1s
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (mat1.get(i).get(j) == 1) {
                    onesInMAT1.add(new int[]{i, j});
                }
                if (mat2.get(i).get(j) == 1) {
                    onesInMAT2.add(new int[]{i, j});
                }
            }
        }

        // HashMap to store the frequency of linear transformations
        Map<String, Integer> frequency = new HashMap<>();

        // Calculate the linear transformations and update frequency
        for (int[] cell1 : onesInMAT1) {
            for (int[] cell2 : onesInMAT2) {
                int dx = cell2[0] - cell1[0];
                int dy = cell2[1] - cell1[1];
                String key = dx + "," + dy;
                frequency.put(key, frequency.getOrDefault(key, 0) + 1);
            }
        }

        // Find the maximum frequency
        int maxOverlap = 0;
        for (int count : frequency.values()) {
            maxOverlap = Math.max(maxOverlap, count);
        }

        return maxOverlap;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> mat1 = new ArrayList<>();
        mat1.add(new ArrayList<>(Arrays.asList(1, 1, 0)));
        mat1.add(new ArrayList<>(Arrays.asList(0, 0, 0)));
        mat1.add(new ArrayList<>(Arrays.asList(0, 0, 0)));

        ArrayList<ArrayList<Integer>> mat2 = new ArrayList<>();
        mat2.add(new ArrayList<>(Arrays.asList(0, 1, 1)));
        mat2.add(new ArrayList<>(Arrays.asList(0, 0, 0)));
        mat2.add(new ArrayList<>(Arrays.asList(0, 0, 0)));

        int n = 3;
        System.out.println(gridOverlap(mat1, mat2, n));  // Output: 2
    }
}
