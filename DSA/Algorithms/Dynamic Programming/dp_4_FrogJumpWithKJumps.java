
class dp_4_FrogJumpWithKJumps {

    int recursion(int ind, int arr[], int k){
        if(ind == 0) return 0;
        if(ind <1 ) return Math.abs(arr[ind] - arr[0]);
        int min = Integer.MAX_VALUE;
        for(int j=1; j<=k; j++){
            if(ind-j >=0){
                int jump = recursion(ind-j, arr, k) + Math.abs(arr[ind] - arr[ind-j]);
                min = Math.min(min, jump);
            }
        }
        return min;
    }

    int topDownMemo(int ind, int arr[], int k, int dp[]){

        if(dp[ind] != -1) return dp[ind];

        if(ind == 0) return 0;
        if(ind <1 ) return Math.abs(arr[ind] - arr[0]);
        
        int min = Integer.MAX_VALUE;
        for(int j=1; j<=k; j++){
            if(ind-j >=0){
                int jump = topDownMemo(ind-j, arr, k, dp) + Math.abs(arr[ind] - arr[ind-j]);
                min = Math.min(min, jump);
            }
        }
        return dp[ind] = min;
    }

    int bottomUpTabu(int arr[], int k){
        int dp[] = new int[arr.length];
        dp[0] = 0;
        
        for(int i=1; i<arr.length; i++){
            int min = Integer.MAX_VALUE;
            for(int j=1; j<=k; j++){
                if(i-j >=0){
                    int jump = dp[i-j] + Math.abs(arr[i] - arr[i-j]);
                    min = Math.min(min, jump);
                }
            }
            dp[i] = min;
        }
        return dp[arr.length-1];
    }

    public static void main(String[] args) {
        int arr[] = {10, 20, 30, 10};
        int k = 2;
        dp_4_FrogJumpWithKJumps f = new dp_4_FrogJumpWithKJumps();
        int dp[] = new int[arr.length];
        for(int i=0; i<dp.length; i++) dp[i] = -1;
        System.out.println(f.recursion(arr.length-1, arr, k));
        System.out.println(f.topDownMemo(arr.length-1, arr, k, dp));
        System.out.println(f.bottomUpTabu(arr, k));
    }
}
