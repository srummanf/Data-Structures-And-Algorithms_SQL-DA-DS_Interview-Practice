/* Range Minimum Query using Segment Tree */

import java.util.ArrayList;
import java.util.List;

public class L6_RangeMinQuery {
    void buildSegmentTree(int idx, int l, int r, int[] segmentTree, int[] arr) {
		if (l == r) {
			segmentTree[idx] = arr[l];
			return;
			
		}
		int mid = l + (r - l)/2;
		buildSegmentTree(2*idx + 1, l, mid, segmentTree, arr);
		buildSegmentTree(2*idx + 2, mid + 1, r, segmentTree, arr);
		
		segmentTree[idx] = Math.min(segmentTree[2*idx + 1], segmentTree[2*idx + 2]);
	}

    int rangeMinQuery(int start, int end, int idx, int l, int r, int[] segmentTree){
	     // Case 1: Out of Bound
        if (l > end || r < start) {
            return Integer.MAX_VALUE;
        }

        // Case 2: Completely within the range
        if (l >= start && r <= end) {
            return segmentTree[idx];
        }

        // Case 3: Overlapping
        int mid = l + (r - l) / 2;
        return Math.min(rangeMinQuery(start, end, 2 * idx + 1, l, mid, segmentTree), 
                        rangeMinQuery(start, end, 2 * idx + 2, mid + 1, r, segmentTree));
	}

    List<Integer> queryMin(int n, int arr[], int q, int queries[]) {
		// code here
		int[] segmentTree = new int[4*n];
		buildSegmentTree(0, 0, n - 1, segmentTree, arr);
		
		List<Integer> ans = new ArrayList<>();
		
		for(int i = 0; i<queries.length; i+=2){
		    int start = queries[i] - 1;
		    int end = queries[i+1] - 1;
		    
		    ans.add(rangeMinQuery(start, end, 0, 0, n-1, segmentTree));
		}
		
		return ans;
		
	}

    public static void main(String[] args) {
        L6_RangeMinQuery obj = new L6_RangeMinQuery();
        int n = 5;
        int arr[] = {1, 2, 3, 4, 5};
        int q = 2;
        int queries[] = {1, 3, 2, 5};
        System.out.println(obj.queryMin(n, arr, q, queries));
    }
}
