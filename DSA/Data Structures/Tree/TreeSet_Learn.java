// Like PriorityQueue, TreeSet is also a collection class that stores elements in a sorted order.

import java.util.*;

public class TreeSet_Learn {
    public static void main(String[] args) {
        TreeSet<Integer> tset = new TreeSet<Integer>();
        // helps us to store element in sorted order when we add elements to it
        tset.add(1);
        tset.add(4);
        tset.add(3);
        tset.add(8);
        tset.add(2);
        tset.add(5);
        tset.add(6);
        tset.add(7);
        tset.add(9);
        System.out.println(tset);
        System.out.println(tset.remove(3));
        System.out.println(tset);
        //returns the first and last element
        System.out.println(tset.first());
        System.out.println(tset.last());
        //HeadSet returns the elements which are less than the specified element
        //TailSet returns the elements which are greater than the specified element
        //SubSet returns the elements which are in between the specified elements
        System.out.println("Chava Headset" + tset.headSet(2));
        System.out.println("Chava Tailset" + tset.tailSet(55));
        System.out.println("Chava Subset" + tset.subSet(1,5));
        //Iterating through the TreeSet
        Iterator<Integer> it = tset.iterator();

        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
