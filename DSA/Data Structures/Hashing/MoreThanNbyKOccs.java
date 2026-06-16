import java.util.*;


public class MoreThanNbyKOccs {

  void printNbyK(int arr[], int k) {
    HashMap<Integer, Integer> m = new HashMap<>();

    for(int x : arr){
        m.put(x, m.getOrDefault(x, 0) + 1);
    }

    for(Map.Entry<Integer, Integer> e : m.entrySet()){
        if(e.getValue() > arr.length / k){
            System.out.println(e.getKey());
        }
    }
  }
  
}

f