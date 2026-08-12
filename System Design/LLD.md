# Low-Level Design (LLD) Roadmap

A structured roadmap to prepare for Low-Level Design (LLD) interviews.

---

# 1. Object-Oriented Programming (OOP)

Master the fundamentals of OOP before moving to design patterns and system design.

## Topics

- Class & Objects
- Constructors
- Inheritance
- Encapsulation
- Polymorphism
  - Compile-Time Polymorphism
    - Method Overloading
  - Run-Time Polymorphism
    - Method Overriding
    - Dynamic Method Dispatch
- Abstraction
  - Abstract Class
  - Interface
  - Abstract Class vs Interface

---

# 2. Core Java Concepts

These concepts are commonly used in production-grade applications.

## Topics

- Dependency Injection
- API Design
- Functional Interfaces
- Lambda Expressions
- Immutability
- Value Objects
- Generics
- Type Safety

---

# 3. Design Patterns

## Creational Patterns

- Singleton
- Factory Method
- Abstract Factory
- Builder
- Prototype

## Structural Patterns

- Adapter
- Decorator
- Composite
- Facade
- Proxy
- Bridge

## Behavioral Patterns

- Observer
- Strategy
- Iterator
- Command
- State
- Template Method

> These patterns are sufficient for most LLD interviews.

---

# 4. SOLID Principles

- Single Responsibility Principle (SRP)
- Open/Closed Principle (OCP)
- Liskov Substitution Principle (LSP)
- Interface Segregation Principle (ISP)
- Dependency Inversion Principle (DIP)

---

# 5. UML & Object Modeling

## UML Basics

- Class Diagrams
- Sequence Diagrams (Recommended)
- Object Diagrams (Optional)

## Relationships

- Association
- Aggregation
- Composition
- Dependency
- Inheritance

## Important Concepts

- Dependency vs Inheritance
- IS-A vs HAS-A Relationship
- Multiplicity

---

# 6. Concurrency & Thread Safety

Understanding concurrency is essential for scalable designs.

## Topics

- Race Conditions
- Synchronization
- Locks vs `synchronized`
- Atomic Variables
- Thread-safe Collections
- Immutability for Thread Safety

---

# 7. Code Quality & Clean Code

Write maintainable and extensible code.

## Best Practices

- Meaningful Naming
- Small Classes
- Single Responsibility
- One Abstraction Level Per Method
- DRY Principle
- KISS Principle

---

# 8. Exception Handling

## Topics

- Checked Exceptions
- Unchecked Exceptions
- Custom Exceptions
- Exception Hierarchy Design
- Fail Fast Principle
- Never Swallow Exceptions

---

# 9. Application Logging

## Log Levels

- DEBUG
- INFO
- WARN
- ERROR

## Best Practices

- Structured Logging
- What to Log
- What Not to Log
- Correlation IDs
- Avoid Logging Sensitive Data

---

# 10. LLD Practice Problems

## Beginner

- Design Parking Lot
- Design Vending Machine
- Design ATM
- Design Library Management System
- Design Elevator System
- Design Traffic Light System
- Design Meeting Room Scheduler
- Design Snake and Ladder Game
- Design Tic-Tac-Toe Game
- Design Chess Game

---

## Intermediate

- Design Splitwise
- Design URL Shortener
- Design BookMyShow
- Design Uber
- Design Food Delivery Application
- Design Online Hotel Booking System
- Design Airline Management System
- Design Restaurant Management System
- Design Inventory Management System
- Design Car Rental System

---

## Advanced

- Design Cache System
- Design Rate Limiter
- Design Logging Framework
- Design Notification System
- Design Payment System
- Design File System
- Design Task Scheduler
- Design Search Autocomplete System
- Design API Throttling System
- Design Feature Flag System

---

## Expert

- Design LinkedIn
- Design Amazon Order Management System
- Design Truecaller
- Design Chat Application (WhatsApp)
- Design Community Discussion Platform (Reddit)
- Design Online Voting System
- Design Calendar Application
- Design Learning Management System
- Design Stock Exchange System
- Design CricBuzz
- Design BookMyShow Seat Locking
- Design Distributed ID Generator (Snowflake)
- Design Circuit Breaker
- Design Retry with Backoff Mechanism
- Design Metrics & Monitoring System
- Design Authentication System
- Design Role-Based Access Control (RBAC)
- Design Web Crawler
- Design Recommendation Engine
- Design Event-Driven Producer-Consumer System

---

# 11. Interview Strategy

For every LLD problem, follow this sequence:

1. Clarify Requirements
2. Identify Core Entities
3. Create Class Diagram
4. Define Relationships
5. Apply SOLID Principles
6. Choose Suitable Design Patterns
7. Design Public APIs
8. Handle Edge Cases
9. Discuss Concurrency
10. Write Clean Code
11. Explain Complexity
12. Discuss Future Scalability

---

# 12. Suggested Learning Order

- ✅ OOP
- ✅ SOLID Principles
- ✅ UML & Modeling
- ✅ Core Java Concepts
- ✅ Design Patterns
- ✅ Clean Code
- ✅ Exception Handling
- ✅ Logging
- ✅ Concurrency
- ✅ Beginner LLD Problems
- ✅ Intermediate LLD Problems
- ✅ Advanced LLD Problems
- ✅ Expert LLD Problems

---

I extracted the text from the SVG. It contains an **LLD Roadmap** followed by **50 interview problems**.

## 1. LLD Roadmap

### OOPS Concepts

* Class & Objects
* Constructor
* Inheritance
* Encapsulation
* Polymorphism

  * Compile Time

    * Method Overloading
  * Run Time

    * Method Overriding
    * Dynamic Method Dispatch
* Abstraction
* Abstract Class vs Interface

### Core Concepts

* Dependency Injection
* API Design
* Functional Interfaces & Lambdas
* Immutability & Value Objects
* Generics & Type Safety

### Design Patterns

**Creational**

* Singleton
* Factory Method
* Abstract Factory
* Builder
* Prototype

**Structural**

* Adapter
* Decorator
* Composite
* Facade
* Proxy
* Bridge

**Behavioral**

* Observer
* Strategy
* Iterator
* Command
* State
* Template Method

### SOLID Principles

* Single Responsibility
* Open/Closed
* Liskov Substitution
* Interface Segregation
* Dependency Inversion

### UML & Modeling

* Class Diagrams
* Association
* Aggregation
* Composition
* Dependency
* Dependency vs Inheritance
* IS-A vs HAS-A Relationship
* Multiplicity

### Concurrency & Thread Safety

* Race Conditions
* Synchronization Primitives
* Locks vs Synchronized
* Atomic Variables
* Immutability for Thread Safety

### Code Quality & Clean Code

* Meaningful Names
* One Abstraction Level per Method
* Small Classes
* Exception Handling

  * Checked vs Unchecked Exceptions
  * Custom Exception Classes
  * Exception Hierarchy Design
  * Never Swallow Exceptions (just catch + ignore)
  * Fail Fast Principle

### Application Logging

* Log Levels

  * DEBUG
  * INFO
  * WARN
  * ERROR
* What to Log vs What Not to Log
* Structured Logging

---

# 2. 50 Most Asked LLD Interview Problems

1. Design Parking Lot
2. Design Vending Machine
3. Design ATM
4. Design Library Management System
5. Design Elevator System
6. Design Traffic Light System
7. Design Meeting Room Scheduler
8. Design Snake and Ladder Game
9. Design Tic-Tac-Toe Game
10. Design Chess Game
11. Design Splitwise
12. Design URL Shortner
13. Design BookMyShow
14. Design Uber
15. Design Food Delivery Application
16. Design Online Hotel Booking System
17. Design Airline Management System
18. Design Restaurant Management System
19. Design Inventory Management System
20. Design Car Rental System
21. Design Cache System
22. Design Rate Limiter
23. Design Logging Framework
24. Design Notification System
25. Design Payment System (LLD)
26. Design File System
27. Design Task Scheduler
28. Design Search Autocomplete System
29. Design API Throttling System
30. Design Feature Flag System
31. Design LinkedIn (LLD focus)
32. Design Amazon Order Management System
33. Design Truecaller
34. Design Chat Application (WhatsApp-like)
35. Design Community Discussion Platform (Reddit-like)
36. Design Online Voting System
37. Design Calendar Application
38. Design Learning Management System
39. Design Stock Exchange System
40. Design CricBuzz
41. Design BookMyShow Seat Locking
42. Design Distributed ID Generator (Snowflake-like)
43. Design Circuit Breaker
44. Design Retry with Backoff Mechanism
45. Design Metrics and Monitoring System
46. Design Authentication System
47. Design Role-Based Access Control System (RBAC)
48. Design Web Crawler (LLD focus)
49. Design Recommendation Engine (LLD focus)
50. Design Event-Driven Producer-Consumer System

**Note:** I preserved the terminology from the SVG, including typos such as **"Method Overlaoding," "Dynamic Method Dispatcj,"** and **"URL Shortner."**

# 

# Goal

After completing this roadmap, you should be comfortable solving **50+ popular Low-Level Design interview problems** commonly asked in software engineering interviews.

> Source : [codewithnishchal](https://whimsical.com/lld-VDPw8YTocytiVvG7AFBjL9?fbclid=PARlRTSASkrrdleHRuA2FlbQIxMABzcnRjBmFwcF9pZA8xMjQwMjQ1NzQyODc0MTQAAaeHKE67AnvExWn7LqffEDEnghtBw7NHxaxYG-z5Gl6xcP-97FPORjEj3QrZUQ_aem_0wtjPe0FPkDPOSQpWRRWBw "codewithnishchal")
>
