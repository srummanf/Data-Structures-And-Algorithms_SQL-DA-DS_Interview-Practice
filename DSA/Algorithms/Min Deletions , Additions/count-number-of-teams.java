class Solution {
    // Function to build the segment tree
    void buildSegmentTree(int i, int l, int r, int[] segmentTree, int[] arr) {
        if (l == r) {
            segmentTree[i] = arr[l];
            return;
        }
        int mid = l + (r - l) / 2;
        buildSegmentTree(2 * i + 1, l, mid, segmentTree, arr);
        buildSegmentTree(2 * i + 2, mid + 1, r, segmentTree, arr);
        segmentTree[i] = segmentTree[2 * i + 1] + segmentTree[2 * i + 2];
    }

    // Function to update the segment tree
    void updateSegmentTree(int idx, int val, int i, int l, int r, int[] segmentTree, int[] arr) {
        if (l == r) {
            segmentTree[i] = val;
            arr[idx] = val;
            return;
        }

        int mid = l + (r - l) / 2;

        if (idx <= mid) {
            updateSegmentTree(idx, val, 2 * i + 1, l, mid, segmentTree, arr);
        } else {
            updateSegmentTree(idx, val, 2 * i + 2, mid + 1, r, segmentTree, arr);
        }

        segmentTree[i] = segmentTree[2 * i + 1] + segmentTree[2 * i + 2];
    }

    // Function to query the segment tree
    int querySegmentTree(int start, int end, int i, int l, int r, int[] segmentTree) {
        if (l > end || r < start) {
            return 0;
        }

        if (l >= start && r <= end) {
            return segmentTree[i];
        }

        int mid = l + (r - l) / 2;
        return querySegmentTree(start, end, 2 * i + 1, l, mid, segmentTree) +
               querySegmentTree(start, end, 2 * i + 2, mid + 1, r, segmentTree);
    }

    public int numTeams(int[] rating) {
        int n = rating.length;
        int[] lessLeft = new int[n];
        int[] greaterLeft = new int[n];
        int[] lessRight = new int[n];
        int[] greaterRight = new int[n];
        int[] segmentTree = new int[4 * 100001]; // Since rating values can be up to 100000
        int[] arr = new int[100001];
        int count = 0;

        // Count elements less and greater on the left side
        for (int i = 0; i < n; i++) {
            lessLeft[i] = querySegmentTree(0, rating[i] - 1, 0, 0, 100000, segmentTree);
            greaterLeft[i] = querySegmentTree(rating[i] + 1, 100000, 0, 0, 100000, segmentTree);
            updateSegmentTree(rating[i], arr[rating[i]] + 1, 0, 0, 100000, segmentTree, arr);
        }

        // Reset the segment tree
        segmentTree = new int[4 * 100001];
        arr = new int[100001];

        // Count elements less and greater on the right side
        for (int i = n - 1; i >= 0; i--) {
            lessRight[i] = querySegmentTree(0, rating[i] - 1, 0, 0, 100000, segmentTree);
            greaterRight[i] = querySegmentTree(rating[i] + 1, 100000, 0, 0, 100000, segmentTree);
            updateSegmentTree(rating[i], arr[rating[i]] + 1, 0, 0, 100000, segmentTree, arr);
        }

        // Calculate the number of valid teams
        for (int i = 0; i < n; i++) {
            count += lessLeft[i] * greaterRight[i] + greaterLeft[i] * lessRight[i];
        }

        return count;
    }
}

// class Solution {
//     public int numTeams(int[] rating) {
//         int n = rating.length;
//         int count = 0;

//         for (int j = 1; j < n - 1; j++) {
//             int lessLeft = 0, greaterLeft = 0;
//             int lessRight = 0, greaterRight = 0;

//             for (int i = 0; i < j; i++) {
//                 if (rating[i] < rating[j]) lessLeft++;
//                 if (rating[i] > rating[j]) greaterLeft++;
//             }

//             for (int k = j + 1; k < n; k++) {
//                 if (rating[k] < rating[j]) lessRight++;
//                 if (rating[k] > rating[j]) greaterRight++;
//             }

//             count += lessLeft * greaterRight + greaterLeft * lessRight;
//         }

//         return count;
//     }
// }


// class Solution {
//     public int numTeams(int[] rating) {
//         int n = rating.length;
//         int count = 0;

//         for (int i = 0; i < n; i++) {
//             for (int j = i + 1; j < n; j++) {
//                 for (int k = j + 1; k < n; k++) {
//                     if ((rating[i] < rating[j] && rating[j] < rating[k]) || 
//                         (rating[i] > rating[j] && rating[j] > rating[k])) {
//                         count++;
//                     }
//                 }
//             }
//         }

//         return count;
//     }
// }



// class Solution {
//     int f(int i, int j, int[] arr, int k) {
//         if (i == 1) {
//             if (arr[i] > arr[0])
//                 return 1;
//         }
//         if (j == 1) {
//             if (arr[j] > arr[0])
//                 return 01;
//         }
//         if (i == 0 || j == 0)
//             return 0;
       
//         int nottake = f(i - 1, j, arr, k) + f(i, j - 1, arr, k);
//         int take = 0;
//         if (arr[i] > arr[j] && k==3)
//             take = f(i - 1, j, arr, k + 1) + f(i, j - 1, arr, k + 1);

//         return take+nottake;
//     }

//     public int numTeams(int[] arr) {
//         return f(arr.length-1,arr.length-2,arr, 0);
//     }
// }