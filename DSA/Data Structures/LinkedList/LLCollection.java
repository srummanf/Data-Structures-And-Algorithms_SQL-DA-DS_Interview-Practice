
import java.util.Collection;
import java.util.LinkedList;
import java.util.*;

public class LLCollection {
    public static void main(String[] args) {

        LinkedList ll = new LinkedList();
        LinkedList<Integer> ll2 = new LinkedList<>();
        ll.addFirst(1);
        ll.addFirst("Rumman");
        ll.addLast(2);
        ll2.addLast(2);
        ll2.addLast(22);
        ll2.addLast(12);
        ll2.addLast(5);
        ll2.addLast(2);

        System.out.println(ll);
        System.out.println(ll.getFirst());
        System.out.println(ll.getLast());
        System.out.println(ll.peek());
        System.out.println("---" + ll.get(0));

        Collections.sort(ll2);
        System.out.println(ll2);
    }

}
