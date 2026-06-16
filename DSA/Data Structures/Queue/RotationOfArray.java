import java.util.*;

public class RotationOfArray {

  public static void rotateArray(int[] arr, int k) {
    int n = arr.length;

    // To handle cases where k is larger than the array size
    k = k % n;

    // Create a temporary array to store the rotated elements
    int[] temp = new int[n];

    // Copy the last 'k' elements to the temporary array
    for (int i = 0; i < k; i++) {
      temp[i] = arr[n - k + i];
    }

    // Shift the remaining elements to the right
    for (int i = 0; i < n - k; i++) {
      temp[i + k] = arr[i];
    }

    // Copy the rotated array back to the original array
    System.arraycopy(temp, 0, arr, 0, n);
  }

  public static void main(String[] args) {
    int[] arr = { 1, 2, 3, 4, 5 };
    int k = 2; // Number of positions to rotate

    System.out.println("Original Array: " + Arrays.toString(arr));

    rotateArray(arr, k);

    System.out.println(
      "Array after rotating by " + k + " positions: " + Arrays.toString(arr)
    );
  }
}