//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z; 
    }
}


class Solution {
    // Function to find the maximum profit and the number of jobs done
    int[] JobScheduling(Job arr[], int n) {
        // Sorting all jobs according to decreasing order of profit using lambda expression
        Arrays.sort(arr, (j1, j2) -> Integer.compare(j2.profit, j1.profit));

        int res = 0; // Total profit
        int count = 0; // Number of jobs done
        int[] result = new int[n]; // Array to store job indices
        boolean[] slot = new boolean[n]; // Boolean array to keep track of free slots

        // Initializing all slots to free
        Arrays.fill(slot, false);

        // Iterating through all given jobs
        for (int i = 0; i < n; i++) {
            // Finding a free slot for the current job (starting from the last possible slot)
            for (int j = Math.min(n, arr[i].deadline) - 1; j >= 0; j--) {
                // If a free slot is found, add the current job to the result array
                if (!slot[j]) {
                    result[j] = i;
                    slot[j] = true;
                    break;
                }
            }
        }

        // Calculating the total number of jobs done and the total profit
        for (int i = 0; i < n; i++) {
            if (slot[i]) {
                count++;
                res += arr[result[i]].profit;
            }
        }

        // Storing the count of jobs and max profit in an array and returning it
        return new int[] { count, res };
    }
}



/*
class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z; 
    }
}
*/