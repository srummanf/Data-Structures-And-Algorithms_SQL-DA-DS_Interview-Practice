import java.util.*;
class BestTimeToBuySellStocks {
    public int maxProfit_bruteforce(int[] prices) {
        int mini = Integer.MAX_VALUE;
        int n = prices.length;
        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                int val=prices[i]-prices[j];
                mini = Math.min(mini,val);
            }
        }
        int ans = -mini;
        if(ans<0) return 0;
        return ans;
    }
    public int maxProfit_twoptr_slidingwindow(int[] prices) {
        int l=0, r=1;
        int maxi=0;
        while(r<=prices.length-1){
            if(prices[l]<prices[r]){
                maxi=Math.max(maxi,(prices[r]-prices[l]));
            }
            else {
                l=r;
            }
            r++;
        }
        return maxi;
    }
    public static void main(String[] args) {
        int prices[] = {7,1,5,3,6,4};
        BestTimeToBuySellStocks obj = new BestTimeToBuySellStocks();
        System.out.println(obj.maxProfit_bruteforce(prices));
        System.out.println(obj.maxProfit_twoptr_slidingwindow(prices)); 
    }
}