# Sorting Algorithms Guide in Java 🔄

A comprehensive collection of sorting algorithms implemented in Java, from basic to advanced techniques.

## Table of Contents

* [Basic Sorting Algorithms](#basic-sorting-algorithms)
* [Efficient Sorting Algorithms](#efficient-sorting-algorithms)
* [Specialized Sorting Algorithms](#specialized-sorting-algorithms)
* [Non-Comparison Based Sorts](#non-comparison-based-sorts)
* [Lesser-Known Sorting Algorithms](#lesser-known-sorting-algorithms)
* [Hybrid Sorting Algorithms](#hybrid-sorting-algorithms)
* [Comparison Table](#comparison-table)
* [Interview Tips](#interview-tips)

---

## Basic Sorting Algorithms

### 1. Bubble Sort

 **Concept** : Repeatedly compares adjacent elements and swaps them if they're in wrong order.

```java
public class BubbleSort {
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;
      
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap elements
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            // If no swapping occurred, array is sorted
            if (!swapped) break;
        }
    }
}
```

 **Properties** :

* **Time** : Best O(n), Average O(n²), Worst O(n²)
* **Space** : O(1)
* **Stable** : Yes
* **Adaptive** : Yes (with optimization)

### 2. Selection Sort

 **Concept** : Selects the minimum element and places it at the beginning.

```java
public class SelectionSort {
    public static void selectionSort(int[] arr) {
        int n = arr.length;
      
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
          
            // Find minimum element in remaining array
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }
          
            // Swap minimum element with first element
            int temp = arr[minIdx];
            arr[minIdx] = arr[i];
            arr[i] = temp;
        }
    }
}
```

 **Properties** :

* **Time** : O(n²) for all cases
* **Space** : O(1)
* **Stable** : No
* **Adaptive** : No

### 3. Insertion Sort

 **Concept** : Builds sorted array one element at a time by inserting each element in its correct position.

```java
public class InsertionSort {
    public static void insertionSort(int[] arr) {
        int n = arr.length;
      
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
          
            // Move elements greater than key one position ahead
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }
  
    // Binary Insertion Sort variant
    public static void binaryInsertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int left = 0, right = i;
          
            // Find location using binary search
            while (left < right) {
                int mid = (left + right) / 2;
                if (arr[mid] > key) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
          
            // Shift elements and insert
            System.arraycopy(arr, left, arr, left + 1, i - left);
            arr[left] = key;
        }
    }
}
```

 **Properties** :

* **Time** : Best O(n), Average O(n²), Worst O(n²)
* **Space** : O(1)
* **Stable** : Yes
* **Adaptive** : Yes

---

## Efficient Sorting Algorithms

### 4. Merge Sort

 **Concept** : Divide-and-conquer algorithm that divides array into halves, sorts them, and merges.

```java
public class MergeSort {
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
          
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }
  
    private static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
      
        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];
      
        System.arraycopy(arr, left, leftArr, 0, n1);
        System.arraycopy(arr, mid + 1, rightArr, 0, n2);
      
        int i = 0, j = 0, k = left;
      
        while (i < n1 && j < n2) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k++] = leftArr[i++];
            } else {
                arr[k++] = rightArr[j++];
            }
        }
      
        while (i < n1) arr[k++] = leftArr[i++];
        while (j < n2) arr[k++] = rightArr[j++];
    }
  
    // In-place Merge Sort (space optimized)
    public static void inPlaceMergeSort(int[] arr, int start, int end) {
        if (start < end) {
            int mid = start + (end - start) / 2;
            inPlaceMergeSort(arr, start, mid);
            inPlaceMergeSort(arr, mid + 1, end);
            inPlaceMerge(arr, start, mid, end);
        }
    }
  
    private static void inPlaceMerge(int[] arr, int start, int mid, int end) {
        int start2 = mid + 1;
      
        if (arr[mid] <= arr[start2]) return;
      
        while (start <= mid && start2 <= end) {
            if (arr[start] <= arr[start2]) {
                start++;
            } else {
                int value = arr[start2];
                int index = start2;
              
                while (index != start) {
                    arr[index] = arr[index - 1];
                    index--;
                }
                arr[start] = value;
              
                start++;
                mid++;
                start2++;
            }
        }
    }
}
```

 **Properties** :

* **Time** : O(n log n) for all cases
* **Space** : O(n) for standard, O(1) for in-place variant
* **Stable** : Yes
* **Adaptive** : No

### 5. Quick Sort

 **Concept** : Selects a pivot element and partitions array around it.

```java
public class QuickSort {
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }
  
    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
      
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return i + 1;
    }
  
    // Randomized Quick Sort
    public static void randomizedQuickSort(int[] arr, int low, int high) {
        if (low < high) {
            int randomIndex = low + (int)(Math.random() * (high - low + 1));
            swap(arr, randomIndex, high);
          
            int pi = partition(arr, low, high);
            randomizedQuickSort(arr, low, pi - 1);
            randomizedQuickSort(arr, pi + 1, high);
        }
    }
  
    // 3-Way Quick Sort (Dutch National Flag)
    public static void quickSort3Way(int[] arr, int low, int high) {
        if (low < high) {
            int[] p = partition3Way(arr, low, high);
            quickSort3Way(arr, low, p[0] - 1);
            quickSort3Way(arr, p[1] + 1, high);
        }
    }
  
    private static int[] partition3Way(int[] arr, int low, int high) {
        int pivot = arr[low];
        int i = low, lt = low, gt = high;
      
        while (i <= gt) {
            if (arr[i] < pivot) {
                swap(arr, lt++, i++);
            } else if (arr[i] > pivot) {
                swap(arr, i, gt--);
            } else {
                i++;
            }
        }
        return new int[]{lt, gt};
    }
  
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
```

 **Properties** :

* **Time** : Best O(n log n), Average O(n log n), Worst O(n²)
* **Space** : O(log n)
* **Stable** : No
* **Adaptive** : No

### 6. Heap Sort

 **Concept** : Uses binary heap data structure to sort elements.

```java
public class HeapSort {
    public static void heapSort(int[] arr) {
        int n = arr.length;
      
        // Build max heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }
      
        // Extract elements from heap one by one
        for (int i = n - 1; i > 0; i--) {
            swap(arr, 0, i);
            heapify(arr, i, 0);
        }
    }
  
    private static void heapify(int[] arr, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
      
        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }
      
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }
      
        if (largest != i) {
            swap(arr, i, largest);
            heapify(arr, n, largest);
        }
    }
  
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
```

 **Properties** :

* **Time** : O(n log n) for all cases
* **Space** : O(1)
* **Stable** : No
* **Adaptive** : No

---

## Specialized Sorting Algorithms

### 7. Shell Sort

 **Concept** : Generalization of insertion sort that allows exchange of far apart elements.

```java
public class ShellSort {
    public static void shellSort(int[] arr) {
        int n = arr.length;
      
        // Start with a big gap, then reduce the gap
        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                int temp = arr[i];
                int j;
              
                for (j = i; j >= gap && arr[j - gap] > temp; j -= gap) {
                    arr[j] = arr[j - gap];
                }
                arr[j] = temp;
            }
        }
    }
  
    // Knuth's sequence
    public static void shellSortKnuth(int[] arr) {
        int n = arr.length;
        int gap = 1;
      
        // Calculate initial gap using Knuth's sequence
        while (gap < n / 3) {
            gap = gap * 3 + 1;
        }
      
        while (gap >= 1) {
            for (int i = gap; i < n; i++) {
                int temp = arr[i];
                int j = i;
              
                while (j >= gap && arr[j - gap] > temp) {
                    arr[j] = arr[j - gap];
                    j -= gap;
                }
                arr[j] = temp;
            }
            gap /= 3;
        }
    }
}
```

 **Properties** :

* **Time** : Best O(n log n), Average O(n^1.25), Worst O(n²)
* **Space** : O(1)
* **Stable** : No
* **Adaptive** : Yes

---

## Non-Comparison Based Sorts

### 8. Counting Sort

 **Concept** : Counts occurrences of each distinct element.

```java
public class CountingSort {
    public static void countingSort(int[] arr) {
        int max = Arrays.stream(arr).max().orElse(0);
        int min = Arrays.stream(arr).min().orElse(0);
        int range = max - min + 1;
      
        int[] count = new int[range];
        int[] output = new int[arr.length];
      
        // Count occurrences
        for (int value : arr) {
            count[value - min]++;
        }
      
        // Calculate cumulative count
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }
      
        // Build output array
        for (int i = arr.length - 1; i >= 0; i--) {
            output[count[arr[i] - min] - 1] = arr[i];
            count[arr[i] - min]--;
        }
      
        System.arraycopy(output, 0, arr, 0, arr.length);
    }
  
    // For negative numbers
    public static void countingSortWithNegatives(int[] arr) {
        if (arr.length == 0) return;
      
        int max = arr[0], min = arr[0];
        for (int value : arr) {
            max = Math.max(max, value);
            min = Math.min(min, value);
        }
      
        int range = max - min + 1;
        int[] count = new int[range];
      
        for (int value : arr) {
            count[value - min]++;
        }
      
        int index = 0;
        for (int i = 0; i < range; i++) {
            while (count[i]-- > 0) {
                arr[index++] = i + min;
            }
        }
    }
}
```

 **Properties** :

* **Time** : O(n + k) where k is the range
* **Space** : O(k)
* **Stable** : Yes
* **Adaptive** : No

### 9. Radix Sort

 **Concept** : Sorts elements digit by digit starting from least significant digit.

```java
public class RadixSort {
    public static void radixSort(int[] arr) {
        int max = Arrays.stream(arr).max().orElse(0);
      
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSortByDigit(arr, exp);
        }
    }
  
    private static void countingSortByDigit(int[] arr, int exp) {
        int n = arr.length;
        int[] output = new int[n];
        int[] count = new int[10];
      
        // Count occurrences of each digit
        for (int value : arr) {
            count[(value / exp) % 10]++;
        }
      
        // Calculate cumulative count
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }
      
        // Build output array
        for (int i = n - 1; i >= 0; i--) {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }
      
        System.arraycopy(output, 0, arr, 0, n);
    }
  
    // For strings
    public static void radixSortStrings(String[] arr, int maxLength) {
        for (int pos = maxLength - 1; pos >= 0; pos--) {
            countingSortByPosition(arr, pos);
        }
    }
  
    private static void countingSortByPosition(String[] arr, int pos) {
        int n = arr.length;
        String[] output = new String[n];
        int[] count = new int[256]; // ASCII characters
      
        for (String str : arr) {
            int index = (pos < str.length()) ? str.charAt(pos) : 0;
            count[index]++;
        }
      
        for (int i = 1; i < 256; i++) {
            count[i] += count[i - 1];
        }
      
        for (int i = n - 1; i >= 0; i--) {
            int index = (pos < arr[i].length()) ? arr[i].charAt(pos) : 0;
            output[count[index] - 1] = arr[i];
            count[index]--;
        }
      
        System.arraycopy(output, 0, arr, 0, n);
    }
}
```

 **Properties** :

* **Time** : O(d × (n + k)) where d is digits, k is range
* **Space** : O(n + k)
* **Stable** : Yes
* **Adaptive** : No

### 10. Bucket Sort

 **Concept** : Distributes elements into buckets, sorts buckets individually.

```java
public class BucketSort {
    public static void bucketSort(float[] arr) {
        int n = arr.length;
        if (n <= 0) return;
      
        @SuppressWarnings("unchecked")
        ArrayList<Float>[] buckets = new ArrayList[n];
      
        // Initialize buckets
        for (int i = 0; i < n; i++) {
            buckets[i] = new ArrayList<>();
        }
      
        // Distribute elements into buckets
        for (float value : arr) {
            int bucketIndex = (int) (n * value);
            if (bucketIndex == n) bucketIndex = n - 1;
            buckets[bucketIndex].add(value);
        }
      
        // Sort individual buckets
        for (ArrayList<Float> bucket : buckets) {
            Collections.sort(bucket);
        }
      
        // Concatenate all buckets
        int index = 0;
        for (ArrayList<Float> bucket : buckets) {
            for (float value : bucket) {
                arr[index++] = value;
            }
        }
    }
  
    // For integers with custom range
    public static void bucketSortInt(int[] arr, int maxValue) {
        int n = arr.length;
        if (n <= 0) return;
      
        @SuppressWarnings("unchecked")
        ArrayList<Integer>[] buckets = new ArrayList[n];
      
        for (int i = 0; i < n; i++) {
            buckets[i] = new ArrayList<>();
        }
      
        for (int value : arr) {
            int bucketIndex = (n * value) / (maxValue + 1);
            buckets[bucketIndex].add(value);
        }
      
        for (ArrayList<Integer> bucket : buckets) {
            Collections.sort(bucket);
        }
      
        int index = 0;
        for (ArrayList<Integer> bucket : buckets) {
            for (int value : bucket) {
                arr[index++] = value;
            }
        }
    }
}
```

 **Properties** :

* **Time** : Best O(n + k), Average O(n + k), Worst O(n²)
* **Space** : O(n + k)
* **Stable** : Yes
* **Adaptive** : No

---

## Lesser-Known Sorting Algorithms

### 11. Comb Sort

 **Concept** : Improvement over bubble sort with varying gap sizes.

```java
public class CombSort {
    public static void combSort(int[] arr) {
        int n = arr.length;
        int gap = n;
        boolean swapped = true;
      
        while (gap != 1 || swapped) {
            gap = getNextGap(gap);
            swapped = false;
          
            for (int i = 0; i < n - gap; i++) {
                if (arr[i] > arr[i + gap]) {
                    swap(arr, i, i + gap);
                    swapped = true;
                }
            }
        }
    }
  
    private static int getNextGap(int gap) {
        gap = (gap * 10) / 13;
        return Math.max(gap, 1);
    }
  
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
```

### 12. Cocktail Shaker Sort (Bidirectional Bubble Sort)

 **Concept** : Bubble sort that works in both directions.

```java
public class CocktailShakerSort {
    public static void cocktailShakerSort(int[] arr) {
        int n = arr.length;
        boolean swapped = true;
        int start = 0, end = n - 1;
      
        while (swapped) {
            swapped = false;
          
            // Forward pass
            for (int i = start; i < end; i++) {
                if (arr[i] > arr[i + 1]) {
                    swap(arr, i, i + 1);
                    swapped = true;
                }
            }
          
            if (!swapped) break;
          
            end--;
            swapped = false;
          
            // Backward pass
            for (int i = end - 1; i >= start; i--) {
                if (arr[i] > arr[i + 1]) {
                    swap(arr, i, i + 1);
                    swapped = true;
                }
            }
          
            start++;
        }
    }
  
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
```

### 13. Gnome Sort (Stupid Sort)

 **Concept** : Similar to insertion sort but moves element to its correct position by series of swaps.

```java
public class GnomeSort {
    public static void gnomeSort(int[] arr) {
        int index = 0;
        int n = arr.length;
      
        while (index < n) {
            if (index == 0 || arr[index] >= arr[index - 1]) {
                index++;
            } else {
                swap(arr, index, index - 1);
                index--;
            }
        }
    }
  
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
```

### 14. Pancake Sort

 **Concept** : Sorts array by flipping subarrays.

```java
public class PancakeSort {
    public static void pancakeSort(int[] arr) {
        for (int currSize = arr.length; currSize > 1; currSize--) {
            int maxIdx = findMax(arr, currSize);
          
            if (maxIdx != currSize - 1) {
                flip(arr, maxIdx);
                flip(arr, currSize - 1);
            }
        }
    }
  
    private static int findMax(int[] arr, int n) {
        int maxIdx = 0;
        for (int i = 1; i < n; i++) {
            if (arr[i] > arr[maxIdx]) {
                maxIdx = i;
            }
        }
        return maxIdx;
    }
  
    private static void flip(int[] arr, int i) {
        int start = 0;
        while (start < i) {
            int temp = arr[start];
            arr[start] = arr[i];
            arr[i] = temp;
            start++;
            i--;
        }
    }
}
```

### 15. Stooge Sort

 **Concept** : Recursive algorithm that sorts first 2/3, then last 2/3, then first 2/3 again.

```java
public class StoogeSort {
    public static void stoogeSort(int[] arr, int l, int h) {
        if (l >= h) return;
      
        if (arr[l] > arr[h]) {
            swap(arr, l, h);
        }
      
        if (h - l + 1 > 2) {
            int t = (h - l + 1) / 3;
          
            stoogeSort(arr, l, h - t);
            stoogeSort(arr, l + t, h);
            stoogeSort(arr, l, h - t);
        }
    }
  
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
```

---

## Hybrid Sorting Algorithms

### 16. Tim Sort (Used in Java's Arrays.sort() for objects)

 **Concept** : Hybrid of merge sort and insertion sort, optimized for real-world data.

```java
public class TimSort {
    private static final int MIN_MERGE = 32;
  
    public static void timSort(int[] arr) {
        int n = arr.length;
        int minRun = minRunLength(n);
      
        // Sort individual subarrays of size minRun using insertion sort
        for (int i = 0; i < n; i += minRun) {
            insertionSort(arr, i, Math.min((i + minRun - 1), (n - 1)));
        }
      
        // Start merging from size minRun
        for (int size = minRun; size < n; size = 2 * size) {
            for (int start = 0; start < n; start += size * 2) {
                int midpoint = start + size - 1;
                int end = Math.min((start + size * 2 - 1), (n - 1));
              
                if (midpoint < end) {
                    merge(arr, start, midpoint, end);
                }
            }
        }
    }
  
    private static int minRunLength(int n) {
        assert n >= 0;
        int r = 0;
        while (n >= MIN_MERGE) {
            r |= (n & 1);
            n >>= 1;
        }
        return n + r;
    }
  
    private static void insertionSort(int[] arr, int left, int right) {
        for (int i = left + 1; i <= right; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= left && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }
  
    private static void merge(int[] arr, int l, int m, int r) {
        int len1 = m - l + 1, len2 = r - m;
        int[] left = new int[len1];
        int[] right = new int[len2];
      
        System.arraycopy(arr, l, left, 0, len1);
        System.arraycopy(arr, m + 1, right, 0, len2);
      
        int i = 0, j = 0, k = l;
      
        while (i < len1 && j < len2) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }
      
        while (i < len1) arr[k++] = left[i++];
        while (j < len2) arr[k++] = right[j++];
    }
}
```

### 17. Intro Sort (Used in Java's Arrays.sort() for primitives)

 **Concept** : Hybrid of quicksort, heapsort, and insertion sort.

```java
public class IntroSort {
    private static final int SIZE_THRESHOLD = 16;
  
    public static void introSort(int[] arr) {
        int depthLimit = (int) (2 * Math.floor(Math.log(arr.length) / Math.log(2)));
        introSortUtil(arr, 0, arr.length - 1, depthLimit);
    }
  
    private static void introSortUtil(int[] arr, int low, int high, int depthLimit) {
        while (high - low > SIZE_THRESHOLD) {
            if (depthLimit == 0) {
                heapSort(arr, low, high);
                return;
            }
            depthLimit--;
          
            int p = partition(arr, low, high);
            if (p - low < high - p) {
                introSortUtil(arr, low, p - 1, depthLimit);
                low = p + 1;
            } else {
                introSortUtil(arr, p + 1, high, depthLimit);
                high = p - 1;
            }
        }
        insertionSort(arr, low, high);
    }
  
    private static int partition(int[] arr, int low, int high) {
        int pivot = medianOfThree(arr, low, high);
        swap(arr, pivot, high);
      
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] <= arr[high]) {
                swap(arr, ++i, j);
            }
        }
        swap(arr, i + 1, high);
        return i + 1;
    }
  
    private static int medianOfThree(int[] arr, int low, int high) {
        int mid = low + (high - low) / 2;
        if (arr[mid] < arr[low]) swap(arr, low, mid);
        if (arr[high] < arr[low]) swap(arr, low, high);
        if (arr[high] < arr[mid]) swap(arr, mid, high);
        return mid;
    }
  
    private static void heapSort(int[] arr, int low, int high) {
        int n = high - low + 1;
        for (int i = low + n / 2 - 1; i >= low; i--) {
            heapify(arr, n, i, low);
        }
      
        for (int i = high; i > low; i--) {
            swap(arr, low, i);
            heapify(arr, i - low, low, low);
        }
    }
  
    private static void heapify(int[] arr, int n, int i, int offset) {
        int largest = i;
        int left = 2 * (i - offset) + 1 + offset;
        int right = 2 * (i - offset) + 2 + offset;
      
        if (left < offset + n && arr[left] > arr[largest]) {
            largest = left;
        }
      
        if (right < offset + n && arr[right] > arr[largest]) {
            largest = right;
        }
      
        if (largest != i) {
            swap(arr, i, largest);
            heapify(arr, n, largest, offset);
        }
    }
  
    private static void insertionSort(int[] arr, int low, int high) {
        for (int i = low + 1; i <= high; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= low && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }
  
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
```

---

## Even More Specialized Algorithms

### 18. Flash Sort

 **Concept** : Distribution sorting algorithm that is very fast for uniformly distributed data.

```java
public class FlashSort {
    public static void flashSort(int[] arr) {
        int n = arr.length;
        if (n <= 1) return;
      
        int m = (int) (0.45 * n); // Number of classes
        int[] l = new int[m];
      
        int min = arr[0], max = arr[0];
        for (int value : arr) {
            min = Math.min(min, value);
            max = Math.max(max, value);
        }
      
        if (min == max) return;
      
        double c1 = (double) (m - 1) / (max - min);
      
        // Count elements in each class
        for (int value : arr) {
            int k = (int) (c1 * (value - min));
            l[k]++;
        }
      
        // Transform counts to indices
        for (int i = 1; i < m; i++) {
            l[i] += l[i - 1];
        }
      
        // Permutation phase
        int move = 0, j = 0, k = m - 1;
        while (move < n - 1) {
            while (j > l[k] - 1) {
                j++;
                k = (int) (c1 * (arr[j] - min));
            }
          
            int flash = arr[j];
            while (j != l[k]) {
                k = (int) (c1 * (flash - min));
                int hold = arr[l[k] - 1];
                arr[l[k] - 1] = flash;
                flash = hold;
                l[k]--;
                move++;
            }
        }
      
        // Insertion sort for final arrangement
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j2 = i - 1;
            while (j2 >= 0 && arr[j2] > key) {
                arr[j2 + 1] = arr[j2];
                j2--;
            }
            arr[j2 + 1] = key;
        }
    }
}
```

### 19. Cycle Sort

 **Concept** : In-place sorting algorithm that minimizes the number of writes.

```java
public class CycleSort {
    public static int cycleSort(int[] arr) {
        int writes = 0;
        int n = arr.length;
      
        for (int cycleStart = 0; cycleStart <= n - 2; cycleStart++) {
            int item = arr[cycleStart];
            int pos = cycleStart;
          
            for (int i = cycleStart + 1; i < n; i++) {
                if (arr[i] < item) {
                    pos++;
                }
            }
          
            if (pos == cycleStart) {
                continue;
            }
          
            while (item == arr[pos]) {
                pos++;
            }
          
            if (pos != cycleStart) {
                int temp = item;
                item = arr[pos];
                arr[pos] = temp;
                writes++;
            }
          
            while (pos != cycleStart) {
                pos = cycleStart;
              
                for (int i = cycleStart + 1; i < n; i++) {
                    if (arr[i] < item) {
                        pos++;
                    }
                }
              
                while (item == arr[pos]) {
                    pos++;
                }
              
                if (item != arr[pos]) {
                    int temp = item;
                    item = arr[pos];
                    arr[pos] = temp;
                    writes++;
                }
            }
        }
      
        return writes;
    }
}
```

### 20. Strand Sort

 **Concept** : Comparison sorting algorithm that works by repeatedly pulling sorted sublists out of the list.

```java
public class StrandSort {
    public static void strandSort(int[] arr) {
        LinkedList<Integer> input = new LinkedList<>();
        for (int value : arr) {
            input.add(value);
        }
      
        LinkedList<Integer> result = new LinkedList<>();
      
        while (!input.isEmpty()) {
            LinkedList<Integer> sublist = new LinkedList<>();
            sublist.add(input.removeFirst());
          
            Iterator<Integer> it = input.iterator();
            while (it.hasNext()) {
                int current = it.next();
                if (current >= sublist.getLast()) {
                    sublist.add(current);
                    it.remove();
                }
            }
          
            result = merge(result, sublist);
        }
      
        for (int i = 0; i < arr.length; i++) {
            arr[i] = result.get(i);
        }
    }
  
    private static LinkedList<Integer> merge(LinkedList<Integer> left, LinkedList<Integer> right) {
        LinkedList<Integer> result = new LinkedList<>();
      
        while (!left.isEmpty() && !right.isEmpty()) {
            if (left.getFirst() <= right.getFirst()) {
                result.add(left.removeFirst());
            } else {
                result.add(right.removeFirst());
            }
        }
      
        result.addAll(left);
        result.addAll(right);
      
        return result;
    }
}
```

---

## Comparison Table

| Algorithm                | Best Case  | Average Case | Worst Case | Space    | Stable | Adaptive | In-Place | Notes                      |
| ------------------------ | ---------- | ------------ | ---------- | -------- | ------ | -------- | -------- | -------------------------- |
| **Bubble Sort**    | O(n)       | O(n²)       | O(n²)     | O(1)     | ✅     | ✅       | ✅       | Simple, educational        |
| **Selection Sort** | O(n²)     | O(n²)       | O(n²)     | O(1)     | ❌     | ❌       | ✅       | Minimal swaps              |
| **Insertion Sort** | O(n)       | O(n²)       | O(n²)     | O(1)     | ✅     | ✅       | ✅       | Good for small/sorted data |
| **Merge Sort**     | O(n log n) | O(n log n)   | O(n log n) | O(n)     | ✅     | ❌       | ❌       | Divide & conquer           |
| **Quick Sort**     | O(n log n) | O(n log n)   | O(n²)     | O(log n) | ❌     | ❌       | ✅       | Most practical             |
| **Heap Sort**      | O(n log n) | O(n log n)   | O(n log n) | O(1)     | ❌     | ❌       | ✅       | Guaranteed O(n log n)      |
| **Shell Sort**     | O(n log n) | O(n^1.25)    | O(n²)     | O(1)     | ❌     | ✅       | ✅       | Gap sequence dependent     |
| **Counting Sort**  | O(n+k)     | O(n+k)       | O(n+k)     | O(k)     | ✅     | ❌       | ❌       | Integer keys only          |
| **Radix Sort**     | O(d(n+k))  | O(d(n+k))    | O(d(n+k))  | O(n+k)   | ✅     | ❌       | ❌       | Integer/string keys        |
| **Bucket Sort**    | O(n+k)     | O(n+k)       | O(n²)     | O(n)     | ✅     | ❌       | ❌       | Uniform distribution       |
| **Comb Sort**      | O(n log n) | O(n²/2^p)   | O(n²)     | O(1)     | ❌     | ❌       | ✅       | Improved bubble sort       |
| **Cocktail Sort**  | O(n)       | O(n²)       | O(n²)     | O(1)     | ✅     | ✅       | ✅       | Bidirectional bubble       |
| **Gnome Sort**     | O(n)       | O(n²)       | O(n²)     | O(1)     | ✅     | ✅       | ✅       | Simple implementation      |
| **Tim Sort**       | O(n)       | O(n log n)   | O(n log n) | O(n)     | ✅     | ✅       | ❌       | Real-world optimized       |
| **Intro Sort**     | O(n log n) | O(n log n)   | O(n log n) | O(log n) | ❌     | ❌       | ✅       | Hybrid approach            |

---

## Interview Tips & Key Points

### 🎯 **Most Important for Interviews**

1. **Quick Sort** - Most asked, understand partitioning
2. **Merge Sort** - Stable, guaranteed O(n log n)
3. **Heap Sort** - In-place, guaranteed O(n log n)
4. **Insertion Sort** - For small arrays, nearly sorted data
5. **Counting Sort** - When range is small

### 🔥 **Common Interview Questions**

* **"Sort an array with only 0s, 1s, and 2s"** → Dutch National Flag (3-way QuickSort)
* **"Sort a nearly sorted array"** → Insertion Sort or Heap Sort
* **"Sort with minimal memory"** → In-place algorithms (Quick, Heap, Shell)
* **"Sort strings by length"** → Bucket Sort or custom comparator
* **"Stable sort requirement"** → Merge Sort, Tim Sort, or Counting Sort
* **"Sort large dataset"** → External sorting (Merge Sort variants)

### 💡 **Key Insights**

* **Comparison-based sorts** have O(n log n) lower bound
* **Non-comparison sorts** can be faster but have constraints
* **Hybrid algorithms** (Tim Sort, Intro Sort) are used in practice
* **Cache performance** matters in real implementations
* **Adaptive algorithms** perform better on partially sorted data

### 🚀 **Optimization Techniques**

1. **Random pivot** for Quick Sort to avoid worst case
2. **Insertion sort** for small subarrays in hybrid algorithms
3. **Iterative instead of recursive** to avoid stack overflow
4. **Sentinel values** to reduce boundary checks
5. **Three-way partitioning** for arrays with many duplicates

### 📊 **When to Use Which Algorithm**

* **Small arrays (< 50 elements)** : Insertion Sort
* **Nearly sorted data** : Insertion Sort, Tim Sort
* **Memory constrained** : Heap Sort, Quick Sort
* **Stability required** : Merge Sort, Tim Sort
* **Integer arrays with small range** : Counting Sort
* **Floating-point uniformly distributed** : Bucket Sort
* **General purpose** : Quick Sort or Intro Sort
* **Guaranteed performance** : Heap Sort or Merge Sort
* **External sorting** : Merge Sort variants

### 🏆 **Advanced Topics for Senior Interviews**

* **External sorting** algorithms for data too large for memory
* **Parallel sorting** algorithms (PRAM, MapReduce)
* **Cache-oblivious** sorting algorithms
* **String sorting** algorithms (Suffix arrays, LCP arrays)
* **Topological sorting** for DAGs
* **Sorting networks** and their applications

---

## Usage Examples

```java
public class SortingExample {
    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
      
        // Choose appropriate sorting algorithm based on requirements
        System.out.println("Original: " + Arrays.toString(arr));
      
        // For general purpose
        QuickSort.quickSort(arr.clone(), 0, arr.length - 1);
      
        // For stability requirement
        MergeSort.mergeSort(arr.clone(), 0, arr.length - 1);
      
        // For guaranteed O(n log n)
        HeapSort.heapSort(arr.clone());
      
        // For small/nearly sorted arrays
        InsertionSort.insertionSort(arr.clone());
      
        // For integers with small range
        CountingSort.countingSort(arr.clone());
    }
}
```

This comprehensive guide covers sorting algorithms from basic to advanced levels, providing both theoretical understanding and practical implementations for technical interviews and real-world applications.
