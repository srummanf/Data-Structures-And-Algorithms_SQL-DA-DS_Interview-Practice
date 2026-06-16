/**
 * Algorithms → Greedy + Exponentiation Properties
 * Problem statement
The famous cultural festival of your locality is near and as a member of the committee, you are given the responsibility of arranging loudspeakers for the cultural festival that has to take place. Now, you have arranged N loud-speakers where the ith loudspeaker has loudness or amplitude LOUD[i]. Now when one loudspeaker of loudness Y is kept with another loudspeaker of loudness X, the combined loudness is expressed as Y^X.

So, when N loudspeakers are kept in order A1, A2, A3……….An, the combined loudness will be (A1^(A2^(A3^(...........(An))))). So, your task is to rearrange the loudspeakers such that the combined loudness emitted is maximum.

Example:-
Let, 
N = 3
LOUD = [4, 5, 6]
Answer:- [4, 5, 6]
Explanation:- The answer should be 4,5,6 because out of all the rearrangements that are possible the array [4,5,6] will emit the largest combined loudness. Arrangement 4,5,6 emits an amplitude of 4^5^6 (1152921504606846976) and arrangement 6,5,4 emits an amplitude of 6^5^4 (3656158440062976).
Detailed explanation ( Input/output format, Notes, Images )
Constraints :
1 <= T <= 5
1 <= N <= 10^5
1 <= LOUD[i] <= 10^9

Note:- Loudspeakers having an amplitude of more than 1 will all have unique amplitudes.

Time Limit = 1 sec
Sample Input 1 :
2
2
2 3
2
2 4
Sample Output 1 :
3 2
2 4
Explanation for Sample Output 1 :
In the first test case, the answer should be 3, 2 because 3, 2 emits a loudness of 9 which is the maximum possible.
In the second test case, the answer should be 2, 4 because 2, 4 emits a loudness of 16 which is the largest possible. (Note that 4, 2 also yields the same output but 2, 4 is lexicographically smaller).
Sample Input 2 :
1
1
7
Sample Output 2 :
7

Approaches
01 Approach
We can observe that we have to keep the loudspeakers with amplitude at last as 1 raised to the power is 1 so we take out all the ones separately. Now, the key observation is x^y is always greater than y^x when x<y. The only exception to this is when x=2 and y=3. So, we treat the corner case [2,3] separately, else we print the array in ascending order. 

 

Algorithm:-
 

Initialize an array named ANS to store the rearrangement which gives the maximum combined loudness.
Initialize 2 empty arrays named ONES and ANS_WITHOUT_ONES.
Iterate from 0 to N(Let’s say the iterator be i).
If LOUD[i] is 1, add 1 to ONES.
Else, add LOUD[i] to ANS_WITHOUT_ONES.
Else, update ANS_WITHOUT_ONES as ANS_WITHOUT_ONES sorted in ascending order.
If ANS_WITHOUT_ONES is equal to [2,3], update ANS_WITHOUT_ONES [3,2].
Update ANS as ANS_WITHOUT_ONES plus ONES.
Return ANS.
*/

import java.util.*;

public class LoudSpeakers {

  public static int[] max_amplitude(int n, int[] loud) {
    List<Integer> ones = new ArrayList<>();
    List<Integer> ansWithoutOnes = new ArrayList<>();

    // Separate the 1s and other numbers
    for (int i : loud) {
      if (i == 1) {
        ones.add(i);
      } else {
        ansWithoutOnes.add(i);
      }
    }

    // Sort the ansWithoutOnes list in ascending order
    Collections.sort(ansWithoutOnes);

    // Special case handling for [2, 3]
    if (
      ansWithoutOnes.size() == 2 &&
      ansWithoutOnes.get(0) == 2 &&
      ansWithoutOnes.get(1) == 3
    ) {
      Collections.swap(ansWithoutOnes, 0, 1); // Swap to get [3, 2]
    }

    // Combine the lists
    List<Integer> ans = new ArrayList<>(ansWithoutOnes);
    ans.addAll(ones);

    // Convert the list to array
    int[] result = ans.stream().mapToInt(Integer::intValue).toArray();
    return result;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt(); // Number of test cases

    for (int t = 0; t < T; t++) {
      int N = sc.nextInt(); // Number of loudspeakers
      int[] loud = new int[N];

      for (int i = 0; i < N; i++) {
        loud[i] = sc.nextInt();
      }

      // Get the optimal arrangement
      int[] result = max_amplitude(N, loud);

      // Print the result
      for (int num : result) {
        System.out.print(num + " ");
      }
      System.out.println();
    }

    sc.close();
  }
}
