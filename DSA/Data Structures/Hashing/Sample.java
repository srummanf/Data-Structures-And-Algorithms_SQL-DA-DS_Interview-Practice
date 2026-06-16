import java.util.*;

class Sample {
    public static void main(String args[]) {
        HashMap<String, Integer> m = new HashMap<String, Integer>(); //<key, val>
        m.put("a", 1);
        m.put("b", 2);
        System.out.println(m);
        System.out.println(m.size());
        System.out.println(m.get("a"));
        m.remove("b");
        System.out.println(m);
        for(Map.Entry<String, Integer> e : m.entrySet()) {
            System.out.println(e.getKey() + " " + e.getValue());
        }
        if(m.containsKey("a")) {
            System.out.println("a is present");
        }
        if(m.containsValue(1)) {
            System.out.println("a is present");
        }
    }
}
