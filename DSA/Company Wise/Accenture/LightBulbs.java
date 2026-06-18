/** N Light bulbs are connected by a wire. Each bulb has a switch associated with it, however due to faulty wiring, a switch also changes the state of all the bulbs to the right of current bulb. Given an initial state of all bulbs, Find the minimum number of switches you have to press to turn on all the bulbs. 
You can press the same switch multiple times.
Note: 0 represents the bulb is off and 1 represents the bulb is on.
Examples :
Input: A[] = {0, 1, 0, 1}
Output: 4
Explanation :
On --> Switch  0 --> {1, 0, 1, 0}
On --> Switch  1 --> {1, 1, 0, 1}
On --> Switch  2 --> {1, 1, 1, 0}
On --> Switch  3 --> {1, 1, 1, 1}
 */

import java.util.*;

class LightBulbs {

  public static void main(String[] args) {
    int[] A = { 1, 0, 1, 0 };
    int mini = 0;
    int flag_switchedon = 0;
    int n = A.length;
    for (int i = 0; i < n; i++) {
      if (A[i] == 0) {
        A[i] = 1;
        mini++;
        flag_switchedon = 1;
      }
      if (flag_switchedon == 1) {
        for (int j = i + 1; j < n; j++) {
          A[j] = 1 - A[j];
        }
      }
      flag_switchedon = 0;
    }

    System.out.println(mini);
  }
}


----------------------------------------------------------------
import java.util.*;

class LightBulbs {
    public static void main(String[] args) {
        int[] A = {0, 1, 0, 1};
        int minSwitches = 0;
        boolean flip = false;

        for (int i = 0; i < A.length; i++) {
            // If flip is true, the current state is reversed
            if ((A[i] == 0 && !flip) || (A[i] == 1 && flip)) {
                minSwitches++;
                flip = !flip; // Toggle the flip state
            }
        }

        System.out.println(minSwitches);
    }
}
