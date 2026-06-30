/**
 * BackTracking
 * ------------
 * -- We do something
 * - Recursive Call
 * -- Backtrack (Undo the thing we did)
 * - Recursive Call
 */


import java.util.*;

public class L6_Subsequence {

    public static void printSubsequences(int index, ArrayList ds, int[] arr, int n) {
// Base case: if we have reached the end of the array
        if (index == n) {
            System.out.println(ds);
            return;
        }

// --- CASE 1: TAKE the element ---
        ds.add(arr[index]);
        printSubsequences(index + 1, ds, arr, n);

// Backtrack: Remove the element to explore the "not take" scenario
        ds.remove(ds.size() - 1);

// --- CASE 2: NOT TAKE the element ---
        printSubsequences(index + 1, ds, arr, n);
    }

    public static void main(String[] args) {
        int[] arr = {3, 1, 2};
        int n = 3;
        ArrayList ds = new ArrayList<>();
        printSubsequences(0, ds, arr, n);
    }
}

