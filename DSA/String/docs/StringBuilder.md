StringBuilder is a versatile and efficient class in Java that provides mutable sequences of characters. It is particularly useful in scenarios where you need to perform multiple string manipulations, as it avoids the overhead of creating new string instances with every modification.

Here is a comprehensive crash course on the important functions of `StringBuilder` that can help you solve Data Structures and Algorithms (DSA) questions.

### 1. **Creation and Initialization**

- **Default Constructor**: Creates an empty `StringBuilder`.
  ```java
  StringBuilder sb = new StringBuilder();
  ```
- **With Initial Capacity**: Creates a `StringBuilder` with a specified initial capacity.
  ```java
  StringBuilder sb = new StringBuilder(50);
  ```
- **With Initial String**: Creates a `StringBuilder` initialized with the specified string.
  ```java
  StringBuilder sb = new StringBuilder("initial string");
  ```

### 2. **Appending Strings**

- **append(String str)**: Appends the specified string to this character sequence.
  ```java
  sb.append("Hello");
  sb.append(" ");
  sb.append("World");
  ```

### 3. **Inserting Strings**

- **insert(int offset, String str)**: Inserts the specified string at the given position.
  ```java
  sb.insert(5, " inserted ");
  ```

### 4. **Deleting Characters**

- **delete(int start, int end)**: Removes the characters in a substring of this sequence.
  ```java
  sb.delete(5, 14);
  ```
- **deleteCharAt(int index)**: Removes the character at the specified position.
  ```java
  sb.deleteCharAt(5);
  ```

### 5. **Replacing Substrings**

- **replace(int start, int end, String str)**: Replaces the characters in a substring with the specified string.
  ```java
  sb.replace(5, 11, "replaced");
  ```

### 6. **Reversing the Sequence**

- **reverse()**: Reverses the sequence of characters.
  ```java
  sb.reverse();
  ```

### 7. **Setting and Getting Characters**

- **setCharAt(int index, char ch)**: Sets the character at the specified position.
  ```java
  sb.setCharAt(0, 'h');
  ```
- **charAt(int index)**: Returns the character at the specified position.
  ```java
  char c = sb.charAt(0);
  ```

### 8. **Converting to String**

- **toString()**: Converts this sequence to a `String`.
  ```java
  String result = sb.toString();
  ```

### 9. **Capacity and Length**

- **capacity()**: Returns the current capacity.
  ```java
  int capacity = sb.capacity();
  ```
- **length()**: Returns the length (character count).
  ```java
  int length = sb.length();
  ```
- **setLength(int newLength)**: Sets the length of the character sequence.
  ```java
  sb.setLength(10);
  ```

### 10. **Ensuring Capacity**

- **ensureCapacity(int minimumCapacity)**: Ensures that the capacity is at least equal to the specified minimum.
  ```java
  sb.ensureCapacity(100);
  ```

### Practical Examples

#### Example 1: Reversing a String

```java
public String reverseString(String s) {
    StringBuilder sb = new StringBuilder(s);
    return sb.reverse().toString();
}
```

#### Example 2: Checking Palindrome

```java
public boolean isPalindrome(String s) {
    StringBuilder cleaned = new StringBuilder();
    for (char c : s.toCharArray()) {
        if (Character.isLetterOrDigit(c)) {
            cleaned.append(Character.toLowerCase(c));
        }
    }
    String cleanedStr = cleaned.toString();
    String reversedStr = cleaned.reverse().toString();
    return cleanedStr.equals(reversedStr);
}
```

#### Example 3: Building a Comma-Separated List

```java
public String buildCommaSeparatedList(List<String> items) {
    StringBuilder sb = new StringBuilder();
    for (String item : items) {
        if (sb.length() > 0) {
            sb.append(", ");
        }
        sb.append(item);
    }
    return sb.toString();
}
```

### Summary

`StringBuilder` is a powerful tool in Java for efficient string manipulation, which is particularly useful in DSA problems where performance and memory management are critical. Understanding and utilizing these functions will allow you to handle complex string operations with ease.



Sure, here are some essential `StringBuilder` operations and examples in Java that you should know and learn:

### Creating a StringBuilder

```java
StringBuilder sb = new StringBuilder();
StringBuilder sbWithCapacity = new StringBuilder(50); // Initial capacity of 50
StringBuilder sbWithString = new StringBuilder("Hello");
```

### Appending to StringBuilder

```java
sb.append("Hello");
sb.append(" ");
sb.append("World");
System.out.println(sb.toString()); // Hello World
```

### Inserting into StringBuilder

```java
sb.insert(5, ",");
System.out.println(sb.toString()); // Hello, World
```

### Replacing a part of the StringBuilder

```java
sb.replace(5, 6, "!");
System.out.println(sb.toString()); // Hello! World
```

### Deleting from StringBuilder

```java
sb.delete(5, 6);
System.out.println(sb.toString()); // Hello World
```

### Deleting a character at a specific index

```java
sb.deleteCharAt(5);
System.out.println(sb.toString()); // HelloWorld
```

### Reversing the content of StringBuilder

```java
sb.reverse();
System.out.println(sb.toString()); // dlroWolleH
```

### Getting length and capacity

```java
int length = sb.length();
int capacity = sb.capacity();
System.out.println("Length: " + length); // Length: 10
System.out.println("Capacity: " + capacity); // Capacity: 50 (or more, depending on prior usage)
```

### Ensuring capacity

```java
sb.ensureCapacity(100);
System.out.println("New Capacity: " + sb.capacity()); // Capacity: 100
```

### Setting length

```java
sb.setLength(5);
System.out.println(sb.toString()); // dlroW (truncated)
```

### Accessing characters

```java
char ch = sb.charAt(2);
System.out.println(ch); // r
```

### Setting characters

```java
sb.setCharAt(0, 'H');
System.out.println(sb.toString()); // HlroW
```

### Converting to String

```java
String result = sb.toString();
System.out.println(result); // HlroW
```

### Chaining Methods

You can chain multiple methods together for more concise code.

```java
StringBuilder chained = new StringBuilder();
chained.append("Hello").append(" ").append("World").insert(5, ",").deleteCharAt(5).reverse();
System.out.println(chained.toString()); // dlroWolleH
```

### Full Example

Here's a complete example that demonstrates various `StringBuilder` methods:

```java
public class StringBuilderExample {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("Welcome");
      
        // Append
        sb.append(" to the ");
        sb.append("Java World");
        System.out.println(sb); // Welcome to the Java World

        // Insert
        sb.insert(11, "amazing ");
        System.out.println(sb); // Welcome to the amazing Java World

        // Replace
        sb.replace(0, 7, "Hello");
        System.out.println(sb); // Hello to the amazing Java World

        // Delete
        sb.delete(11, 19);
        System.out.println(sb); // Hello to the Java World

        // Reverse
        sb.reverse();
        System.out.println(sb); // dlroW avaJ eht ot olleH

        // Char at and set char at
        char ch = sb.charAt(5);
        System.out.println(ch); // a
        sb.setCharAt(5, 'A');
        System.out.println(sb); // dlroW AvAJ eht ot olleH

        // Length and capacity
        System.out.println("Length: " + sb.length()); // Length: 25
        System.out.println("Capacity: " + sb.capacity()); // Capacity depends on initial settings

        // Ensure capacity
        sb.ensureCapacity(50);
        System.out.println("New Capacity: " + sb.capacity()); // New Capacity: 50 or more

        // Set length
        sb.setLength(10);
        System.out.println(sb); // dlroW AvAJ (truncated)

        // Convert to string
        String result = sb.toString();
        System.out.println(result); // dlroW AvAJ
    }
}
```

### Summary

Learning `StringBuilder` operations is essential for efficient string manipulation in Java, especially when dealing with mutable strings and performance-sensitive applications. The above examples cover most of the common operations you might need.
