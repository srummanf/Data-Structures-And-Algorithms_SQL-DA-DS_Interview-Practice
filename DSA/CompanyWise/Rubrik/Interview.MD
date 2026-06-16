| ID | Title | Acceptance                             | Difficulty | Frequency | Leetcode Question Link |
| -- | ----- | -------------------------------------- | ---------- | --------- | ---------------------- |
| 2  | 166   | Fraction to Recurring Decimal ✅       | 21.6%      | Medium    | 0.3244670481307201     |
| 3  | 51    | N-Queens ✅                            | 46.6%      | Hard      | 0.18438554101480611    |
| 4  | 123   | Best Time to Buy and Sell Stock III ✅ | 37.5%      | Hard      | 0.04430403389889214    |
| 5  | 528   | Random Pick with Weight ✅             | 43.9%      | Medium    | 0.014831565905995232   |
| 6  | 31    | Next Permutation ✅                    | 32.6%      | Medium    | 0.013427025530888667   |
| 7  | 4     | Median of Two Sorted Arrays ✅         | 29.6%      | Hard      | 0.008754068159914991   |
| 8  | 64    | Minimum Path Sum ✅                    | 54.5%      | Medium    | 0.006127470152097104   |
| 9  | 723   | Candy Crush ✅                         | 69.2%      | Medium    | 0                      |

Links : https://www.interviewkickstart.com/blogs/interview-questions/rubrik-interview-questions

https://www.geeksforgeeks.org/rubrik-interview-experience-for-internship-on-campus/

https://github.com/krishnadey30/LeetCode-Questions-CompanyWise/blob/master/rubrik_alltime.csv

https://www.naukri.com/code360/interview-bundle/rubrik-inc

https://www.ambitionbox.com/interviews/rubrik-india-interview-questions/software-developer-intern

https://www.naukri.com/code360/interview-experiences/rubrik-inc/interview-experience-by-jatin-dhingra-on-campus-aug-2020-198

**Core DSA concepts:**

* [Arrays](https://www.interviewkickstart.com/learn/array-data-structure), strings, and [linked lists](https://www.interviewkickstart.com/learn/merge-sort-for-linked-list)
* [Trees](https://www.interviewkickstart.com/learn/graph-theory-trees) and graphs
* [Recursion](https://www.interviewkickstart.com/learn/recursion)
* Sorting algorithms — [quicksort](https://www.interviewkickstart.com/learn/quick-sort), [merge sort](https://www.interviewkickstart.com/learn/merge-sort), [heap sort](https://www.interviewkickstart.com/learn/heap-sort), etc.
* Dynamic programming
* Graph algorithms, including greedy algorithms
* Concurrency and Thread focused Coding round,

**Programming and system coding concepts:**

* Multithreading
* Concurrency
* Polymorphism
* Binding and Encapsulation

Design a data structure to store large body of text.

---

Question 1

Given is a list of a "bag of words" such as ["ball","cat","baby","cater"]. Users run a query that is alpha numeric such as "ca1" or "ba2". Return True if the word exists with the alphabets matching the query and the number matching the length of remaining characters. Return Flase if the word doesn't exist or if the word is not unique. ca1 -> True cate1 -> True bab1 -> True ba2 -> False

---

There is single Bathroom to be used in a Voting agency for both Democrats(D) and Republicans(R) * This single Bathroom which can accomodate 3 people at most * each person takes f(N) secs to do his thing. f(N) is a function of the person's name and returns varying number * CONDITION: At any given time, the bathroom cannot have a mixed set of people i.e. * CONDITION: Bathroom can have at most 3 people * these combinations aren't allowed (2D, 1R) or (1D,1R) * These are allowed (), (3D), (2D), (1R) i.e. pure Republicans or Pure Democrats * While the bathroom is occupied people are to wait in a queue * What is the most optimal system where you would manage people in this queue, so that * the most eligible person instants gets to use the bathroom whenever its has room, based on above conditions

---

https://www.geeksforgeeks.org/count-the-number-of-words-with-given-prefix-using-trie/. similar to this question

---

programing interview 1: medium LC problem: robot bounded in circle. programing interview 2: calender invite send. thread sleeping and waking using priority queue. they focus on good system level programing.

---

Binary search tree... Max heap

---

Phone screen: Alien Dictionary Onsite: 1. System Coding round - a variation of leetcode: building H2O 2. Variation of leetcode: counting elements with Follow-ups on optimization 3. System design - related to Unique ID generation 4. standard behavior round

---

I applied through a recruiter. The process took 2 months.I interviewed at Rubrik (Bengaluru) in 1/7/2021

Interview

Typical interview process has 3 types of interviews 1) Algorithmic Round (data structures and algorithms - competitive coding style) 2) Systems Coding Round (concurrency, multithreading, mutex locks, semaphores, object oriented programing) 3) HR rRound

Interview questions [1]

Question 1

Systems Coding Questions examples - producer + consumer problems. Resource allocation problems

---

Longest common prefix for a list of words.

---

DS Algo based on Trees, and coordinate geometry.

---

XOR Query#### Assume you initially have an empty array say ‘ARR’.

#### You need to return the updated array provided that some ‘Q’ number of queries were performed on this array.

#### The queries are of two types:

```
1. 1 ‘VAL’, for this type of query, you need to insert the integer 'VAL' to the end of the array. 2. 2 ‘VAL’, for this type of query, you need to take the bitwise XOR of all the elements of the array with 'VAL' i.e each element of the array ‘ARR’ will be updated as ‘ARR[i]’ = ‘ARR[i]’ ^ ‘VAL’ ( ^ denotes the bitwise XOR operation).
```

#### Note:

```
1) Bitwise XOR operation takes two numbers and performs XOR operation on every bit of those two numbers. For example, consider two numbers 2 and 3 their bitwise XOR will be 1. Because the binary representation of 2 is '10' and the binary representation of 3 is '11'. And XOR of '10' and '11' will be '01'(because XOR evaluates to 0 if the corresponding bits are the same in both the operands, otherwise it evaluates to 1), which is equal to 1. 2) The first query will always be a type 1 query. 3) Note that the ith query should be performed on the array obtained after performing (i-1)th query on the array and so on i.e the changes of each query are updated on the original array itself.
```

##### Input Format:

```
The first line contains an integer ‘T’ which represents the number of test cases. The first line of each test case contains an integer ‘Q’ denoting the number of queries. Then each of the ‘Q’ lines contains two space-separated integers denoting the query to be performed.
```

##### Output Format:

```
For each test case, return the updated array after processing all the queries.
```

##### Note:

```
You do not need to print anything, it has already been taken care of. Just implement the given function.
```

##### Constraints:

```
1 <= T <= 10 1 <= Q <= 10^5 1 <= Val <= 10^9 Time Limit: 1sec
```

##### Follow Up:

```
Can you solve this in constant i.e O(1) space complexity? Space used to return the list will not be counted as an extra space.
```

---

Minimum Removals#### You have been given an array/list "ARR" consisting of 'N' integers. You have also given an integer 'K'.

#### Your task is to find the minimum number of elements that should be removed from "ARR" (possibly zero) such that the difference between the maximum element and the minimum element of the remaining "ARR" is less than or equal to 'K', i.e. ARRmax - ARRmin <= K.

#### Note :

---

Minimum Number Of Stabs To Kill King#### You are given the health of the king as an integer 'N'. You need to find the minimum number of stabs to kill the king. The king dies if the health becomes 0.

#### At any point, to decrease the health of the king you can apply either of two operations (types of stab):

```
1. The first kind of stab decreases the king’s health 'H' by 1 i.e 'H' = 'H'-1. 2. The second kind of stab decreases the king’s health to 'H1', where 'H'= 'H1'*'H2' and 'H1' >= 'H2' > 1 i.e if 'H' = 'H1'*'H2', then 'H' can decrease to 'H1' where 'H1' is the larger factor.
```

#### Note :

```
1. The king’s initial health is an integer and always positive. 2. After each step, the king’s health is decreased. It can not remain the same after a stab of either type.
```

##### Input Format :

```
The first line of the input contains an integer 'T', denoting the number of test cases. The first line and the only line of each test case contains an integer 'N', denoting the initial health of the king.
```

##### Output Format :

```
The only line of output of each test case should contain a value denoting the minimum number of stabs required to kill the king.
```

##### Note :

```
You don't need to print anything, it has already been taken care of. Just implement the given function.
```

##### Constraints :

```
1 <= T <= 10^2 1 <= N <= 10^3 Time Limit : 1sec
```

---

OA: 3 very difficult questions. I passed OA with only 1 question accepted. HR round: Basic questions about you and the company, introduction to the program. Recruiter was really nice, supportive and energetic. First coding round: 60min. Interviewer is nice, will guide you to solve the problem. I feel safe and confident when he said "you are on the right track". Final round: 60min practical coding + 30min culture interview.

3 questions level is hard, involves graph theory, string manipulation, hasing

4 questions on Hackkerrank. 1 Hour 40 Mins

Interview

Round 1:- Asked a question on trie and asked for the implementation. It was 1 hr round. Coming up with logic was easy but it took time for implementation because I never looked into trie implementation part.

Application

I applied through university. I interviewed at Rubrik

Interview

Coding Test followed by Interview and HR rounds. Coding Test had 3 algorithmic problem solving based questions testing Data Structures and Algorithms. Interview round was with team manager who asked about few projects from resume.

Design microservices and design GPS system

1. Design Twitter with Notification service 2. Producer-Consumer Multi-Threaded problem 3. Task Scheduler with Multi-Threading
2. knowledge about operating systems, parallel computing, graph searching

https://leetcode.com/discuss/interview-question/4258631/Top-100-DSA-Interview-Questions

Sure! Here are sample answers in Java for the provided interview questions on system coding and data structures/algorithms (DSA):

### 1. Write a program to reverse a singly Linked List

```java
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        while (current != null) {
            ListNode nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }
        return prev;
    }
}
```

### 2. Write a program to find the missing element in a 2Dimensional integer array

```java
public class FindMissingElement {
    public int findMissing(int[][] array, int n) {
        boolean[] present = new boolean[n * n + 1];
        for (int[] row : array) {
            for (int num : row) {
                present[num] = true;
            }
        }
        for (int i = 1; i <= n * n; i++) {
            if (!present[i]) {
                return i;
            }
        }
        return -1; // Should never be reached if input is valid
    }
}
```

### 3. Write a program to calculate the height of a given binary tree

```java
class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int item) {
        val = item;
        left = right = null;
    }
}

public class BinaryTreeHeight {
    TreeNode root;

    int height(TreeNode node) {
        if (node == null) {
            return 0;
        } else {
            int lHeight = height(node.left);
            int rHeight = height(node.right);
            return Math.max(lHeight, rHeight) + 1;
        }
    }
}
```

### 4. Write a program to implement a recursive function to remove the nth node from a singly linked list

```java
public class RemoveNthNode {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int length = getLength(head);
        if (n > length) {
            return head;
        }
        if (n == length) {
            return head.next;
        }
        ListNode temp = head;
        for (int i = 1; i < length - n; i++) {
            temp = temp.next;
        }
        temp.next = temp.next.next;
        return head;
    }

    private int getLength(ListNode head) {
        int length = 0;
        ListNode temp = head;
        while (temp != null) {
            length++;
            temp = temp.next;
        }
        return length;
    }
}
```

### 5. Write a function to find the level-order traversal for a given binary tree

```java
import java.util.*;

public class BinaryTreeLevelOrder {
    TreeNode root;

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.remove();
                currentLevel.add(currentNode.val);

                if (currentNode.left != null) {
                    queue.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.add(currentNode.right);
                }
            }
            result.add(currentLevel);
        }
        return result;
    }
}
```

### 6. Write a program to connect the nodes that have the same vertical distance in a graph

```java
import java.util.*;

class GraphNode {
    int val;
    List<GraphNode> neighbors;
    GraphNode(int x) { val = x; neighbors = new ArrayList<>(); }
}

public class VerticalConnection {
    public void connectVerticalNodes(GraphNode root) {
        if (root == null) return;
        Map<Integer, List<GraphNode>> verticalMap = new HashMap<>();
        traverseGraph(root, 0, verticalMap);
        // Implement connection logic here
    }

    private void traverseGraph(GraphNode node, int verticalDist, Map<Integer, List<GraphNode>> verticalMap) {
        if (node == null) return;
        verticalMap.putIfAbsent(verticalDist, new ArrayList<>());
        verticalMap.get(verticalDist).add(node);
        for (GraphNode neighbor : node.neighbors) {
            traverseGraph(neighbor, verticalDist + 1, verticalMap);
        }
    }
}
```

### 7. Write a code to print the top view of a binary tree

```java
import java.util.*;

public class BinaryTreeTopView {
    static class TreeNodeWithHD {
        TreeNode node;
        int hd;
        TreeNodeWithHD(TreeNode node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }

    public void topView(TreeNode root) {
        if (root == null) return;
        Map<Integer, TreeNode> topViewMap = new TreeMap<>();
        Queue<TreeNodeWithHD> queue = new LinkedList<>();
        queue.add(new TreeNodeWithHD(root, 0));

        while (!queue.isEmpty()) {
            TreeNodeWithHD temp = queue.poll();
            int hd = temp.hd;
            TreeNode node = temp.node;

            if (!topViewMap.containsKey(hd)) {
                topViewMap.put(hd, node);
            }

            if (node.left != null) {
                queue.add(new TreeNodeWithHD(node.left, hd - 1));
            }

            if (node.right != null) {
                queue.add(new TreeNodeWithHD(node.right, hd + 1));
            }
        }

        for (TreeNode value : topViewMap.values()) {
            System.out.print(value.val + " ");
        }
    }
}
```

### 8. Write a program to find if a binary tree is a binary search tree or not

```java
public class BinaryTreeIsBST {
    TreeNode root;

    boolean isBST() {
        return isBSTUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    boolean isBSTUtil(TreeNode node, int min, int max) {
        if (node == null) {
            return true;
        }
        if (node.val < min || node.val > max) {
            return false;
        }
        return isBSTUtil(node.left, min, node.val - 1) && isBSTUtil(node.right, node.val + 1, max);
    }
}
```

### 9. Write a program to return all the permutations for a given string

```java
import java.util.ArrayList;
import java.util.List;

public class StringPermutations {
    public List<String> permute(String str) {
        List<String> result = new ArrayList<>();
        permuteHelper(str, "", result);
        return result;
    }

    private void permuteHelper(String str, String prefix, List<String> result) {
        if (str.length() == 0) {
            result.add(prefix);
        } else {
            for (int i = 0; i < str.length(); i++) {
                permuteHelper(str.substring(0, i) + str.substring(i + 1), prefix + str.charAt(i), result);
            }
        }
    }
}
```

### 10. Write a program to delete duplicate characters in a string

```java
import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicateCharacters {
    public String removeDuplicates(String str) {
        Set<Character> seen = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (!seen.contains(c)) {
                seen.add(c);
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
```

### 11. What do you understand by Concurrency

Concurrency refers to the ability of a system to execute multiple tasks or processes simultaneously, allowing for efficient utilization of resources. In the context of programming, concurrency allows different parts of a program to run independently and potentially in parallel, improving performance and responsiveness.

### 12. Give an example of how polymorphism is used in OOP

Polymorphism in OOP allows objects of different classes to be treated as objects of a common superclass. An example is having a `Shape` class with a `draw()` method, and subclasses `Circle`, `Rectangle`, and `Triangle`, each implementing `draw()`. A list of `Shape` objects can contain different shapes, and calling `draw()` on each will execute the respective method of the actual shape object.

### 13. Explain with examples the two types of Polymorphism

1. **Compile-time Polymorphism (Method Overloading):**

   ```java
   class MathOperation {
       int add(int a, int b) {
           return a + b;
       }

       int add(int a, int b, int c) {
           return a + b + c;
       }
   }
   ```
2. **Runtime Polymorphism (Method Overriding):**

   ```java
   class Animal {
       void sound() {
           System.out.println("Animal makes a sound");
       }
   }

   class Dog extends Animal {
       void sound() {
           System.out.println("Dog barks");
       }
   }

   public class TestPolym

   ```

orphism {
       public static void main(String[] args) {
           Animal a = new Dog();
           a.sound(); // Outputs: Dog barks
       }
   }

```

### 14. What do you understand by BlockingQueue
A `BlockingQueue` is a thread-safe queue that supports operations that wait for the queue to become non-empty when retrieving an element and wait for space to become available in the queue when storing an element. It is part of the `java.util.concurrent` package and is used in scenarios where you need to implement a producer-consumer pattern.

### 15. What is ConcurrentHashMap, and what is its main function?
`ConcurrentHashMap` is a thread-safe variant of `HashMap` that allows concurrent access and updates without locking the entire map. It achieves this by using a segmented locking mechanism, where only a portion (or segment) of the map is locked for updates, thus improving performance in concurrent applications. Its main function is to allow high-performance concurrent operations on key-value pairs in a map.
```
