
# Converting Top-Down DP to Bottom-Up DP

If you already know how to write **Top-Down DP with Memoization**, converting it to **Bottom-Up DP (Tabulation)** is mostly a mechanical process.

Let's understand it using the **Maximum Sum of Non-Adjacent Elements** problem.

---

## 1. Top-Down Approach

The idea is:

* At every index, we have two choices:

  * **Pick** the current element → we cannot pick the previous element.
  * **Don't pick** the current element → move to the previous element.
* We store already calculated answers in `DP[]` to avoid repeated calculations.

```java
int topDownMemo(int ind, int[] a, int[] DP) {

    // Base case
    if (ind == 0)
        return a[0];

    if (ind < 0)
        return 0;

    // Already calculated
    if (DP[ind] != -1)
        return DP[ind];

    // Pick current element
    int pick = a[ind] + topDownMemo(ind - 2, a, DP);

    // Don't pick current element
    int nonpick = topDownMemo(ind - 1, a, DP);

    // Store and return the answer
    return DP[ind] = Math.max(pick, nonpick);
}
```

The important part is the recurrence:

```java
DP[ind] = Math.max(
    a[ind] + DP[ind - 2],
    DP[ind - 1]
);
```

---

# 2. How Do We Convert It?

The easiest way is to follow these steps.

### Step 1: Identify the dependencies

Our current state:

```text
DP[ind]
```

depends on:

```text
DP[ind - 1]
DP[ind - 2]
```

So we need to calculate the smaller indices first.

---

### Step 2: Replace Recursive Calls

In Top-Down:

```java
topDownMemo(ind - 2, a, DP)
topDownMemo(ind - 1, a, DP)
```

becomes:

```java
DP[ind - 2]
DP[ind - 1]
```

Therefore:

```java
int pick = a[ind] + DP[ind - 2];
int nonpick = DP[ind - 1];
```

---

### Step 3: Convert Base Cases

Our Top-Down base case is:

```java
if (ind == 0)
    return a[0];
```

So initialize:

```java
DP[0] = a[0];
```

For `ind = 1`:

```text
We can either:
Pick a[1]
OR
Pick a[0]
```

Therefore:

```java
DP[1] = Math.max(a[0], a[1]);
```

---

### Step 4: Replace Recursion With a Loop

Since `DP[ind]` depends on smaller indices, calculate from left to right:

```java
for (int ind = 2; ind < n; ind++)
```

Inside the loop:

```java
int pick = a[ind] + DP[ind - 2];
int nonpick = DP[ind - 1];

DP[ind] = Math.max(pick, nonpick);
```

---

# 3. Final Bottom-Up Code

```java
int bottomUp(int[] a) {

    int n = a.length;

    // Handle single element
    if (n == 1)
        return a[0];

    int[] DP = new int[n];

    // Base cases
    DP[0] = a[0];
    DP[1] = Math.max(a[0], a[1]);

    // Build the DP table
    for (int ind = 2; ind < n; ind++) {

        // Pick current element
        int pick = a[ind] + DP[ind - 2];

        // Don't pick current element
        int nonpick = DP[ind - 1];

        // Store the best answer
        DP[ind] = Math.max(pick, nonpick);
    }

    // Answer for the entire array
    return DP[n - 1];
}
```

---

# 4. The Conversion Pattern

You can remember the conversion with this simple pattern:


| Top-Down           | Bottom-Up            |
| -------------------- | ---------------------- |
| Recursive function | DP array             |
| `f(ind - 1)`       | `DP[ind - 1]`        |
| `f(ind - 2)`       | `DP[ind - 2]`        |
| Base case          | DP initialization    |
| Recursion          | `for` loop           |
| Start from target  | Start from base case |
| Memoization        | Tabulation           |

### The key idea

> **Top-Down:** Start from the answer and recursively go towards the base case.

> **Bottom-Up:** Start from the base case and iteratively build towards the answer.

---

# 5. Quick Formula to Remember

Whenever you see:

```java
f(ind) → f(ind - 1), f(ind - 2)
```

Think:

```java
DP[ind] → DP[ind - 1], DP[ind - 2]
```

Then:

```java
DP[base] = baseValue;

for (int ind = base + 1; ind < n; ind++) {
    DP[ind] = recurrence;
}

return DP[n - 1];
```

**In short:**

```text
Recursion
   ↓
Find dependencies
   ↓
Replace recursive calls with DP[]
   ↓
Initialize base cases
   ↓
Use a loop in dependency order
   ↓
Return target DP state
```

# Example

Using **your exact code in DP 5 Maximum Sum Of Non Adjacent Elements**, remember the conversion like this:

### 1. Top-Down

```java
pick = a[ind] + topDownMemo(ind - 2, a, DP);
nonpick = topDownMemo(ind - 1, a, DP);
```

### 2. Replace recursive calls with DP

```java
pick = a[ind] + DP[ind - 2];
nonpick = DP[ind - 1];
```

### 3. Base case → initialization

```java
DP[0] = a[0];
DP[1] = Math.max(a[0], a[1]);
```

### 4. Recursion → loop

```java
for (int ind = 2; ind < n; ind++)
```

### 5. Final Bottom-Up

```java
int[] DP = new int[n];

DP[0] = a[0];
DP[1] = Math.max(a[0], a[1]);

for (int ind = 2; ind < n; ind++) {
    int pick = a[ind] + DP[ind - 2];
    int nonpick = DP[ind - 1];

    DP[ind] = Math.max(pick, nonpick);
}

return DP[n - 1];
```

### Memorize this transformation


| Top-Down         | Bottom-Up               |
| ------------------ | ------------------------- |
| `f(ind - 2)`     | `DP[ind - 2]`           |
| `f(ind - 1)`     | `DP[ind - 1]`           |
| `if (ind == 0)`  | `DP[0] = ...`           |
| Recursion        | `for` loop              |
| Start from`n-1`  | Start from base →`n-1` |
| `return DP[ind]` | `return DP[n-1]`        |

**Core idea:**
`top-down = solve what you need → bottom-up = solve everything needed before it.`
