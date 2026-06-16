

# Computer Science & Programming MCQs asked in British Telecom

## Networking

### 1. Which of the following topologies has the highest reliability?

* [ ] Bus topology
* [ ] Star topology
* [ ] Ring topology
* [X] **Mesh topology**

---

## Algorithms

### 2. What is the output type of the following pseudocode?

```java
double func(int arr[], int l)
Arrays.sort(arr);
if (l % 2 != 0)
    return (double) arr[l / 2];
double res = (double) ((arr[l / 2] + arr[(l - 1) / 2]) / 2.0);
return res;
```

* [ ] Highest Common Factor
* [ ] Lowest Common Multiple
* [X] **Median**

---

### 3. What is the time complexity of the following pseudocode?

```python
Algorithm Search(arr, x):
    low = 0
    high = length(arr)
    while low <= high:
        mid = (low + high) / 2
        if arr[mid] == x:
            return mid
        elif arr[mid] < x:
            low = mid + 1
        else:
            high = mid - 1
    return -1
```

* [X] **O(log n)**
* [ ] O(n)
* [ ] O(n log n)
* [ ] O(1)

---

### 4. What is the time complexity of insert() and extract_max() in a heap?

* [X] **O(log n)**
* [ ] O(n)
* [ ] O(1)
* [ ] O(n²)

---

## OSI Model

### 5. Which of the following represent functions of the Data Link Layer?

* [X] **2, 3, 4, 6, and 7**
* [ ] 1, 2, 3, 5
* [ ] 3, 4, 5, 6
* [ ] 2, 4, 5

**Correct options:**

* 2. Framing
* 3. Error Control
* 4. Access Control
* 6. Flow Control
* 7. Physical Addressing

---

## Data Structures

### 6. What is the time complexity of merging two sorted arrays to find the median?

* [X] **O(n + m)**
* [ ] O(n log m)
* [ ] O(n)
* [ ] O(1)

---

## SQL

### 7. What is the output of the SQL query?

**Tables:**

`STUDENT`

| ID | NAME  | AGE  |
| -- | ----- | ---- |
| 01 | Mike  | 20   |
| 02 | Alice | 18   |
| 03 | Mary  | 25   |
| 04 | Lisa  | NULL |

**Query:**

```sql
SELECT NAME FROM STUDENT WHERE NAME LIKE '%a%' ORDER BY NAME;
```

* [ ] Lisa, Mike
* [X] **Alice, Mary**
* [ ] Lisa, Alice
* [ ] Mary, Mike

---

## ⏱ Scheduling

### 8. What is the average waiting time in milliseconds using Priority Scheduling?

**Table:**

| Process | Priority | Burst Time |
| ------- | -------- | ---------- |
| P0      | 3        | 10         |
| P1      | 1        | 1          |
| P2      | 4        | 2          |
| P3      | 5        | 1          |
| P4      | 2        | 5          |

* [ ] 10 ms
* [X] **8.2 ms**
* [ ] 12 ms
* [ ] 6 ms

---

## Trees

### 9. What is the missing code at Line 14 to calculate the Maximum Path Sum in a binary tree?

```python
function max_gain(node):
    nonlocal max_sum
    # Line 14
    if not node:
        return 0
    ...
```

* [X] **price_newpath = node.val + left_gain + right_gain**
* [ ] price_newpath = left_gain * right_gain
* [ ] price_newpath = max(left_gain + right_gain, left_gain, right_gain)
* [ ] price_newpath(node.val, left_gain, right_gain)

---

## Java Programming

### 10. What is the output of the following Java code?

```java
Product original = new Product("Laptop", 999.99);
Product copy = new Product(original);
copy.name = "Tablet";
System.out.println(original.name);
```

* [ ] Tablet
* [X] **Laptop**
* [ ] null
* [ ] Error

---

## CPU Scheduling

### 11. Which of the following are true for Non-Preemptive Shortest Job First (SJF) scheduling?

* [X] **1, 2, and 4**
* [ ] 1, 2, and 3
* [ ] 1 and 3
* [ ] 2 and 3

**Correct Statements:**

1. Selects waiting process with minimum execution time
2. Can cause starvation
3. Has minimum average waiting time

---

## Pseudocode Analysis

### 12. What is the output of the following code with `nums = [3, 4, -1, 1]`?

```python
function find(nums):
    ...
```

* [ ] 1
* [X] **2**
* [ ] 3
* [ ] 4

---

## SQL Joins

### 13. What is the output of the following SQL `INNER JOIN` query?

**Tables:**

**customers**

| cust_id | cust_name   | address  |
| ------- | ----------- | -------- |
| 101     | Lisa Davis  | Tokyo    |
| 107     | John Wilson | New York |
| 115     | Mary Brown  | London   |
| 121     | Paul Miller | Paris    |

**orders**

| order_id | cust_id | order_item    |
| -------- | ------- | ------------- |
| 1972     | 101     | Television    |
| 3586     | 107     | Refrigerator  |
| 2914     | 115     | Grocery       |
| 5760     | 222     | Drill machine |

**Query:**

```sql
SELECT customers.cust_id, customers.cust_name, customers.address, orders.order_item
FROM customers
INNER JOIN orders ON customers.cust_id = orders.cust_id;
```

**Output:**

* [X] **101 - Lisa Davis - Tokyo - Television**

  **107 - John Wilson - New York - Refrigerator**

  **115 - Mary Brown - London - Grocery**
* [ ] All 4 customers
* [ ] All 4 orders
* [ ] No matching rows
