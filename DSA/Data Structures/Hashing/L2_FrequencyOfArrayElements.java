import java.util.*;

public class L2_FrequencyOfArrayElements {
    void countFreq(int arr[]){
        HashMap<Integer, Integer> m = new HashMap<>();
        for(int x : arr){
            m.put(x, m.getOrDefault(x, 0) + 1);
        }
        // for(Map.Entry<Integer, Integer> e : m.entrySet()){
        //     System.out.println(e.getKey() + " " + e.getValue());
            
        // }
        for(int x : m.keySet()){
            System.out.println("Key: " + x + " - Frequency: " + m.get(x));
        }
    }
    public static void main(String args[]) {
        L2_FrequencyOfArrayElements f = new L2_FrequencyOfArrayElements();
        int arr[] = {15, 12, 13, 12, 13, 13, 18};
        f.countFreq(arr);
    }
}
