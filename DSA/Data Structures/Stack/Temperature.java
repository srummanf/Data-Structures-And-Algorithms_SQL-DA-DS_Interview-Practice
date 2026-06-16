// 739. Daily Temperatures
// Solved
// Medium
// Topics
// Companies
// Hint
// Given an array of integers temperatures represents the daily temperatures, return an array answer such that answer[i] is the number of days you have to wait after the ith day to get a warmer temperature. If there is no future day for which this is possible, keep answer[i] == 0 instead.


import java.util.ArrayDeque;
import java.util.Deque;

public class Temperature {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        Deque<Integer> st = new ArrayDeque<>();
        int[] result = new int[temperatures.length];

        for(int i=n-1; i>=0; i--){
            while(!st.isEmpty() && temperatures[i]>=temperatures[st.peekFirst()]){
                st.pollFirst();
            }

            if(st.isEmpty()){
                result[i] = 0;
            } else {
                result[i] = st.peekFirst() - i;
            }

            st.offerFirst(i);
        }
        
        return result;
    }
    public static void main(String[] args) {
        Temperature temp = new Temperature();
        int[] temperatures = {73,74,75,71,69,72,76,73};
        int[] result = temp.dailyTemperatures(temperatures);
        for(int i=0; i<result.length; i++){
            System.out.print(result[i] + " ");
        }
    }
}
