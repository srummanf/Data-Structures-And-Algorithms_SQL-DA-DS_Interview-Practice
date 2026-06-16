/** 1441. Build an Array With Stack Operations

 * You are given an integer array target and an integer n.

You have an empty stack with the two following operations:

"Push": pushes an integer to the top of the stack.
"Pop": removes the integer on the top of the stack.
You also have a stream of the integers in the range [1, n].

Use the two stack operations to make the numbers in the stack (from the bottom to the top) equal to target. You should follow the following rules:

If the stream of the integers is not empty, pick the next integer from the stream and push it to the top of the stack.
If the stack is not empty, pop the integer at the top of the stack.
If, at any moment, the elements in the stack (from the bottom to the top) are equal to target, do not read new integers from the stream and do not do more operations on the stack.
Return the stack operations needed to build target following the mentioned rules. If there are multiple valid answers, return any of them.

 

Example 1:

Input: target = [1,3], n = 3
Output: ["Push","Push","Pop","Push"]
Explanation: Initially the stack s is empty. The last element is the top of the stack.
Read 1 from the stream and push it to the stack. s = [1].
Read 2 from the stream and push it to the stack. s = [1,2].
Pop the integer on the top of the stack. s = [1].
Read 3 from the stream and push it to the stack. s = [1,3].
Example 2:

Input: target = [1,2,3], n = 3
Output: ["Push","Push","Push"]
Explanation: Initially the stack s is empty. The last element is the top of the stack.
Read 1 from the stream and push it to the stack. s = [1].
Read 2 from the stream and push it to the stack. s = [1,2].
Read 3 from the stream and push it to the stack. s = [1,2,3].
 */

import java.util.*;

public class ArrayStackOps {

  public List<String> buildArray(int[] target, int n) {
    ArrayList<String> ans = new ArrayList<>();
    ArrayList<Integer> t = new ArrayList<>();
    int tn = target.length;

    int x = 0;
    for (int i = 0; i < n; i++) {
      System.out.println("Loop i: " + i + " Before x: " + x);
      t.add(i + 1);
      ans.add("Push");

      System.out.println("x " + x);
      if (t.get(i) != target[x]) {
        ans.add("Pop");
        x--;
        System.out.println("x after neg :" + x);
      }

      x++;
      System.out.println("x after add :" + x);
      System.out.println("Loop i: " + i + " After x: " + x);
      System.out.println("---------------------------------");
    }

    return ans;
  }

  public List<String> buildArray_ChatGPT(int[] target, int n) {
    ArrayList<String> ans = new ArrayList<>();
    ArrayList<Integer> t = new ArrayList<>();
    int tn = target.length;

    int x = 0;
    for (int i = 0; i < n; i++) {
      if (x == tn) {
        // If all elements in the target array have been matched, exit the loop.
        break;
      }

      System.out.println("Loop i: " + i + " Before x: " + x);
      t.add(i + 1);
      ans.add("Push");

      System.out.println(x);
      if (t.get(i) != target[x]) {
        ans.add("Pop");
      } else {
        x++; // Increment x only when the element matches the target.
      }

      System.out.println("Loop i" + i + " After x: " + x);
    }

    return ans;
  }

  public static void main(String[] args) {
    ArrayStackOps t = new ArrayStackOps();
    int[] target = { 1, 3 };
    int n = 3;
    System.out.println(t.buildArray(target, n));
    System.out.println();
    System.out.println(".x.x..x.x.x.x.x.x.x.x.x.x.x.");
    System.out.println(".x.x..x.x.x.x.x.x.x.x.x.x.x.");
    System.out.println();
    System.out.println(t.buildArray_ChatGPT(target, n));
  }
}
