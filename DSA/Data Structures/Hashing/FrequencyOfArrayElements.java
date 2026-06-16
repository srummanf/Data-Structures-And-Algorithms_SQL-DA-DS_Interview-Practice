import java.util.*;

public class FrequencyOfArrayElements {
    void countFreq(int arr[]){
        HashMap<Integer, Integer> m = new HashMap<>();
        for(int x : arr){
            m.put(x, m.getOrDefault(x, 0) + 1);
        }
        for(Map.Entry<Integer, Integer> e : m.entrySet()){
            System.out.println(e.getKey() + " " + e.getValue());
            
        }
    }
    public static void main(String args[]) {
        FrequencyOfArrayElements f = new FrequencyOfArrayElements();
        int arr[] = {15, 12, 13, 12, 13, 13, 18};
        f.countFreq(arr);
    }
}
