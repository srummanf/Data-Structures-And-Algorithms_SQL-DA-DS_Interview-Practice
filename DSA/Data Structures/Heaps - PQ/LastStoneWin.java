
/**
 * You are given an array of integers stones where stones[i] is the weight of the ith stone.

We are playing a game with the stones. On each turn, we choose the heaviest two stones and smash them together. Suppose the heaviest two stones have weights x and y with x <= y. The result of this smash is:

If x == y, both stones are destroyed, and
If x != y, the stone of weight x is destroyed, and the stone of weight y has new weight y - x.
At the end of the game, there is at most one stone left.

Return the weight of the last remaining stone. If there are no stones left, return 0.
 */

import java.util.*;

public class LastStoneWin {

  public int lastStoneWeight(int[] stones) {
    // for max heap
    PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
    for (int i : stones) {
      pq.add(i);
    }
    while(pq.size() > 1){
        int a =  pq.poll();
        int b =  pq.poll();{
            if( a != b){
                a = a-b;
                pq.add(a);
            }
        }
    }
    return pq.size()==0?0:pq.poll();
    
  }
  public static void main(String[] args) {
    int stones[] = {2,7,4,1,8,1};
    LastStoneWin ob = new LastStoneWin();
    System.out.println(ob.lastStoneWeight(stones));
  }
}
