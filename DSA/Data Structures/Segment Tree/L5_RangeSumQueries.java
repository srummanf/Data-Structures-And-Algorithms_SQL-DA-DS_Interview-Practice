// Range Sum Queries using Segment Tree
// Problem Statement: Given an array of integers, we need to answer multiple range sum 
// queries efficiently. Each query consists of two indices (start and end), and 
// we need to return the sum of the elements in that range (inclusive).


import java.util.*;


public class L5_RangeSumQueries {
    void buildSegmentTree(int idx, int l, int r, int[] segmentTree, int[] arr) {
		if (l == r) {
			segmentTree[idx] = arr[l];
			return;
			
		}
		int mid = l + (r - l)/2;
		buildSegmentTree(2*idx + 1, l, mid, segmentTree, arr);
		buildSegmentTree(2*idx + 2, mid + 1, r, segmentTree, arr);
		
		segmentTree[idx] = segmentTree[2*idx + 1] + segmentTree[2*idx + 2];
	}
	
	int rangeQuery(int start, int end, int idx, int l, int r, int[] segmentTree){
	     // Case 1: Out of Bound
        if (l > end || r < start) {
            return 0;
        }

        // Case 2: Completely within the range
        if (l >= start && r <= end) {
            return segmentTree[idx];
        }

        // Case 3: Overlapping
        int mid = l + (r - l) / 2;
        return rangeQuery(start, end, 2 * idx + 1, l, mid, segmentTree) +
               rangeQuery(start, end, 2 * idx + 2, mid + 1, r, segmentTree);
	}
	
	List<Integer> querySum(int n, int arr[], int q, int queries[]) {
		// code here
		int[] segmentTree = new int[4*n];
		buildSegmentTree(0, 0, n - 1, segmentTree, arr);
		
		List<Integer> ans = new ArrayList<>();
		
		for(int i = 0; i<queries.length; i+=2){
		    int start = queries[i] - 1;
		    int end = queries[i+1] - 1;
		    
		    ans.add(rangeQuery(start, end, 0, 0, n-1, segmentTree));
		}
		
		return ans;
		
	}

    public static void main(String[] args) {
        L5_RangeSumQueries obj = new L5_RangeSumQueries();
        int n = 5;
        int arr[] = {1, 2, 3, 4, 5};
        int q = 2;
        int queries[] = {1, 3, 2, 4}; // Query ranges (1-based indexing)

        List<Integer> result = obj.querySum(n, arr, q, queries);
        System.out.println(result); // Output the results of the range sum queries
    }
}
