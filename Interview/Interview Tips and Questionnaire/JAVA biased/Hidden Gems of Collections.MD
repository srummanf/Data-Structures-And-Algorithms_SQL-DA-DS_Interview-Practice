# Hidden Gems of Collections

The Java Collections Framework has many hidden gems that are highly useful for competitive programming. These utilities can help optimize code, reduce complexity, and improve readability. Here are some of the most valuable ones:

### 1. **`Collections.binarySearch()`**

- **Use**: Efficiently searches for a key in a sorted list in **O(log n)** time.
- **Why Useful**: Helps avoid writing your own binary search code, and the negative return value makes it easy to handle the "not found" case and determine insertion points.

```java
   List<Integer> list = Arrays.asList(1, 3, 5, 7, 9);
   int pos = Collections.binarySearch(list, 5);  // Returns 2
   int pos2 = Collections.binarySearch(list, 6); // Returns -4 (insertion point)
```

### 2. **`Collections.reverse()`**

- **Use**: Reverses the order of elements in a list.
- **Why Useful**: Avoids the need to manually reverse arrays or lists, and operates in **O(n)**.

```java
   List<Integer> list = Arrays.asList(1, 2, 3, 4);
   Collections.reverse(list);  // List is now [4, 3, 2, 1]
```

### 3. **`Collections.swap()`**

- **Use**: Swaps the elements at two specified positions in a list.
- **Why Useful**: Can be handy for implementing algorithms that require swapping elements (like sorting algorithms or permutations).

```java
   List<Integer> list = Arrays.asList(1, 2, 3, 4);
   Collections.swap(list, 0, 3);  // Swaps the first and last element
```

### 4. **`Collections.min()` and `Collections.max()`**

- **Use**: Finds the minimum or maximum element in a collection.
- **Why Useful**: Saves time by not having to manually write code to find the min/max value.

```java
   List<Integer> list = Arrays.asList(5, 2, 8, 1, 3);
   int min = Collections.min(list);  // Returns 1
   int max = Collections.max(list);  // Returns 8
```

### 5. **`Collections.fill()`**

- **Use**: Fills a list with the specified value.
- **Why Useful**: Can be useful for initializing lists or resetting values.

```java
   List<Integer> list = new ArrayList<>(Collections.nCopies(5, 0));  // Creates [0, 0, 0, 0, 0]
   Collections.fill(list, 1);  // Now list is [1, 1, 1, 1, 1]
```

### 6. **`Collections.frequency()`**

- **Use**: Counts the frequency of a specified element in a collection.
- **Why Useful**: Makes it easy to count occurrences of an element without writing a loop.

```java
   List<Integer> list = Arrays.asList(1, 2, 2, 3, 3, 3);
   int freq = Collections.frequency(list, 3);  // Returns 3
```

### 7. **`Collections.rotate()`**

- **Use**: Rotates the elements of a list by a specified distance.
- **Why Useful**: Provides an easy way to shift elements in circular fashion.

```java
   List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
   Collections.rotate(list, 2);  // List is now [4, 5, 1, 2, 3]
```

### 8. **`Collections.disjoint()`**

- **Use**: Checks whether two collections have no elements in common.
- **Why Useful**: Useful for checking for overlap between two data sets.

```java
   List<Integer> list1 = Arrays.asList(1, 2, 3);
   List<Integer> list2 = Arrays.asList(4, 5, 6);
   boolean disjoint = Collections.disjoint(list1, list2);  // Returns true
```

### 9. **`PriorityQueue`** (part of Java's Collection framework, but highly useful in CP)

- **Use**: Efficient way to implement a min-heap or max-heap for priority queue operations.
- **Why Useful**: Makes it easy to solve problems requiring dynamic ordering like Dijkstra's shortest path, median-finding, etc.

```java
   PriorityQueue<Integer> pq = new PriorityQueue<>();
   pq.add(10);
   pq.add(5);
   pq.add(20);
   System.out.println(pq.poll());  // Returns 5 (smallest element)
```

### 10. **`Deque` and `ArrayDeque`**

- **Use**: Efficient for both stack and queue operations.
- **Why Useful**: Allows **O(1)** insertion/removal from both ends, making it ideal for problems like sliding window, BFS, or implementing stacks.

```java
   Deque<Integer> deque = new ArrayDeque<>();
   deque.addFirst(1);  // Stack-like
   deque.addLast(2);   // Queue-like
   deque.pollFirst();  // Removes from the front
```

### 11. **`Collections.unmodifiableList()`**

- **Use**: Returns an unmodifiable view of the specified list.
- **Why Useful**: Useful in scenarios where you want to protect data from being altered after passing it around.

```java
   List<Integer> list = Arrays.asList(1, 2, 3);
   List<Integer> unmodifiableList = Collections.unmodifiableList(list);
```

### 12. **`Arrays.asList()`**

- **Use**: Converts an array to a fixed-size list.
- **Why Useful**: Quick way to create a list from an array for faster operations like binary search.

```java
   List<Integer> list = Arrays.asList(1, 2, 3);
```

### 13. **`Collections.unmodifiableMap()`**

- **Use**: Creates an unmodifiable map that cannot be changed after creation.
- **Why Useful**: Useful for caching or protecting a map in algorithms where immutability is required.

```java
   Map<String, Integer> map = new HashMap<>();
   map.put("key1", 1);
   Map<String, Integer> unmodifiableMap = Collections.unmodifiableMap(map);
```

### 14. **`TreeMap` and `TreeSet`**

- **Use**: Implements sorted maps and sets.
- **Why Useful**: Efficient for maintaining sorted elements, allowing for fast retrieval of min/max, floor/ceiling, and range queries.

```java
   TreeSet<Integer> treeSet = new TreeSet<>();
   treeSet.add(10);
   treeSet.add(5);
   System.out.println(treeSet.ceiling(6));  // Returns 10 (smallest element >= 6)
```

### 15. **`Collections.nCopies()`**

- **Use**: Creates an immutable list containing the specified number of copies of an element.
- **Why Useful**: Useful for quick initialization of collections.

```java
   List<String> list = Collections.nCopies(5, "A");  // Creates ["A", "A", "A", "A", "A"]
```

### 16. **`Collections.shuffle()`**

- **Use**: Randomly shuffles the elements of a list.
- **Why Useful**: Useful in problems where randomized input or testing is required.

```java
   List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
   Collections.shuffle(list);  // Randomizes the order of elements
```

These utilities from Java's `Collections` framework can help you write more concise, efficient, and readable code in competitive programming. By leveraging them, you can avoid reinventing common algorithms and focus on solving the problem at hand!

Sure! Here are **more hidden gems** from the Java Collections Framework and beyond that can help you in **competitive programming**:

### 17. **`Collections.unmodifiableSet()`**

- **Use**: Creates an unmodifiable view of the specified set.
- **Why Useful**: Helps ensure that a set remains unchanged after initialization, useful when sharing data between functions that shouldn't alter it.

```java
   Set<String> set = new HashSet<>(Arrays.asList("apple", "banana", "cherry"));
   Set<String> unmodifiableSet = Collections.unmodifiableSet(set);
```

### 18. **`Collections.synchronizedList()`**

- **Use**: Returns a thread-safe list by synchronizing all access to it.
- **Why Useful**: When you need to manage multiple threads in competitive programming (though it's not common in CP), a synchronized list will ensure no concurrency issues.

```java
   List<Integer> list = Collections.synchronizedList(new ArrayList<>());
```

### 19. **`EnumSet`**

- **Use**: A high-performance Set implementation for enum types.
- **Why Useful**: If you work with a small set of fixed constants (like `Direction.NORTH`, `Direction.SOUTH`, etc.), `EnumSet` can be much faster and more memory-efficient than HashSet.

```java
   enum Direction { NORTH, SOUTH, EAST, WEST }
   EnumSet<Direction> directions = EnumSet.of(Direction.NORTH, Direction.EAST);
```

### 20. **`Deque.pollLast()` and `Deque.pollFirst()`**

- **Use**: Retrieves and removes elements from both ends of the deque.
- **Why Useful**: Ideal for problems like sliding windows, maintaining active ranges, or BFS/DFS-like scenarios.

```java
   Deque<Integer> deque = new ArrayDeque<>();
   deque.addFirst(10);  // Acts like a stack
   deque.pollLast();    // Acts like a queue
```

### 21. **`Map.computeIfAbsent()`**

- **Use**: Computes a value if a key is absent and inserts it into the map.
- **Why Useful**: This method is great for simplifying logic when you need to lazily initialize values, such as in a frequency map or adjacency list in graph problems.

```java
   Map<String, List<Integer>> map = new HashMap<>();
   map.computeIfAbsent("key", k -> new ArrayList<>()).add(10);  // Adds 10 to the list for "key"
```

### 22. **`NavigableSet` and `NavigableMap`**

- **Use**: These are extensions of `TreeSet` and `TreeMap` that provide additional navigation methods like `lower()`, `higher()`, `floor()`, and `ceiling()`.
- **Why Useful**: Efficient for range queries, finding closest values, and more complex operations that require sorted order.

```java
   NavigableSet<Integer> set = new TreeSet<>(Arrays.asList(1, 3, 5, 7, 9));
   System.out.println(set.ceiling(6));  // Returns 7 (smallest number >= 6)
   System.out.println(set.floor(4));    // Returns 3 (largest number <= 4)
```

### 23. **`Collections.addAll()`**

- **Use**: Efficiently adds multiple elements to a collection in one call.
- **Why Useful**: Saves time when populating collections, especially in problems that involve handling multiple input values at once.

```java
   List<Integer> list = new ArrayList<>();
   Collections.addAll(list, 1, 2, 3, 4, 5);  // Adds multiple elements at once
```

### 24. **`ArrayList.trimToSize()`**

- **Use**: Trims the capacity of an `ArrayList` to its current size to save memory.
- **Why Useful**: This is useful when memory optimization matters (especially in large datasets or memory-constrained environments).

```java
   ArrayList<Integer> list = new ArrayList<>(100);  // Initial capacity of 100
   list.trimToSize();  // Reduces the capacity to the actual number of elements
```

### 25. **`Stack`**

- **Use**: Provides basic stack operations like `push()`, `pop()`, `peek()`.
- **Why Useful**: While `Deque` is more efficient, `Stack` is still convenient for quick use in problems involving depth-first search (DFS), backtracking, or evaluation of expressions.

```java
   Stack<Integer> stack = new Stack<>();
   stack.push(10);
   System.out.println(stack.pop());  // Removes and prints the top element
```

### 26. **`BitSet`**

- **Use**: A memory-efficient way of storing and manipulating bits. It allows bitwise operations over a set of booleans.
- **Why Useful**: Can be very efficient for problems where you need to track binary states (e.g., subsets, visited states in DP).

```java
   BitSet bitSet = new BitSet();
   bitSet.set(0);  // Sets the 0th bit to true
   bitSet.set(2);  // Sets the 2nd bit to true
   System.out.println(bitSet);  // Prints: {0, 2}
```

### 27. **`Collections.emptyList()`, `emptyMap()`, `emptySet()`**

- **Use**: Returns immutable empty collections.
- **Why Useful**: Useful for returning default values or initializing placeholders where empty values are required.

```java
   List<String> emptyList = Collections.emptyList();  // Returns an empty, immutable list
```

### 28. **`ConcurrentHashMap`**

- **Use**: Provides thread-safe operations without blocking the entire map, only parts of it.
- **Why Useful**: Helpful in multi-threaded environments for CP problems that involve concurrency (though rare in CP).

```java
   Map<String, Integer> map = new ConcurrentHashMap<>();
   map.put("key", 1);
```

### 29. **`Arrays.parallelSort()`**

- **Use**: Sorts large arrays in parallel using multiple threads.
- **Why Useful**: Faster than `Arrays.sort()` for very large datasets when multi-threading is beneficial.

```java
   int[] arr = {5, 2, 8, 3, 1};
   Arrays.parallelSort(arr);  // Parallel sorting using multiple threads
```

### 30. **`Random.shuffle()` and `Random.nextInt()`**

- **Use**: Useful for generating random permutations or random selections.
- **Why Useful**: Great for randomized algorithms and test case generation.

```java
   Random random = new Random();
   List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
   Collections.shuffle(list, random);  // Shuffles list randomly
```

### 31. **`WeakHashMap`**

- **Use**: Holds weak references to keys, meaning they can be garbage-collected if no strong reference exists elsewhere.
- **Why Useful**: Useful in scenarios like memoization where you don’t want memory to bloat unnecessarily.

```java
   WeakHashMap<Object, String> map = new WeakHashMap<>();
   Object key = new Object();
   map.put(key, "value");
```

### 32. **`BlockingQueue`**

- **Use**: A thread-safe queue that supports operations waiting for the queue to become non-empty (for retrieval) or non-full (for insertion).
- **Why Useful**: Mostly useful in multi-threaded scenarios like producer-consumer problems, which can occasionally be part of competitive programming contests.

```java
   BlockingQueue<Integer> queue = new LinkedBlockingQueue<>(2);
   queue.put(1);  // Inserts 1 into the queue, waits if full
   queue.take();  // Removes and returns the head of the queue, waits if empty
```

### 33. **`EnumMap`**

- **Use**: Specialized `Map` implementation for `Enum` keys.
- **Why Useful**: Highly optimized for use with enum constants, faster and more memory-efficient than HashMap with enums.

```java
   enum Day { MONDAY, TUESDAY }
   EnumMap<Day, String> map = new EnumMap<>(Day.class);
   map.put(Day.MONDAY, "Start");
```

### 34. **`PriorityBlockingQueue`**

- **Use**: A thread-safe priority queue with blocking retrieval and insertion methods.
- **Why Useful**: Similar to `PriorityQueue`, but thread-safe, which is useful in concurrent problems involving priority tasks.

```java
   PriorityBlockingQueue<Integer> pq = new PriorityBlockingQueue<>();
   pq.put(10);  // Thread-safe insertion
   pq.take();   // Thread-safe retrieval
```

### 35. **`Collections.singletonList()`, `singleton()`**

- **Use**: Returns an immutable list or set containing exactly one element.
- **Why Useful**: Handy for initialization or quick operations when you need a collection with just one element.

```java
   List<String> singletonList = Collections.singletonList("element");  // [element]
  

```

### 36. **`TreeMap.subMap()` and `TreeMap.headMap()`**

- **Use**: Provides subviews of the map based on key ranges.
- **Why Useful**: Efficient for problems that involve range-based queries in maps.

```java
   TreeMap<Integer, String> map = new TreeMap<>();
   map.put(10, "A");
   map.put(20, "B");
   SortedMap<Integer, String> subMap = map.subMap(10, 20);  // Sub-map from key 10 to 20
```

These additional tools from the Java Collections Framework can be incredibly helpful in competitive programming for reducing boilerplate code, improving performance, and writing more concise solutions!

Here are **more hidden gems** focusing on **string manipulation** and other useful functions for competitive programming:

### 37. **`String.join()`**

- **Use**: Concatenates elements of a collection (or array) into a single string, using a specified delimiter.
- **Why Useful**: Great for combining elements, especially when formatting output.

```java
   String result = String.join(",", "apple", "banana", "cherry");
   System.out.println(result);  // Outputs: apple,banana,cherry
```

### 38. **`String.contains()`**

- **Use**: Checks if a string contains a specified sequence of characters.
- **Why Useful**: Useful for substring search without needing regex or index checks.

```java
   String s = "hello world";
   System.out.println(s.contains("world"));  // true
```

### 39. **`StringBuilder.delete()`**

- **Use**: Removes a substring from a `StringBuilder`.
- **Why Useful**: Efficient for modifying large strings, avoiding the immutability overhead of `String`.

```java
   StringBuilder sb = new StringBuilder("abcdef");
   sb.delete(2, 4);  // Deletes characters at index 2 to 4
   System.out.println(sb);  // Outputs: abef
```

### 40. **`StringBuilder.reverse()`**

- **Use**: Reverses the string inside a `StringBuilder`.
- **Why Useful**: Efficient for reversing strings in problems like palindrome checks.

```java
   StringBuilder sb = new StringBuilder("abc");
   System.out.println(sb.reverse());  // Outputs: cba
```

### 41. **`String.indexOf()` and `lastIndexOf()`**

- **Use**: Finds the first or last occurrence of a character or substring.
- **Why Useful**: Fast substring searching without regex.

```java
   String s = "abracadabra";
   System.out.println(s.indexOf("ra"));  // 2
   System.out.println(s.lastIndexOf("ra"));  // 9
```

### 42. **`String.matches()`**

- **Use**: Checks if a string matches a regex pattern.
- **Why Useful**: Quick validation for patterns like checking if a string is numeric, an email, or matches specific formats.

```java
   String s = "123";
   System.out.println(s.matches("\\d+"));  // true (checks if it's all digits)
```

### 43. **`String.split()` with limit parameter**

- **Use**: Splits a string into an array of substrings, with an optional limit on the number of splits.
- **Why Useful**: Useful for controlled string parsing in competitive programming.

```java
   String s = "a,b,c,d,e";
   String[] parts = s.split(",", 3);  // Only splits into 3 parts
   System.out.println(Arrays.toString(parts));  // [a, b, c,d,e]
```

### 44. **`Pattern.compile()` and `Matcher`**

- **Use**: `Pattern` and `Matcher` classes for more complex regex operations.
- **Why Useful**: Provides more control over regex matches, especially for advanced search and replace tasks.

```java
   Pattern pattern = Pattern.compile("\\d+");
   Matcher matcher = pattern.matcher("abc123def");
   if (matcher.find()) {
       System.out.println(matcher.group());  // Outputs: 123
   }
```

### 45. **`String.intern()`**

- **Use**: Returns a canonical representation for string comparisons.
- **Why Useful**: Reduces memory usage for large numbers of identical strings by storing only one copy in memory.

```java
   String s1 = new String("hello").intern();
   String s2 = "hello";
   System.out.println(s1 == s2);  // true, since both point to the same memory reference
```

### 46. **`String.format()`**

- **Use**: Formats a string using placeholders (like `printf` in C).
- **Why Useful**: Great for output formatting in problems where you need to control precision or spacing.

```java
   String formatted = String.format("Name: %s, Age: %d", "Alice", 25);
   System.out.println(formatted);  // Outputs: Name: Alice, Age: 25
```

### 47. **`StringBuilder.capacity()`**

- **Use**: Returns the current capacity of the `StringBuilder`.
- **Why Useful**: Knowing and adjusting the capacity is useful for optimizing performance in string-heavy operations.

```java
   StringBuilder sb = new StringBuilder(50);  // Initial capacity of 50
   System.out.println(sb.capacity());  // Outputs: 50
```

### 48. **`StringBuilder.insert()`**

- **Use**: Inserts a string or char at a specified index.
- **Why Useful**: Efficient for inserting into large strings.

```java
   StringBuilder sb = new StringBuilder("abc");
   sb.insert(1, "xyz");  // Inserts "xyz" at index 1
   System.out.println(sb);  // Outputs: axyzbc
```

### 49. **`String.replaceAll()`**

- **Use**: Replaces all occurrences of a substring matching a regex pattern.
- **Why Useful**: Helpful for efficient string manipulation without manual loops.

```java
   String s = "abc123xyz";
   System.out.println(s.replaceAll("\\d", "#"));  // Outputs: abc###xyz
```

### 50. **`CharSequence.subSequence()`**

- **Use**: Returns a new `CharSequence` that is a subsequence of the original.
- **Why Useful**: Substrings with better performance for large text manipulations.

```java
   CharSequence cs = "abcdef";
   System.out.println(cs.subSequence(1, 4));  // Outputs: bcd
```

### 51. **`StringBuilder.substring()`**

- **Use**: Extracts a substring from a `StringBuilder`.
- **Why Useful**: Useful for string operations where string immutability of `String` is a limitation.

```java
   StringBuilder sb = new StringBuilder("abcdef");
   System.out.println(sb.substring(1, 4));  // Outputs: bcd
```

### 52. **`String.regionMatches()`**

- **Use**: Compares a region of a string to another string.
- **Why Useful**: Efficient for comparing substrings without creating new string objects.

```java
   String s1 = "abcdef";
   String s2 = "bc";
   System.out.println(s1.regionMatches(1, s2, 0, 2));  // true (matches "bc")
```

### 53. **`StringBuilder.setCharAt()`**

- **Use**: Modifies a specific character in a `StringBuilder`.
- **Why Useful**: Faster than creating a new string when modifying individual characters.

```java
   StringBuilder sb = new StringBuilder("abc");
   sb.setCharAt(1, 'x');  // Sets 'b' to 'x'
   System.out.println(sb);  // Outputs: axc
```

### 54. **`StringJoiner`**

- **Use**: A more flexible alternative to `String.join()` that allows prefix and suffix to be added.
- **Why Useful**: Helpful for joining multiple strings with custom formatting.

```java
   StringJoiner joiner = new StringJoiner(", ", "[", "]");
   joiner.add("apple").add("banana").add("cherry");
   System.out.println(joiner);  // Outputs: [apple, banana, cherry]
```

### 55. **`Character.isDigit()` and `isLetter()`**

- **Use**: Checks if a character is a digit or letter.
- **Why Useful**: Handy for problems involving string parsing, validation, or character type recognition.

```java
   char ch = '5';
   System.out.println(Character.isDigit(ch));  // true
```

### 56. **`StringBuilder.appendCodePoint()`**

- **Use**: Appends the string representation of the specified Unicode code point.
- **Why Useful**: Useful when working with Unicode or dealing with multi-language text.

```java
   StringBuilder sb = new StringBuilder();
   sb.appendCodePoint(65);  // Appends the Unicode code point for 'A'
   System.out.println(sb);  // Outputs: A
```

### 57. **`String.repeat()` (Java 11+)**

- **Use**: Repeats the string a specified number of times.
- **Why Useful**: Very useful for constructing patterns or padding strings in competitive programming.

```java
   String s = "abc";
   System.out.println(s.repeat(3));  // Outputs: abcabcabc
```

### 58. **`String.strip()` and `stripLeading()` / `stripTrailing()` (Java 11+)**

- **Use**: Removes all leading and trailing whitespaces, even those not recognized by `trim()`.
- **Why Useful

Here are **more hidden gems** from the **Java Collections Framework** that can be very useful for **trees, graphs**, and related algorithms in **competitive programming**:

### 59. **`PriorityQueue` (Min/Max Heap)**

- **Use**: Implements a priority queue, which is helpful for graph algorithms like Dijkstra's or Prim's, where you need to retrieve the smallest or largest element efficiently.
- **Why Useful**: Optimizes access to the smallest/largest element in O(log n) time.

```java
   PriorityQueue<Integer> pq = new PriorityQueue<>();
   pq.add(10);
   pq.add(20);
   pq.add(5);
   System.out.println(pq.poll());  // Outputs: 5 (smallest element)
```

### 60. **`Deque` as a double-ended queue**

- **Use**: Can be used both as a stack (LIFO) and a queue (FIFO), especially helpful for BFS, DFS, and sliding window algorithms.
- **Why Useful**: Efficiently adds and removes elements from both ends.

```java
   Deque<Integer> deque = new ArrayDeque<>();
   deque.addFirst(10);  // Acts as a stack
   deque.addLast(20);   // Acts as a queue
   System.out.println(deque.pollFirst());  // Outputs: 10
```

### 61. **`LinkedHashSet` for maintaining insertion order**

- **Use**: Retains the order of insertion and can be useful when traversing graphs or trees where order matters.
- **Why Useful**: Combines the uniqueness property of `HashSet` with predictable iteration order.

```java
   Set<Integer> set = new LinkedHashSet<>();
   set.add(1);
   set.add(3);
   set.add(2);
   System.out.println(set);  // Outputs: [1, 3, 2]
```

### 62. **`TreeMap` for dynamic range queries**

- **Use**: Perfect for graph problems involving node ranges or finding minimum/maximum nodes in a given range.
- **Why Useful**: Implements a red-black tree, providing O(log n) performance for operations like floor, ceiling, and range-based queries.

```java
   TreeMap<Integer, String> map = new TreeMap<>();
   map.put(5, "five");
   map.put(2, "two");
   System.out.println(map.ceilingKey(4));  // Outputs: 5 (smallest key >= 4)
```

### 63. **`Graph traversal using BFS/DFS with Deque`**

- **Use**: Deque can be very efficient for BFS and DFS in graph traversal, especially when you need to control access to both ends.
- **Why Useful**: Offers O(1) time complexity for adding/removing from both ends.

```java
   Deque<Integer> deque = new ArrayDeque<>();
   deque.add(0);  // Root node for BFS or DFS
   while (!deque.isEmpty()) {
       int node = deque.poll();  // For BFS
       // deque.pollLast();  // For DFS
       // process node...
   }
```

### 64. **`Union-Find/Disjoint Set` using `Map`**

- **Use**: Maps can efficiently track the parent of each node in a disjoint set, useful for graph problems like cycle detection and finding connected components.
- **Why Useful**: Helps solve dynamic connectivity problems like Kruskal’s Algorithm for Minimum Spanning Tree (MST).

```java
   class UnionFind {
       Map<Integer, Integer> parent = new HashMap<>();

       public int find(int u) {
           if (parent.get(u) == u) return u;
           parent.put(u, find(parent.get(u)));  // Path compression
           return parent.get(u);
       }

       public void union(int u, int v) {
           int pu = find(u), pv = find(v);
           if (pu != pv) parent.put(pu, pv);
       }
   }
```

### 65. **`HashMap<Integer, List<Integer>>` for adjacency list representation**

- **Use**: Efficient way to represent graphs using an adjacency list for BFS, DFS, or Dijkstra's.
- **Why Useful**: Quick access to neighboring nodes, great for large graphs.

```java
   Map<Integer, List<Integer>> adjList = new HashMap<>();
   adjList.putIfAbsent(1, new ArrayList<>());
   adjList.get(1).add(2);  // Edge from node 1 to node 2
```

### 66. **`TreeSet` for maintaining sorted sets of nodes**

- **Use**: Automatically maintains elements in a sorted order, useful in graph traversal or tree algorithms when dealing with dynamic ranges or constraints.
- **Why Useful**: Perfect for problems where you need to keep track of nodes in a sorted order while modifying the graph/tree.

```java
   TreeSet<Integer> set = new TreeSet<>();
   set.add(3);
   set.add(1);
   set.add(2);
   System.out.println(set.first());  // Outputs: 1 (smallest element)
```

### 67. **`Collections.swap()` for graph traversal**

- **Use**: Simple and handy for swapping values when performing algorithms that require sorting or rearranging, such as in BFS or DFS algorithms.
- **Why Useful**: Reduces boilerplate code for swapping.

```java
   List<Integer> list = Arrays.asList(1, 2, 3);
   Collections.swap(list, 0, 2);  // Swaps elements at index 0 and 2
   System.out.println(list);  // Outputs: [3, 2, 1]
```

### 68. **`Arrays.fill()` for initializing node values**

- **Use**: Quickly initialize arrays, which is often needed for marking visited nodes in graph algorithms like BFS and DFS.
- **Why Useful**: Reduces setup time and error-prone manual initialization.

```java
   int[] visited = new int[10];
   Arrays.fill(visited, -1);  // Mark all nodes as unvisited
```

### 69. **`Collections.nCopies()` for initializing lists in graph algorithms**

- **Use**: Create a list filled with a specific value repeated `n` times, which is useful for initializing lists with a default value for visited nodes, distances, etc.
- **Why Useful**: Quickly initializes lists with a default value.

```java
   List<Integer> dist = new ArrayList<>(Collections.nCopies(10, Integer.MAX_VALUE));  // Initialize distances to infinity
```

### 70. **`Map.computeIfAbsent()` for adjacency list creation**

- **Use**: Automatically creates a new list if the key does not exist in the map, useful for adjacency list creation in graphs.
- **Why Useful**: Reduces boilerplate code when working with graph representations.

```java
   Map<Integer, List<Integer>> graph = new HashMap<>();
   graph.computeIfAbsent(1, k -> new ArrayList<>()).add(2);  // Automatically initializes list if absent
```

### 71. **`Deque.addAll()` for BFS/DFS traversal**

- **Use**: Quickly add all nodes at once to a deque in BFS or DFS.
- **Why Useful**: Convenient when processing multiple nodes simultaneously in graph traversal.

```java
   Deque<Integer> deque = new ArrayDeque<>();
   List<Integer> neighbors = Arrays.asList(1, 2, 3);
   deque.addAll(neighbors);  // Adds all neighbors to the deque
```

### 72. **`LinkedHashMap` for storing node visitation order**

- **Use**: Preserves the order of insertion in graph traversal, which can be useful for algorithms where the order of node visits matters.
- **Why Useful**: Allows access to elements in insertion order, useful in algorithms where order preservation is needed.

```java
   LinkedHashMap<Integer, Boolean> visited = new LinkedHashMap<>();
   visited.put(1, true);
   visited.put(2, true);
   System.out.println(visited.keySet());  // Outputs: [1, 2] in order of insertion
```

### 73. **`Collections.min()` and `Collections.max()` on sets of nodes**

- **Use**: Finds the smallest or largest node/vertex in a set.
- **Why Useful**: Useful for dynamic graphs or tree structures where node weights or distances are frequently updated.

```java
   List<Integer> list = Arrays.asList(3, 1, 2);
   System.out.println(Collections.min(list));  // Outputs: 1
```

### 74. **`BitSet` for space-efficient node marking**

- **Use**: A memory-efficient way to store and manipulate large sets of boolean values, useful for marking visited nodes in graph algorithms.
- **Why Useful**: Saves space when dealing with large graphs, especially when marking visited nodes.

```java
   BitSet visited = new BitSet(1000);  // Space-efficient boolean array
   visited.set(2);  // Mark node 2 as visited
   System.out.println(visited.get(2));  // Outputs: true
```

These tools can help you optimize your graph and tree-related algorithms, improving performance and reducing the complexity of your code!

Here are **hidden gems** from the **Java Collections Framework** and Java standard libraries that can help you when implementing or working with **Trie (Prefix Tree)** data structures:

### 75. **`Map<Character, Node>` for child nodes in Trie**

- **Use**: Represents child nodes of each Trie node. Using a `HashMap<Character, Node>` or `TreeMap<Character, Node>` helps store children in an efficient and flexible way.
- **Why Useful**: Allows dynamic insertion of characters with fast lookups for each character, essential for Trie node management.

```java
   class TrieNode {
       Map<Character, TrieNode> children = new HashMap<>();
       boolean isEndOfWord = false;
   }
```

### 76. **`computeIfAbsent()` for efficient node creation in Trie**

- **Use**: This method is perfect for building Trie nodes dynamically during insertion, reducing boilerplate code.
- **Why Useful**: Eliminates the need for checking if a child node exists before creating a new one.

```java
   public void insert(String word) {
       TrieNode node = root;
       for (char c : word.toCharArray()) {
           node = node.children.computeIfAbsent(c, k -> new TrieNode());
       }
       node.isEndOfWord = true;
   }
```

### 77. **`Collections.unmodifiableMap()` for making Trie nodes read-only**

- **Use**: If you want to ensure that the Trie nodes or certain branches are read-only after construction, you can make the map unmodifiable.
- **Why Useful**: Protects certain parts of the Trie from accidental modification, useful when you want to create an immutable Trie for search.

```java
   node.children = Collections.unmodifiableMap(node.children);
```

### 78. **`LinkedHashMap` for preserving insertion order in Trie**

- **Use**: Use a `LinkedHashMap` instead of a regular `HashMap` to maintain the insertion order of characters in each Trie node.
- **Why Useful**: Preserving the order of characters is useful in some lexicographical problems or when outputting words in the order they were inserted.

```java
   Map<Character, TrieNode> children = new LinkedHashMap<>();
```

### 79. **`TreeMap` for lexicographical order in Trie**

- **Use**: In some problems, you may need to traverse the Trie in lexicographical order. Using `TreeMap` for children ensures lexicographical order by default.
- **Why Useful**: Automatically keeps the keys (characters) sorted, helping with lexicographically ordered traversal or retrieval.

```java
   Map<Character, TrieNode> children = new TreeMap<>();
```

### 80. **`StringBuilder` for word reconstruction during Trie traversal**

- **Use**: `StringBuilder` is efficient for building and reconstructing words as you traverse a Trie node by node.
- **Why Useful**: Modifies strings in place without creating new String objects at each step, reducing time and space complexity.

```java
   public void dfs(TrieNode node, StringBuilder currentWord) {
       if (node.isEndOfWord) {
           System.out.println(currentWord.toString());  // Found a word
       }
       for (char c : node.children.keySet()) {
           currentWord.append(c);
           dfs(node.children.get(c), currentWord);
           currentWord.deleteCharAt(currentWord.length() - 1);  // Backtrack
       }
   }
```

### 81. **`Arrays.fill()` for initializing dynamic programming tables in Trie**

- **Use**: Useful for initializing DP tables when solving dynamic programming problems involving Tries, such as finding the longest common prefix.
- **Why Useful**: Quickly sets initial values, such as infinity or unvisited states.

```java
   int[] dp = new int[1000];
   Arrays.fill(dp, -1);  // Fill with a default value
```

### 82. **`Map.Entry` for character-node pairs during Trie traversal**

- **Use**: `Map.Entry` provides a clean and efficient way to loop over children of a Trie node (character and child node pairs).
- **Why Useful**: Simplifies code readability when iterating over a node's children, especially useful in DFS or BFS.

```java
   for (Map.Entry<Character, TrieNode> entry : node.children.entrySet()) {
       char c = entry.getKey();
       TrieNode child = entry.getValue();
       // process c and child...
   }
```

### 83. **`removeIf()` for cleaning up unnecessary branches in Trie**

- **Use**: If you're performing a deletion in a Trie, `removeIf()` can clean up unnecessary child nodes once a word is deleted.
- **Why Useful**: Allows you to easily prune branches that are no longer needed after a deletion.

```java
   node.children.removeIf((char, child) -> child.isEndOfWord == false && child.children.isEmpty());
```

### 84. **`BitSet` for optimizing search over character set**

- **Use**: A `BitSet` is a compact representation of a set of bits that can be useful for tracking the presence or absence of characters in a Trie node.
- **Why Useful**: Saves space when tracking the existence of 26 lowercase letters in Trie.

```java
   BitSet present = new BitSet(26);  // Tracks presence of letters a-z
   present.set(c - 'a');  // Mark letter 'c' as present
```

### 85. **`Optional` for null-safe traversal in Trie**

- **Use**: Java's `Optional` can be used to avoid `NullPointerException` when traversing a Trie, especially when performing operations like search or prefix matching.
- **Why Useful**: Simplifies null checks while traversing the Trie.

```java
   public boolean search(String word) {
       TrieNode node = root;
       for (char c : word.toCharArray()) {
           node = Optional.ofNullable(node.children.get(c)).orElse(null);
           if (node == null) return false;
       }
       return node.isEndOfWord;
   }
```

### 86. **`IntStream` for character manipulation in Trie**

- **Use**: Use `IntStream` to loop through characters when working with Trie operations such as insertion or searching by ASCII values.
- **Why Useful**: Simplifies looping over character ranges and can also be used for parallelism when inserting or searching large numbers of words.

```java
   IntStream.range(0, word.length())
       .forEach(i -> {
           char c = word.charAt(i);
           node = node.children.computeIfAbsent(c, k -> new TrieNode());
       });
```

### 87. **`NavigableMap` for prefix search with range queries**

- **Use**: A `NavigableMap` (which is a subtype of `TreeMap`) allows for more advanced operations, like finding keys within a specific range or floor/ceiling values, useful in problems involving prefix search.
- **Why Useful**: Offers powerful methods for range queries like `subMap()`, `floorEntry()`, and `ceilingEntry()`.

```java
   NavigableMap<String, String> map = new TreeMap<>();
   map.put("apple", "fruit");
   map.put("apricot", "fruit");
   System.out.println(map.subMap("ap", "ar"));  // Outputs: {apple=fruit, apricot=fruit}
```

### 88. **`CharBuffer` for efficient handling of character sequences**

- **Use**: `CharBuffer` can be useful in handling sequences of characters when manipulating words during Trie insertion or search.
- **Why Useful**: Provides efficient reading, writing, and manipulation of character sequences without converting them to strings.

```java
   CharBuffer buffer = CharBuffer.wrap(word.toCharArray());
   while (buffer.hasRemaining()) {
       char c = buffer.get();
       // Process character 'c'
   }
```

### 89. **`Collections.emptyMap()` for lightweight empty node initialization**

- **Use**: When a node in the Trie has no children, using `Collections.emptyMap()` instead of a `HashMap` reduces memory overhead.
- **Why Useful**: Saves memory for Trie nodes that do not have any children, making Trie operations more space-efficient.

```java
   node.children = Collections.emptyMap();  // For leaf nodes with no children
```

### 90. **`Collectors.joining()` for word generation in Trie**

- **Use**: If you're collecting characters from a Trie traversal and want to generate a string, you can use `Collectors.joining()` to concatenate characters into a single string.
- **Why Useful**: Simplifies the process of concatenating characters into words.

```java
   List<String> chars = Arrays.asList("a", "p", "p", "l", "e");
   String word = chars.stream().collect(Collectors.joining());
   System.out.println(word);  // Outputs: "apple"
```

These **hidden gems** will make your Trie implementations more **efficient** and help reduce complexity in managing character sequences, dynamic node handling, and advanced Trie-based searches!
