import java.util.*;

class LongestSubarrayWithGivenSumWithequalNoOf {
    int maxLen(int arr[], int sum) {
        int maxlen = 0, presum = 0;
        HashMap<Integer, Integer> m = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            presum += arr[i];
            if (presum == sum) {
                maxlen = i + 1;
            }
            if (m.containsKey(presum) == false) {
                m.put(presum, i);
            }
            if (m.containsKey(presum - sum)) {
                maxlen = Math.max(maxlen, i - m.get(presum - sum));
            }
        }
        return maxlen;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 0, 1, 1, 1, 0, 0 };
        for (int i=0;i<arr.length;i++) {
            if (arr[i] == 0) {
                arr[i] = -1;
            }
        }
        LongestSubarrayWithGivenSumWithequalNoOf l = new LongestSubarrayWithGivenSumWithequalNoOf();
        System.out.println(l.maxLen(arr, 0));
    }
}
