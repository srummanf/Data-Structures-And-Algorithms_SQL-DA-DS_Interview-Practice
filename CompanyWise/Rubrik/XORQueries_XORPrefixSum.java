/** Problem statement
Assume you initially have an empty array say ‘ARR’.

You need to return the updated array provided that some ‘Q’ number of queries were performed on this array.

The queries are of two types:

1. 1 ‘VAL’, for this type of query, you need to insert the integer 'VAL' to the end of the array.
2. 2 ‘VAL’, for this type of query, you need to take the bitwise XOR of all the elements of the array with 'VAL' i.e each element of the array ‘ARR’ will be updated as ‘ARR[i]’ = ‘ARR[i]’ ^ ‘VAL’ ( ^ denotes the bitwise XOR operation).
Note:

1) Bitwise XOR operation takes two numbers and performs XOR operation on every bit of those two numbers. For example, consider two numbers 2 and 3 their bitwise XOR will be 1. Because the binary representation of 2 is '10' and the binary representation of 3 is '11'. And XOR of '10' and '11' will be '01'(because XOR evaluates to 0 if the corresponding bits are the same in both the operands, otherwise it evaluates to 1), which is equal to 1.

2) The first query will always be a type 1 query.

3) Note that the ith query should be performed on the array obtained after performing (i-1)th query on the array and so on i.e the changes of each query are updated on the original array itself.
Detailed explanation ( Input/output format, Notes, Images )
Constraints:
1 <= T <= 10
1 <= Q <= 10^5
1 <= Val <= 10^9

Time Limit: 1sec
Sample Input 1:
2
2
1 3
2 2
3
1 2
2 3
2 1
Sample Output 1:
1
0
Explanation for sample input 1:
For the first test case:
After the first query, 3 will be pushed into the array, so the array will be {3}, then after processing the second query the array will be changed to {3^2} i.e. {1}. So the output array will be {1}.

For the second test case:
After the first query, 2 will be pushed into the array, so the array will be {2}, then after processing the second query the array will be changed to {2^3} i.e. {1}, further the array is modified as {1^1} i.e {0}, after processing the third query. So the output array will be {0}.
Sample Input 2:
2
3 
1 2 
1 3
2 4
3
1 4
1 5
2 1
Sample Output 2:
6 7
5 4
Explanation for sample input 2:
For the first test case:
After the first query, 2 will be pushed into the array, so the array will be {2}. Then after processing the second query 3 will be pushed into the array, so the array will be {2, 3}. Then after processing the third query the array will be changed to {2^4, 3^4} i.e. {6, 7}. So the output array will be {6, 7}.

For the second test case:
After the first query, 4 will be pushed into the array, so the array will be {4}. Then after processing the second query 5 will be pushed into the array, so the array will be {4, 5}. Then after processing the third query the array will be changed to {4^1, 5^1} i.e. {5, 4}. So the output array will be {5, 4}. */
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static ArrayList<Integer> xorQuery(ArrayList<ArrayList<Integer>> queries) {
        ArrayList<Integer> result = new ArrayList<>();
        ArrayList<Integer> arr = new ArrayList<>();
        int currentXor = 0;

        for (ArrayList<Integer> query : queries) {
            int type = query.get(0);
            int val = query.get(1);

            if (type == 1) {
                // Insert query
                arr.add(val ^ currentXor);
            } else if (type == 2) {
                // XOR query
                currentXor ^= val;
            }
        }

        for (int i = 0; i < arr.size(); i++) {
            result.add(arr.get(i) ^ currentXor);
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine(); // Consume newline

        ArrayList<ArrayList<Integer>> queries = new ArrayList<>();

        for (int t = 0; t < T; t++) {
            int Q = sc.nextInt();
            sc.nextLine(); // Consume newline

            queries.clear();
            for (int q = 0; q < Q; q++) {
                ArrayList<Integer> query = new ArrayList<>();
                query.add(sc.nextInt());
                query.add(sc.nextInt());
                sc.nextLine(); // Consume newline
                queries.add(query);
            }

            ArrayList<Integer> result = xorQuery(queries);
            for (int num : result) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
