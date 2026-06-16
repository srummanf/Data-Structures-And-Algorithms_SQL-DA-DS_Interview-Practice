

In Java, the `List` interface, as part of the Java Collections Framework, provides various methods to manipulate list elements. For a `LinkedList` implementation of `List`, you also get additional methods specific to `LinkedList`. Here's a summary of the commonly used functions:

### Common `List` Methods

1. **`add(E e)`**: Appends the specified element to the end of the list.
2. **`add(int index, E element)`**: Inserts the specified element at the specified position in the list.
3. **`addAll(Collection<? extends E> c)`**: Appends all elements in the specified collection to the end of the list.
4. **`addAll(int index, Collection<? extends E> c)`**: Inserts all elements in the specified collection into the list at the specified position.
5. **`get(int index)`**: Returns the element at the specified position in the list.
6. **`set(int index, E element)`**: Replaces the element at the specified position in the list with the specified element.
7. **`remove(int index)`**: Removes the element at the specified position in the list.
8. **`remove(Object o)`**: Removes the first occurrence of the specified element from the list.
9. **`clear()`**: Removes all elements from the list.
10. **`contains(Object o)`**: Returns `true` if the list contains the specified element.
11. **`size()`**: Returns the number of elements in the list.
12. **`isEmpty()`**: Returns `true` if the list contains no elements.
13. **`indexOf(Object o)`**: Returns the index of the first occurrence of the specified element in the list.
14. **`lastIndexOf(Object o)`**: Returns the index of the last occurrence of the specified element in the list.
15. **`subList(int fromIndex, int toIndex)`**: Returns a view of the portion of the list between the specified `fromIndex`, inclusive, and `toIndex`, exclusive.

### `LinkedList` Specific Methods

1. **`addFirst(E e)`**: Inserts the specified element at the beginning of the list.
2. **`addLast(E e)`**: Appends the specified element to the end of the list.
3. **`removeFirst()`**: Removes and returns the first element of the list.
4. **`removeLast()`**: Removes and returns the last element of the list.
5. **`getFirst()`**: Returns the first element of the list.
6. **`getLast()`**: Returns the last element of the list.
7. **`peekFirst()`**: Retrieves, but does not remove, the first element of the list, or returns `null` if the list is empty.
8. **`peekLast()`**: Retrieves, but does not remove, the last element of the list, or returns `null` if the list is empty.
9. **`offerFirst(E e)`**: Inserts the specified element at the front of the list.
10. **`offerLast(E e)`**: Inserts the specified element at the end of the list.
11. **`pollFirst()`**: Retrieves and removes the first element of the list, or returns `null` if the list is empty.
12. **`pollLast()`**: Retrieves and removes the last element of the list, or returns `null` if the list is empty.

These methods should cover most of the typical operations you'd perform on a `List` or `LinkedList` in Java.

Sure! Here’s a sample Java code demonstrating the use of common `List` methods with `ArrayList` and `LinkedList`.

```java
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListExample {
    public static void main(String[] args) {
        // Using ArrayList
        List<String> arrayList = new ArrayList<>();
        arrayList.add("Apple");
        arrayList.add("Banana");
        arrayList.add("Cherry");

        System.out.println("ArrayList:");
        System.out.println("Original List: " + arrayList);
        System.out.println("Element at index 1: " + arrayList.get(1));
        arrayList.set(1, "Blueberry");
        System.out.println("After setting index 1 to 'Blueberry': " + arrayList);
        arrayList.remove("Cherry");
        System.out.println("After removing 'Cherry': " + arrayList);
        System.out.println("Size of ArrayList: " + arrayList.size());
        System.out.println("Contains 'Apple': " + arrayList.contains("Apple"));
        System.out.println("Index of 'Apple': " + arrayList.indexOf("Apple"));
        System.out.println("Last index of 'Apple': " + arrayList.lastIndexOf("Apple"));
        arrayList.clear();
        System.out.println("After clearing the list: " + arrayList);

        // Using LinkedList
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.addLast("Dog");
        linkedList.addLast("Cat");
        linkedList.addFirst("Elephant");

        System.out.println("\nLinkedList:");
        System.out.println("Original List: " + linkedList);
        System.out.println("First element: " + linkedList.getFirst());
        System.out.println("Last element: " + linkedList.getLast());
        linkedList.removeFirst();
        System.out.println("After removing the first element: " + linkedList);
        linkedList.removeLast();
        System.out.println("After removing the last element: " + linkedList);
        linkedList.addFirst("Lion");
        System.out.println("After adding 'Lion' at the beginning: " + linkedList);
        linkedList.offerLast("Tiger");
        System.out.println("After offering 'Tiger' at the end: " + linkedList);
        System.out.println("Peek first element: " + linkedList.peekFirst());
        System.out.println("Peek last element: " + linkedList.peekLast());
        linkedList.pollFirst();
        System.out.println("After polling the first element: " + linkedList);
    }
}
```

### Explanation:

- **ArrayList**:

  - **add()**: Adds elements to the list.
  - **get()**: Retrieves an element at a specific index.
  - **set()**: Updates an element at a specific index.
  - **remove()**: Removes an element.
  - **size()**: Returns the number of elements.
  - **contains()**: Checks if an element exists.
  - **indexOf()**: Finds the index of an element.
  - **lastIndexOf()**: Finds the last index of an element.
  - **clear()**: Clears the list.
- **LinkedList**:

  - **addFirst()**: Adds an element at the beginning.
  - **addLast()**: Adds an element at the end.
  - **getFirst()**: Retrieves the first element.
  - **getLast()**: Retrieves the last element.
  - **removeFirst()**: Removes the first element.
  - **removeLast()**: Removes the last element.
  - **offerFirst()**: Inserts an element at the front.
  - **offerLast()**: Inserts an element at the end.
  - **peekFirst()**: Retrieves, but does not remove, the first element.
  - **peekLast()**: Retrieves, but does not remove, the last element.
  - **pollFirst()**: Retrieves and removes the first element.
  - **pollLast()**: Retrieves and removes the last element.

Feel free to run this code to see how the methods work with both `ArrayList` and `LinkedList`.
