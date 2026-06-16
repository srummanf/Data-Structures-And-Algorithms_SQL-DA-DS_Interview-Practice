import java.util.*;

public class Learn_PQ {

  public static void main(String[] args) {
    //Min Heap
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    /**
     * Max Heap
     PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
     */
    pq.offer(4);
    pq.offer(2);
    pq.offer(1);
    pq.offer(3);
    pq.offer(5);
    // pq.add(6) also works but in the developers world, usually offer is used in PQ.
    pq.remove(5);
    System.out.println(pq);
    System.out.println(pq.peek());
    System.out.println("Head of PQ: " + pq.peek());
    System.out.println("Head removed: " + pq.poll());
    System.out.println(pq);

    Iterator<Integer> itr = pq.iterator();
    while (itr.hasNext()) {
      System.out.println(itr.next());
    }
  }
}
