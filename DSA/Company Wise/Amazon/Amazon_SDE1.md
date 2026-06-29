# Amazon SDE 1 Interview Experience (OA + Coding + LLD)

> **Role:** Software Development Engineer I (SDE 1)
>
> **Source:** LeetCode Discuss Interview Experience
> Reference: [https://leetcode.com/discuss/post/8364677/amazon-sde-1-interview-by-anonymous_user-uesh/ ](https://leetcode.com/discuss/post/8364677/amazon-sde-1-interview-by-anonymous_user-uesh/)

---

# Interview Process

The interview process consisted of three major stages:

1. Online Assessment (OA)
2. Coding Interview
3. Low Level Design (LLD)

---

# Round 1 — Online Assessment (OA)

### Problem

**LeetCode 68 — Text Justification**

https://leetcode.com/problems/text-justification/

### Difficulty

Hard

### Concepts Tested

- String manipulation
- Simulation
- Greedy
- Edge case handling

### Important Topics

- Packing maximum words in one line
- Evenly distributing spaces
- Handling extra spaces
- Last line formatting
- Single-word line handling

### Preparation Tips

Practice writing clean simulation code because the interviewer is generally interested in:

- Code readability
- Edge case handling
- Modular helper methods

---

# Round 2 — Coding Interview

## Problem

**LeetCode 208 — Implement Trie (Prefix Tree)**

https://leetcode.com/problems/implement-trie-prefix-tree/

### Follow-up

The interviewer extended the question.

Instead of only implementing:

- insert()
- search()
- startsWith()

They asked to implement functionality to:

> Return all products/words starting with a given prefix.

Example

```text
Words:

apple
application
apply
banana

Input:
app

Output:
apple
application
apply
```

---

## Concepts Tested

- Trie
- DFS
- Recursion
- Prefix Search
- Backtracking

---

## Expected API

```java
insert(String word)

search(String word)

startsWith(String prefix)

getWordsStartingWith(String prefix)
```

---

## Follow-up Questions

- Complexity of insert
- Complexity of search
- Complexity of listing all matching words
- How would you support millions of words?
- How would you optimize memory usage?

---

# Round 3 — Low Level Design (LLD)

## Problem Statement

Design a system to calculate fees for different financial instruments.

Examples:

- Stocks
- Bonds
- ETFs
- Mutual Funds
- Derivatives

Each security type has:

- Different fee rates
- Different fee calculation logic
- Different business rules

There are also rules common to every equity.

The interviewer expected an **extensible** design.

---

# Requirements

The system should support:

- Adding new asset types
- Adding new fee rules
- Reusing common logic
- Minimal code changes when extending

---

# Example

## Stocks

- Brokerage
- GST
- STT

---

## Bonds

- Fixed processing fee
- Different tax rules

---

## ETFs

- Expense ratio
- Platform fee

---

# What Interviewer Was Looking For

Instead of using:

```java
if(type == STOCK)

else if(type == BOND)

else if(...)
```

they expected usage of:

- Interfaces
- Strategy Pattern
- Open Closed Principle
- Composition

---

# Good Design

```text
Asset
    ↑
-------------------------
|       |        |
Stock  Bond     ETF

FeeRule
    ↑
----------------------------
|          |               |
Brokerage  TaxRule     PlatformFee

FeeCalculator
```

Each asset owns its own fee rules.

FeeCalculator simply executes every applicable rule.

---

# Design Principles Tested

- SOLID Principles
- Strategy Pattern
- Open Closed Principle
- Polymorphism
- Composition over Inheritance

---

# Possible Class Structure

```text
Asset

FeeRule

BrokerageRule

TaxRule

PlatformFeeRule

Stock

Bond

ETF

FeeCalculator
```

---

# Follow-up Questions

The interviewer may ask:

### Add Cryptocurrency

How many files need modification?

Expected answer:

> Only create a new asset class and corresponding rules.

---

### Add Discount Rule

Can we plug in a new rule without touching existing code?

---

### Add Premium Customer Discount

Can fee rules depend on customer type?

---

### Remove a Rule

Can rules be enabled/disabled dynamically?

---

# Preparation Resources

## OA

- LeetCode 68 — Text Justification

---

## Coding

- LeetCode 208 — Implement Trie
- Prefix Search
- DFS in Trie
- Word Dictionary problems

---

## LLD Topics

Study:

- SOLID Principles
- Strategy Pattern
- Factory Pattern
- Dependency Injection
- Composition vs Inheritance
- Open Closed Principle

Practice designs like:

- Parking Lot
- ATM
- Vending Machine
- Library Management System
- Inventory Management System
- Payment Calculator
- Tax Calculator

---

# Key Takeaways

- Amazon can ask simulation-heavy OA problems that require careful handling of edge cases.
- Trie questions often include practical follow-ups such as autocomplete or product search.
- For LLD, the focus is on extensibility rather than implementing every feature.
- Strong knowledge of object-oriented design principles (especially SOLID) is valuable for SDE 1 interviews.

---

# Problems Asked

| Round  | Question                                       | Topic                        |
| ------ | ---------------------------------------------- | ---------------------------- |
| OA     | LeetCode 68 — Text Justification              | Strings, Greedy              |
| Coding | LeetCode 208 — Implement Trie + Prefix Search | Trie, DFS                    |
| LLD    | Fee Calculation Engine for Financial Assets    | OOP, SOLID, Strategy Pattern |

---

# Overall Difficulty

| Round  | Difficulty   |
| ------ | ------------ |
| OA     | Hard         |
| Coding | Medium       |
| LLD    | Medium–Hard |

---

# Preparation Checklist

- ✅ Master Trie implementation from scratch
- ✅ Practice DFS-based autocomplete in Trie
- ✅ Solve simulation/string formatting problems
- ✅ Learn SOLID principles thoroughly
- ✅ Practice extensible LLD designs using Strategy Pattern
- ✅ Be ready to explain design decisions and trade-offs

