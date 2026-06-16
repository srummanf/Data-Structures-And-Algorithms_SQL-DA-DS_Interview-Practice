import java.util.*;

class LongestSubarrayWithGivenSum {
    int maxLen(int arr[], int sum){
        int maxlen=0, presum=0;
        HashMap<Integer, Integer> m = new HashMap<>();
        for(int i=0; i < arr.length; i++){
            presum += arr[i];
            if(presum == sum) {
                maxlen = i + 1;
            }
            if(m.containsKey(presum)==false){
                m.put(presum, i);
            }
            if(m.containsKey(presum-sum)){
                maxlen = Math.max(maxlen, i-m.get(presum-sum));
            }
        }
        return maxlen;
    }
    public static void main(String[] args) {
        int arr[] = { 3, 2, 8, 15, -8, -3 };
        int sum = 17;
        LongestSubarrayWithGivenSum l = new LongestSubarrayWithGivenSum();
        System.out.println(l.maxLen(arr, sum));
    }
}
