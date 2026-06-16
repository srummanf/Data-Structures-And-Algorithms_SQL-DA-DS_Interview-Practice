
# Deliveroo Software Engineer Interview Guide

## About Deliveroo

Deliveroo is a fast-growing food delivery platform founded in 2013 in London. It connects customers with local restaurants to provide on-demand meal delivery.([deliveroo.engineering](https://deliveroo.engineering/2017/11/23/engineering-interviews.html?utm_source=chatgpt.com "How do we interview engineers at Deliveroo?"))

---

## Interview Format Overview

### 1. Recruiter Screening

* A 15–30 minute initial conversation with a recruiter or engineering manager to discuss your background, interests, and alignment with Deliveroo. No technical questions are asked in this stage.([deliveroo.engineering](https://deliveroo.engineering/2017/11/23/engineering-interviews.html?utm_source=chatgpt.com "How do we interview engineers at Deliveroo?"))

### 2. Online Assessment (HackerRank)

* A **90-minute** take-home test, usually with  **3 coding problems** : an easy array problem, a medium array/sorting problem, and a hard graph (or DP) problem.([GeeksforGeeks](https://www.geeksforgeeks.org/interview-experiences/deliveroo-interview-experience-intern-fulltime-on-campus-2024-/?utm_source=chatgpt.com "Deliveroo | Interview Experience | Intern - GeeksforGeeks"))
* Familiarize yourself with the HackerRank interface— there’s no debugger and you cannot navigate back once a section is submitted.([Google Sites](https://sites.google.com/deliveroo.co.uk/engineeringinterviewing/frontend-engineering?utm_source=chatgpt.com "Interview Process | Engineering - FrontEnd Engineering"))

### 3. Final Loop Interviews

* **Technical Live Coding** : Pair programming session solving algorithmic DSA problems. Communicate your thought process clearly.([deliveroo.engineering](https://deliveroo.engineering/2017/11/23/engineering-interviews.html?utm_source=chatgpt.com "How do we interview engineers at Deliveroo?"), [Google Sites](https://sites.google.com/deliveroo.com/tech-leadership/em-sem-prep/coding-interview?utm_source=chatgpt.com "Live Coding Interview - Google Sites"))
* **System Design / Architecture** : Typically involves high-level backend/system design, database modeling, and related API challenges.([Glassdoor](https://www.glassdoor.co.in/Interview/Deliveroo-Software-Engineer-Interview-Questions-EI_IE1053365.0%2C9_KO10%2C27.htm?utm_source=chatgpt.com "Deliveroo Software Engineer Interview Questions | Glassdoor"))
* **Behavioral Interview** : Assesses candidate’s fit, team interaction, and soft skills using structured methods like the STAR technique.

---

## Common Problem Themes & Data Structures

Deliveroo assesses candidates across the following topics during coding rounds:

* **Arrays & Sorting** (easy/medium problems)
* **Graphs** (hard problems, e.g., MST, Dijkstra variants)
* **Linked Lists**
* **Dynamic Programming**
* **String Parsing / Mini-Parser** style tasks
* **Cache Design** questions around LRU / LFU implementations

---

## Sample Coding Round Logic Flow

```
- 90-minute HackerRank gateway
  - Problem 1 (Easy): Array
  - Problem 2 (Medium): Array or Sorting
  - Problem 3 (Hard): Graph or DP
```

---

## Suggested Practice Problem Sets

Focus on the following DSA topics:

* **Arrays & Sorting** : basic and two-pointer/multi-set techniques
* **Graphs** : MST, shortest/longest path, cycle detection
* **DP** : knapsack, subsequence, partition problems
* **Linked Lists** : reversal, intersection, cycle detection
* **Parsing & Expression Evaluation** : (similar to LeetCode 385, 394, 772)
* **Cache Systems** : design and implement LRU / LFU using hashmaps + linked lists

---

## Best Practices & Tips

* **Think aloud** —explain your reasoning and approach in real-time.([Interview Query](https://www.interviewquery.com/interview-guides/deliveroo-software-engineer?utm_source=chatgpt.com "Deliveroo Software Engineer Interview Guide"), [deliveroo.engineering](https://deliveroo.engineering/2017/11/23/engineering-interviews.html?utm_source=chatgpt.com "How do we interview engineers at Deliveroo?"), [AmbitionBox](https://www.ambitionbox.com/interviews/deliveroo-interview-questions/software-engineer?utm_source=chatgpt.com "40+ Deliveroo Software Engineer Interview Questions ... - AmbitionBox"))
* **Clarify requirements** before diving into coding.
* **Stick to your strongest language** for optimal performance.
* **Practice in HackerRank-like environments** and get used to their constraints (e.g. no debugger, linear submissions).([Google Sites](https://sites.google.com/deliveroo.com/tech-leadership/em-sem-prep/coding-interview?utm_source=chatgpt.com "Live Coding Interview - Google Sites"))
* **Behavioral Rounds** : Use the **STAR method** to structure responses. Prepare for questions about past projects, challenges faced, and teamwork strategies.([deliveroo.engineering](https://deliveroo.engineering/2017/11/23/engineering-interviews.html?utm_source=chatgpt.com "How do we interview engineers at Deliveroo?"), [Interview Query](https://www.interviewquery.com/interview-guides/deliveroo-software-engineer?utm_source=chatgpt.com "Deliveroo Software Engineer Interview Guide"))

---

## Additional Resources & References

* **Deliveroo Engineering Blog** : Offers insight into their interview philosophy and process.([deliveroo.engineering](https://deliveroo.engineering/2017/11/23/engineering-interviews.html?utm_source=chatgpt.com "How do we interview engineers at Deliveroo?"))
* Community-shared interview experiences on  **AmbitionBox** ,  **Glassdoor** , and  **GeeksforGeeks** .([AmbitionBox](https://www.ambitionbox.com/interviews/deliveroo-interview-questions/software-engineer?utm_source=chatgpt.com "40+ Deliveroo Software Engineer Interview Questions ... - AmbitionBox"))

---

## Credits

Compiled using reports from:

* Deliveroo Engineering official blog
* Glassdoor, AmbitionBox, and Reddit candidate reports
* GeeksforGeeks Deliveroo experiences and prep guides

All insights and process details verified via recent firsthand accounts and posts.

#### Source

* https://www.ambitionbox.com/interviews/deliveroo-interview-questions/software-engineer
* https://enginebogie.com/interview/experience/deliveroo-software-development-engineer/117
* https://www.glassdoor.co.in/Interview/Deliveroo-Software-Engineer-Interview-Questions-EI_IE1053365.0,9_KO10,27.htm?filter.jobTitleFTS=Software+Engineer

* https://deliveroo.engineering/2017/11/23/engineering-interviews.html
* https://medium.com/@varsha_a/deliveroo-on-campus-interview-experience-17eba72651b2

* https://www.reddit.com/r/developersIndia/comments/1bcqvq0/deliveroo_interview_experience_for_softwarre/

# Deliveroo Interview Prep: Parsing & Nested Structure Problems

## 🎯 Purpose

This document compiles a set of coding problems similar to  **Leetcode 385 - Mini Parser** , focused on  **parsing** ,  **nested data structures** ,  **expression evaluation** , and  **string manipulation** . These problems are known to appear in coding assessments for companies like  **Deliveroo** , which frequently test skills in:

* Expression parsing (mini calculators, encoders/decoders)
* Stack usage and nested data traversal
* Efficient cache and memory structure design (LRU, LFU)

---

## 📚 Problem Set

> 🧠 Solve these in a  **90-minute window** , simulating real interview conditions (1 Easy, 1 Medium, 1 Hard recommended).

### 1. [Leetcode 394 - Decode String](https://leetcode.com/problems/decode-string/)

**Type:** Stack, String, Recursion

**Problem:** Decode strings with pattern `k[encoded_string]`.

**Example:**

Input: `"3[a2[c]]"` → Output: `"accaccacc"`

---

### 2. [Leetcode 636 - Exclusive Time of Functions](https://leetcode.com/problems/exclusive-time-of-functions/)

**Type:** Stack, Logs, Simulation

**Problem:** Given logs of `n` nested functions, return their exclusive runtime.

---

### 3. [Leetcode 772 - Basic Calculator III](https://leetcode.com/problems/basic-calculator-iii/)

**Type:** Stack, Recursion, Parser

**Problem:** Evaluate expressions with `+`, `-`, `*`, `/`, and parentheses.

---

### 4. [Leetcode 726 - Number of Atoms](https://leetcode.com/problems/number-of-atoms/)

**Type:** Stack, HashMap, Parsing

**Problem:** Parse a chemical formula like `H2O` or `Mg(OH)2` and count atoms.

---

### 5. [Leetcode 331 - Verify Preorder Serialization of a Binary Tree](https://leetcode.com/problems/verify-preorder-serialization-of-a-binary-tree/)

**Type:** Stack, Tree Serialization

**Problem:** Verify if a given string is a valid preorder serialization of a binary tree.

**Example:** `"9,3,4,#,#,1,#,#,2,#,6,#,#"`

---

### 6. [Leetcode 224 - Basic Calculator I](https://leetcode.com/problems/basic-calculator/)

**Type:** Stack, Parser

**Problem:** Evaluate a mathematical expression using only `+`, `-`, and parentheses.

---

### 7. [Leetcode 150 - Evaluate Reverse Polish Notation](https://leetcode.com/problems/evaluate-reverse-polish-notation/)

**Type:** Stack, Postfix Evaluation

**Problem:** Given an expression in Reverse Polish Notation (RPN), evaluate it.

---

### 8. [Leetcode 227 - Basic Calculator II](https://leetcode.com/problems/basic-calculator-ii/)

**Type:** Parser, Stack

**Problem:** Evaluate expressions with `+`, `-`, `*`, `/` (no parentheses).

---

### 9. [Leetcode 385 - Mini Parser](https://leetcode.com/problems/mini-parser/)

**Type:** String Parsing, Nested Structures

**Problem:** Parse a string representing nested lists into a custom object (NestedInteger).

**Example:** `"324"` → `NestedInteger(324)`

`"[123,[456,[789]]]"` → nested structure.

---

## ✨ Bonus Practice

* **Leetcode 20 - Valid Parentheses**
* **Leetcode 32 - Longest Valid Parentheses**
* **Leetcode 301 - Remove Invalid Parentheses**
* **Leetcode 815 - Bus Routes (Graph Parsing + Mapping)**

---

## 🧠 Strategy

| Category              | Pattern                           | Techniques       |
| --------------------- | --------------------------------- | ---------------- |
| Expression Evaluation | Mini Calculators, Decoding, RPN   | Stack, DFS       |
| Nested Parsing        | Atom Count, Tree Serialization    | Recursion, Stack |
| Graph Simulation      | Bus Routes, Parser Trees          | BFS, DFS         |
| Logs & Time           | Function Logs, LRU Implementation | Stack, HashMap   |

---

## 🧑‍💻 Deliveroo Coding Round Format

* **Platform:** HackerRank
* **Duration:** 90 minutes
* **Typical Set:**
  * 1 Easy Array
  * 1 Medium String/Linked List
  * 1 Hard Graph/Parser

---

## 📝 Notes

* Focus on  **time-space tradeoffs** .
* Handle **deeply nested cases** efficiently.
* Ensure **robust parsing** with error handling.

---

## 🙌 Credits

* Problem descriptions courtesy of [LeetCode](https://leetcode.com/)
* Inspired by Deliveroo interview experiences:
  * [Glassdoor](https://www.glassdoor.co.in/Interview/Deliveroo-Software-Engineer-Interview-Questions-EI_IE1053365.0,9_KO10,27.htm)
  * [Medium](https://medium.com/@varsha_a/deliveroo-on-campus-interview-experience-17eba72651b2)
  * [Deliveroo Engineering Blog](https://deliveroo.engineering/2017/11/23/engineering-interviews.html)
  * Reddit & Community Posts
