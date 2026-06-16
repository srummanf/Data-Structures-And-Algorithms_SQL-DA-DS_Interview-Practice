### Basics of Bitmasking

Bitmasking is a technique used to manipulate individual bits of data using bitwise operations. It's commonly used for problems involving sets, subsets, and various combinations of items.

#### Key Bitwise Operations

1. **AND (`&`)**: Sets each bit to 1 if both bits are 1.
2. **OR (`|`)**: Sets each bit to 1 if one of the bits is 1.
3. **XOR (`^`)**: Sets each bit to 1 if only one of the bits is 1.
4. **NOT (`~`)**: Inverts all the bits.
5. **Left Shift (`<<`)**: Shifts bits to the left by a certain number of positions (equivalent to multiplying by 2).
6. **Right Shift (`>>`)**: Shifts bits to the right by a certain number of positions (equivalent to dividing by 2).

#### Common Bitmasking Techniques

1. **Check if a bit is set**: `(number & (1 << bit)) != 0`
2. **Set a bit**: `number |= (1 << bit)`
3. **Clear a bit**: `number &= ~(1 << bit)`
4. **Toggle a bit**: `number ^= (1 << bit)`
5. **Count set bits**: Use the built-in method `Integer.bitCount(number)`

### Example Codes in Java

1. **Check if a bit is set**

```java
public class Main {
    public static boolean isBitSet(int number, int bit) {
        return (number & (1 << bit)) != 0;
    }

    public static void main(String[] args) {
        int number = 5; // Binary: 0101
        int bit = 2;
        System.out.println(isBitSet(number, bit)); // Output: true
    }
}
```

2. **Set a bit**

```java
public class Main {
    public static int setBit(int number, int bit) {
        return number | (1 << bit);
    }

    public static void main(String[] args) {
        int number = 5; // Binary: 0101
        int bit = 1;
        System.out.println(setBit(number, bit)); // Output: 7 (Binary: 0111)
    }
}
```

3. **Clear a bit**

```java
public class Main {
    public static int clearBit(int number, int bit) {
        return number & ~(1 << bit);
    }

    public static void main(String[] args) {
        int number = 5; // Binary: 0101
        int bit = 2;
        System.out.println(clearBit(number, bit)); // Output: 1 (Binary: 0001)
    }
}
```

4. **Toggle a bit**

```java
public class Main {
    public static int toggleBit(int number, int bit) {
        return number ^ (1 << bit);
    }

    public static void main(String[] args) {
        int number = 5; // Binary: 0101
        int bit = 2;
        System.out.println(toggleBit(number, bit)); // Output: 1 (Binary: 0001)
    }
}
```

5. **Count set bits**

```java
public class Main {
    public static int countSetBits(int number) {
        return Integer.bitCount(number);
    }

    public static void main(String[] args) {
        int number = 5; // Binary: 0101
        System.out.println(countSetBits(number)); // Output: 2
    }
}
```

### Practice Problems

1. **LeetCode 78: Subsets**

   **Description**: Given an integer array `nums` of unique elements, return all possible subsets (the power set).

   **Link**: [LeetCode 78 - Subsets](https://leetcode.com/problems/subsets/)
2. **LeetCode 784: Letter Case Permutation**

   **Description**: Given a string `s`, you can transform every letter individually to be lowercase or uppercase to create another string. Return a list of all possible strings we could create.

   **Link**: [LeetCode 784 - Letter Case Permutation](https://leetcode.com/problems/letter-case-permutation/)
