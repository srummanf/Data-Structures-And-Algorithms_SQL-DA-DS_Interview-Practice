# StringBuilder in Java — Quick Reference Table

## Constructors

| Constructor                     | Description                     | Example                                           |
| ------------------------------- | ------------------------------- | ------------------------------------------------- |
| `StringBuilder()`             | Empty builder with capacity 16  | `StringBuilder sb = new StringBuilder();`       |
| `StringBuilder(String str)`   | Initialize with string          | `StringBuilder sb = new StringBuilder("Java");` |
| `StringBuilder(int capacity)` | Initialize with custom capacity | `StringBuilder sb = new StringBuilder(100);`    |

---

## Core Methods

| Method                     | Return Type       | Description       | Example                     |
| -------------------------- | ----------------- | ----------------- | --------------------------- |
| `append(x)`              | `StringBuilder` | Add at end        | `sb.append("Java");`      |
| `insert(i,x)`            | `StringBuilder` | Insert at index   | `sb.insert(0,"Hi ");`     |
| `delete(start,end)`      | `StringBuilder` | Delete range      | `sb.delete(0,5);`         |
| `deleteCharAt(i)`        | `StringBuilder` | Delete one char   | `sb.deleteCharAt(2);`     |
| `replace(start,end,str)` | `StringBuilder` | Replace range     | `sb.replace(0,4,"Code");` |
| `reverse()`              | `StringBuilder` | Reverse content   | `sb.reverse();`           |
| `toString()`             | `String`        | Convert to String | `sb.toString();`          |

---

## Character Operations

| Method                   | Return Type | Description       | Example                  |
| ------------------------ | ----------- | ----------------- | ------------------------ |
| `charAt(i)`            | `char`    | Get character     | `sb.charAt(0);`        |
| `setCharAt(i,c)`       | `void`    | Modify character  | `sb.setCharAt(0,'K');` |
| `substring(start)`     | `String`  | Extract substring | `sb.substring(2);`     |
| `substring(start,end)` | `String`  | Extract range     | `sb.substring(2,5);`   |

---

## Search Operations

| Method                    | Return Type | Description       | Example                     |
| ------------------------- | ----------- | ----------------- | --------------------------- |
| `indexOf(str)`          | `int`     | First occurrence  | `sb.indexOf("Java");`     |
| `indexOf(str,from)`     | `int`     | Search from index | `sb.indexOf("a",2);`      |
| `lastIndexOf(str)`      | `int`     | Last occurrence   | `sb.lastIndexOf("Java");` |
| `lastIndexOf(str,from)` | `int`     | Reverse search    | `sb.lastIndexOf("a",5);`  |

---

## Length & Capacity

| Method                | Return Type | Description          | Example                     |
| --------------------- | ----------- | -------------------- | --------------------------- |
| `length()`          | `int`     | Current length       | `sb.length();`            |
| `capacity()`        | `int`     | Buffer size          | `sb.capacity();`          |
| `ensureCapacity(n)` | `void`    | Increase capacity    | `sb.ensureCapacity(100);` |
| `trimToSize()`      | `void`    | Reduce unused memory | `sb.trimToSize();`        |

---

## Most Used DSA Boilerplates

### 1. Create StringBuilder

| Task          | Code                                           |
| ------------- | ---------------------------------------------- |
| Empty Builder | `StringBuilder sb = new StringBuilder();`    |
| From String   | `StringBuilder sb = new StringBuilder(str);` |

---

### 2. Reverse String

| Task    | Code                                                          |
| ------- | ------------------------------------------------------------- |
| Reverse | `String rev = new StringBuilder(str).reverse().toString();` |

---

### 3. Palindrome Check

| Task             | Code                                                                |
| ---------------- | ------------------------------------------------------------------- |
| Check Palindrome | `return str.equals(new StringBuilder(str).reverse().toString());` |

---

### 4. Build String Efficiently

| Task              | Code                            |
| ----------------- | ------------------------------- |
| Append Characters | `sb.append(ch);`              |
| Append String     | `sb.append("Java");`          |
| Final String      | `String ans = sb.toString();` |

---

### 5. Backtracking Pattern

| Step    | Code                                |
| ------- | ----------------------------------- |
| Choose  | `sb.append(ch);`                  |
| Recurse | `dfs(...);`                       |
| Undo    | `sb.deleteCharAt(sb.length()-1);` |

---

### 6. Character Traversal

| Task             | Code                               |
| ---------------- | ---------------------------------- |
| Traverse Builder | `for(int i=0;i<sb.length();i++)` |
| Access Character | `char ch = sb.charAt(i);`        |

---

## String vs StringBuilder

| Feature            | String    | StringBuilder   |
| ------------------ | --------- | --------------- |
| Mutable            | ❌        | ✅              |
| Memory Efficient   | ❌        | ✅              |
| Fast Concatenation | ❌        | ✅              |
| Thread Safe        | ✅        | ❌              |
| Used in DSA        | Sometimes | Very Frequently |

---

## Interview Cheat Sheet

| Operation         | One-Liner                                     |
| ----------------- | --------------------------------------------- |
| Reverse String    | `new StringBuilder(s).reverse().toString()` |
| String → Builder | `new StringBuilder(s)`                      |
| Builder → String | `sb.toString()`                             |
| Append            | `sb.append(x)`                              |
| Insert            | `sb.insert(i,x)`                            |
| Delete Last Char  | `sb.deleteCharAt(sb.length()-1)`            |
| Get Char          | `sb.charAt(i)`                              |
| Update Char       | `sb.setCharAt(i,c)`                         |
| Length            | `sb.length()`                               |
| Reverse Builder   | `sb.reverse()`                              |

### Complexity Summary

| Operation       | Time Complexity |
| --------------- | --------------- |
| `append()`    | O(1) amortized  |
| `charAt()`    | O(1)            |
| `setCharAt()` | O(1)            |
| `length()`    | O(1)            |
| `reverse()`   | O(n)            |
| `insert()`    | O(n)            |
| `delete()`    | O(n)            |
| `replace()`   | O(n)            |
| `toString()`  | O(n)            |


# StringBuilder Functions Every Competitive Programmer Should Know

Beyond `append()`, `reverse()`, and `deleteCharAt()`, these methods frequently simplify DSA and CP problems.

## Advanced StringBuilder Methods

| Method                     | Return Type       | Purpose                  | Example                          |
| -------------------------- | ----------------- | ------------------------ | -------------------------------- |
| `append(x)`              | `StringBuilder` | Add at end               | `sb.append(10);`               |
| `appendCodePoint(int)`   | `StringBuilder` | Append Unicode character | `sb.appendCodePoint(65); // A` |
| `insert(i,x)`            | `StringBuilder` | Insert at index          | `sb.insert(2,'X');`            |
| `delete(start,end)`      | `StringBuilder` | Delete range             | `sb.delete(1,4);`              |
| `deleteCharAt(i)`        | `StringBuilder` | Delete single char       | `sb.deleteCharAt(0);`          |
| `replace(start,end,str)` | `StringBuilder` | Replace range            | `sb.replace(0,3,"ABC");`       |
| `reverse()`              | `StringBuilder` | Reverse content          | `sb.reverse();`                |
| `setLength(n)`           | `void`          | Resize string            | `sb.setLength(0);`             |
| `ensureCapacity(n)`      | `void`          | Preallocate memory       | `sb.ensureCapacity(100000);`   |
| `trimToSize()`           | `void`          | Shrink memory            | `sb.trimToSize();`             |
| `capacity()`             | `int`           | Current capacity         | `sb.capacity();`               |
| `length()`               | `int`           | Current length           | `sb.length();`                 |

---

# Character Manipulation

| Method                                         | Description         | Example                    |
| ---------------------------------------------- | ------------------- | -------------------------- |
| `charAt(i)`                                  | Read character      | `char c = sb.charAt(2);` |
| `setCharAt(i,c)`                             | Update character    | `sb.setCharAt(0,'A');`   |
| `getChars(srcBegin,srcEnd,char[],destBegin)` | Copy chars to array | Useful in parsing          |
| `substring(start)`                           | Extract substring   | `sb.substring(3);`       |
| `substring(start,end)`                       | Extract range       | `sb.substring(1,4);`     |

---

# Search Operations

| Method                    | Description       | Example                     |
| ------------------------- | ----------------- | --------------------------- |
| `indexOf(str)`          | First occurrence  | `sb.indexOf("abc");`      |
| `indexOf(str,from)`     | Search from index | `sb.indexOf("a",5);`      |
| `lastIndexOf(str)`      | Last occurrence   | `sb.lastIndexOf("abc");`  |
| `lastIndexOf(str,from)` | Reverse search    | `sb.lastIndexOf("a",10);` |

---

# CP Trick #1: Fast String Reset

Instead of:

```java
sb = new StringBuilder();
```

Use:

```java
sb.setLength(0);
```

| Method           | Benefit                                    |
| ---------------- | ------------------------------------------ |
| `setLength(0)` | Clears builder without creating new object |

Useful inside loops processing many test cases.

---

# CP Trick #2: Remove Last Character

Very common in Backtracking.

```java
sb.deleteCharAt(sb.length()-1);
```

| Problem Type         |
| -------------------- |
| Generate Parentheses |
| N Queens             |
| Word Search          |
| Combination Sum      |
| DFS Path Generation  |

---

# CP Trick #3: Repeat Characters

Instead of loops:

```java
for(int i=0;i<10;i++)
    sb.append('0');
```

Java 11+

```java
sb.append("0".repeat(10));
```

---

# CP Trick #4: Build Binary Representation

```java
StringBuilder binary = new StringBuilder();

while(n > 0){
    binary.append(n % 2);
    n /= 2;
}

binary.reverse();
```

---

# CP Trick #5: Build Large Output

Instead of:

```java
System.out.println(a);
System.out.println(b);
System.out.println(c);
```

Use:

```java
StringBuilder out = new StringBuilder();

out.append(a).append('\n');
out.append(b).append('\n');
out.append(c).append('\n');

System.out.print(out);
```

Huge speedup in CP.

---

# Frequently Used String Methods With StringBuilder

You often combine these.

| Method                       | Example                             |
| ---------------------------- | ----------------------------------- |
| `String.valueOf(x)`        | `sb.append(String.valueOf(num));` |
| `Integer.parseInt(s)`      | Convert substring to int            |
| `Long.parseLong(s)`        | Convert substring to long           |
| `Character.isDigit(c)`     | Parsing                             |
| `Character.isLetter(c)`    | Validation                          |
| `Character.toLowerCase(c)` | Normalization                       |
| `Character.toUpperCase(c)` | Normalization                       |

---

# Common DSA Patterns

## Palindrome

```java
String rev =
    new StringBuilder(s)
        .reverse()
        .toString();
```

---

## Reverse Words

```java
String[] words = s.split(" ");

StringBuilder ans =
    new StringBuilder();

for(int i=words.length-1;i>=0;i--){
    ans.append(words[i]).append(" ");
}
```

---

## Backtracking Template

```java
void dfs(...) {

    if(baseCase){
        ans.add(sb.toString());
        return;
    }

    sb.append(ch);

    dfs(...);

    sb.deleteCharAt(
        sb.length()-1
    );
}
```

---

## Path Building in Trees

```java
path.append(root.val);
path.append("->");
```

Used in:

* Binary Tree Paths
* Trie Problems
* Graph DFS
* File System Problems

---

# Competitive Programming Output Pattern

| Scenario             | Recommended                        |
| -------------------- | ---------------------------------- |
| Single Output        | `System.out.println()`           |
| Thousands of Outputs | `StringBuilder`                  |
| Millions of Outputs  | `BufferedWriter + StringBuilder` |
| Fast Input           | `BufferedReader`                 |
| Fast Input + Parsing | Custom FastScanner                 |

---

# 10 One-Liners Every Java DSA Candidate Should Memorize

| Task               | Code                                          |
| ------------------ | --------------------------------------------- |
| Reverse String     | `new StringBuilder(s).reverse().toString()` |
| String → Builder  | `new StringBuilder(s)`                      |
| Builder → String  | `sb.toString()`                             |
| Append Char        | `sb.append(ch)`                             |
| Append Newline     | `sb.append('\n')`                           |
| Remove Last Char   | `sb.deleteCharAt(sb.length()-1)`            |
| Update Char        | `sb.setCharAt(i,c)`                         |
| Clear Builder      | `sb.setLength(0)`                           |
| Get Length         | `sb.length()`                               |
| Preallocate Memory | `sb.ensureCapacity(100000)`                 |

For LeetCode, Codeforces, AtCoder, and interviews, `append()`, `reverse()`, `setLength(0)`, `deleteCharAt()`, `charAt()`, `setCharAt()`, `indexOf()`, and `toString()` account for the vast majority of StringBuilder usage.
