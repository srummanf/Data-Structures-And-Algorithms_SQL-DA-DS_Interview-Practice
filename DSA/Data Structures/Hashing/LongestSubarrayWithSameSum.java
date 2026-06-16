import java.util.HashMap;

public class LongestSubarrayWithSameSum {
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
        int arr1[] = { 3, 2, 8, 15, -8, -3 };
        int arr2[] = { 2, 9, 2, 5, -2, -13 };
        int temp[] = new int[arr1.length];
        for (int i = 0; i < arr2.length; i++) {
            temp[i] = arr2[i] - arr1[i];
        }
        LongestSubarrayWithSameSum l = new LongestSubarrayWithSameSum();
        System.out.println(l.maxLen(temp, 0));
    }
}
