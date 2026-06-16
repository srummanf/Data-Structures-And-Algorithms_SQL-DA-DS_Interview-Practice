# ｡⋆ Fast & Slow Pointer (Tortoise & Hare) Pattern

## 𓍯 Introduction

The **Fast & Slow Pointer** pattern is one of the most important techniques in Data Structures and Algorithms.

With only two pointers moving at different speeds, we can solve problems involving:

* Finding the middle node
* Detecting cycles
* Finding the start of a cycle
* Removing nodes from the end
* Checking palindromes
* Reordering linked lists
* Splitting linked lists
* Detecting cycles in mathematical sequences

This pattern appears frequently in:

* FAANG Interviews
* Product Companies
* LeetCode Medium Problems
* System Design Fundamentals involving linked structures

---

# ✦ Why This Pattern Exists

Consider a linked list:

```text
1 → 2 → 3 → 4 → 5
```

Suppose we need to find the middle.

A beginner approach:

```text
Pass 1 → Count nodes
Pass 2 → Traverse to middle
```

Complexity:

| Metric | Value |
| ------ | ----- |
| Time   | O(n)  |
| Space  | O(1)  |

Although the complexity looks good, we're traversing the list twice.

Fast & Slow Pointer achieves the same result in a  **single traversal** .

---

# 𓍯 Core Idea

Use two pointers:

| Pointer | Speed   |
| ------- | ------- |
| Slow    | 1 step  |
| Fast    | 2 steps |

Template:

```java
ListNode slow = head;
ListNode fast = head;

while (fast != null && fast.next != null) {
    slow = slow.next;
    fast = fast.next.next;
}
```

---

## Visual Intuition

```text
1 → 2 → 3 → 4 → 5
```

### Iteration 0

```text
S,F
 ↓
1 → 2 → 3 → 4 → 5
```

### Iteration 1

```text
    S
    ↓
1 → 2 → 3 → 4 → 5
        ↑
        F
```

### Iteration 2

```text
        S
        ↓
1 → 2 → 3 → 4 → 5
                ↑
                F
```

Fast reaches the end.

Slow reaches the middle.

---

# ✦ Pattern Recognition

Whenever you see these phrases:

| Hint                           | Consider Fast & Slow? |
| ------------------------------ | --------------------- |
| Middle node                    | ✅                    |
| Halfway point                  | ✅                    |
| Cycle detection                | ✅                    |
| Circular traversal             | ✅                    |
| Nth node from end              | ✅                    |
| Split linked list              | ✅                    |
| Meeting point                  | ✅                    |
| One-pass linked list traversal | ✅                    |

---

# ① Finding the Middle Node

## Problem

```text
1 → 2 → 3 → 4 → 5
```

Return:

```text
3
```

---

## Intuition

Fast travels twice as quickly.

When Fast reaches the end:

```text
Fast Distance = 2 × Slow Distance
```

Therefore:

```text
Slow Distance = Half of List
```

which means:

```text
Slow = Middle Node
```

---

## Template

```java
ListNode slow = head;
ListNode fast = head;

while (fast != null && fast.next != null) {
    slow = slow.next;
    fast = fast.next.next;
}

return slow;
```

---

## Complete Solution (LeetCode 876)

```java
class Solution {

    public ListNode middleNode(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}
```

---

## Complexity

| Metric | Value |
| ------ | ----- |
| Time   | O(n)  |
| Space  | O(1)  |

---

## Interview Explanation

> Fast moves twice as quickly as slow. Therefore, when fast reaches the end of the list, slow has traveled only half the distance and points to the middle node.

---

# ② Delete the Middle Node

## Problem

```text
1 → 2 → 3 → 4 → 5
```

Delete:

```text
3
```

Result:

```text
1 → 2 → 4 → 5
```

---

## Key Observation

To delete a node in a singly linked list:

```java
prev.next = prev.next.next;
```

You need:

```text
Previous Node
```

not the middle node itself.

---

## Trick

Instead of:

```java
fast = head;
```

Use:

```java
fast = head.next.next;
```

This causes slow to stop one position before the middle.

---

## Visualization

```text
1 → 2 → 3 → 4 → 5
     ↑
   slow
```

Delete:

```java
slow.next = slow.next.next;
```

Result:

```text
1 → 2 ─────→ 4 → 5
```

---

## Complete Solution (LeetCode 2095)

```java
class Solution {

    public ListNode deleteMiddle(ListNode head) {

        if (head.next == null)
            return null;

        ListNode slow = head;
        ListNode fast = head.next.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        slow.next = slow.next.next;

        return head;
    }
}
```

---

## Complexity

| Metric | Value |
| ------ | ----- |
| Time   | O(n)  |
| Space  | O(1)  |

---

# ③ Detect a Cycle

## Problem

```text
1 → 2 → 3 → 4
    ↑       ↓
    ← ← ← ←
```

Determine whether a cycle exists.

---

## Intuition

Imagine two runners on a circular track.

```text
Slow = 1 step
Fast = 2 steps
```

Fast gains one node every iteration.

Eventually:

```text
Fast catches Slow
```

---

## Visualization

```text
Cycle Exists

Slow →
Fast →→

Eventually

Slow == Fast
```

---

## Template

```java
ListNode slow = head;
ListNode fast = head;

while (fast != null && fast.next != null) {

    slow = slow.next;
    fast = fast.next.next;

    if (slow == fast)
        return true;
}

return false;
```

---

## Complete Solution (LeetCode 141)

```java
public class Solution {

    public boolean hasCycle(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast)
                return true;
        }

        return false;
    }
}
```

---

## Complexity

| Metric | Value |
| ------ | ----- |
| Time   | O(n)  |
| Space  | O(1)  |

---

## Interview Explanation

> If a cycle exists, the fast pointer gains one node on the slow pointer during every iteration and must eventually meet it. If no cycle exists, the fast pointer reaches null.

---

# ④ Find the Start of a Cycle

## Problem

```text
1 → 2 → 3 → 4 → 5
          ↑     ↓
          ← ← ←
```

Return:

```text
3
```

---

## Step 1: Detect Collision

```java
while (fast != null && fast.next != null) {

    slow = slow.next;
    fast = fast.next.next;

    if (slow == fast)
        break;
}
```

---

## Step 2: Reset One Pointer

```java
slow = head;
```

---

## Step 3: Move Together

```java
while (slow != fast) {
    slow = slow.next;
    fast = fast.next;
}
```

---

## Why Does This Work?

A mathematical proof shows:

```text
Distance(Head → CycleStart)
=
Distance(MeetingPoint → CycleStart)
```

Therefore both pointers meet exactly at:

```text
Cycle Start
```

---

## Complete Solution (LeetCode 142)

```java
public class Solution {

    public ListNode detectCycle(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {

                slow = head;

                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }

                return slow;
            }
        }

        return null;
    }
}
```

---

# ⑤ Remove Nth Node From End

## Problem

```text
1 → 2 → 3 → 4 → 5
```

Remove:

```text
2nd node from end
```

Result:

```text
1 → 2 → 3 → 5
```

---

## Key Insight

Maintain a gap of N nodes.

---

## Visualization

```text
S         F
↓         ↓

1 → 2 → 3 → 4 → 5
```

Gap:

```text
N Nodes
```

Move both together.

When Fast reaches end:

```text
Slow reaches target location.
```

---

## Complete Solution (LeetCode 19)

```java
class Solution {

    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode slow = dummy;
        ListNode fast = dummy;

        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }

        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;

        return dummy.next;
    }
}
```

---

# ⑥ Palindrome Linked List

## Problem

```text
1 → 2 → 2 → 1
```

Return:

```text
true
```

---

## Strategy

```text
Find Middle
      ↓
Reverse Second Half
      ↓
Compare Both Halves
```

---

## Code

### Find Middle

```java
while (fast != null && fast.next != null) {
    slow = slow.next;
    fast = fast.next.next;
}
```

### Reverse

```java
ListNode prev = null;

while (slow != null) {

    ListNode next = slow.next;

    slow.next = prev;
    prev = slow;
    slow = next;
}
```

### Compare

```java
while (prev != null) {

    if (head.val != prev.val)
        return false;

    head = head.next;
    prev = prev.next;
}
```

---

## Complete Solution (LeetCode 234)

```java
class Solution {

    public boolean isPalindrome(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode prev = null;

        while (slow != null) {

            ListNode next = slow.next;

            slow.next = prev;
            prev = slow;
            slow = next;
        }

        while (prev != null) {

            if (head.val != prev.val)
                return false;

            head = head.next;
            prev = prev.next;
        }

        return true;
    }
}
```

---

# ⑦ Reorder List

## Problem

Convert:

```text
1 → 2 → 3 → 4 → 5
```

into

```text
1 → 5 → 2 → 4 → 3
```

---

## Strategy

```text
Find Middle
      ↓
Reverse Right Half
      ↓
Merge Alternately
```

---

## Why Fast-Slow?

The entire problem depends on accurately finding:

```text
Left Half
Right Half
```

which is exactly what Fast-Slow Pointer provides.

---

# ⑧ Happy Number (Non-Linked List Application)

## Observation

```text
19
↓
82
↓
68
↓
100
↓
1
```

Every number produces another number.

This behaves like:

```text
Node → Node → Node
```

which is essentially a linked list.

---

## Insight

If a number isn't happy:

```text
A cycle eventually forms.
```

Use:

```text
Fast-Slow Cycle Detection
```

without any HashSet.

---

# 𓍯 Common Variations

| Goal            | Initialization                     |
| --------------- | ---------------------------------- |
| Find Middle     | `slow=head, fast=head`           |
| Delete Middle   | `slow=head, fast=head.next.next` |
| Cycle Detection | `slow=head, fast=head`           |
| Split List      | `slow=head, fast=head.next`      |
| Nth From End    | Create gap first                   |
| Cycle Start     | Detect cycle first                 |

---

# ✦ Common Mistakes

| Mistake                            | Result                |
| ---------------------------------- | --------------------- |
| Forgetting `fast.next != null`   | NullPointerException  |
| Wrong initialization               | Off-by-One Error      |
| Not handling single node list      | Runtime Error         |
| Comparing values instead of nodes  | Wrong cycle detection |
| Forgetting dummy node in removeNth | Edge-case failure     |

---

# 𓍯 Fast & Slow Pointer Cheat Sheet

| Problem             | Pattern                   |
| ------------------- | ------------------------- |
| Middle Node         | Fast-Slow                 |
| Delete Middle       | Fast-Slow                 |
| Detect Cycle        | Fast-Slow                 |
| Cycle Start         | Fast-Slow                 |
| Remove Nth From End | Gap + Fast-Slow           |
| Palindrome List     | Fast-Slow + Reverse       |
| Reorder List        | Fast-Slow + Reverse       |
| Merge Sort List     | Fast-Slow + Divide        |
| Happy Number        | Fast-Slow Cycle Detection |

---

# ✦ Interview Decision Tree

```text
Linked List Problem?
        │
        ▼
Need Middle?
        │
       Yes
        │
        ▼
Fast & Slow Pointer

──────────────────────

Need Cycle Detection?
        │
       Yes
        │
        ▼
Fast & Slow Pointer

──────────────────────

Need Nth From End?
        │
       Yes
        │
        ▼
Maintain Fixed Gap

──────────────────────

Need Two Halves?
        │
       Yes
        │
        ▼
Find Middle First
```

---

# 𓍯 Final Takeaway

> Fast & Slow Pointer is not a linked-list trick.
>
> It is a way of exploiting **relative speed** to discover hidden information about a sequence.

Mastering this pattern gives you solutions for:

* Middle detection
* Cycle detection
* Cycle entry discovery
* Distance maintenance
* One-pass traversal
* Sequence cycle problems

Understanding **why the pointers meet, separate, and reveal structure** is far more valuable than memorizing individual LeetCode solutions.
