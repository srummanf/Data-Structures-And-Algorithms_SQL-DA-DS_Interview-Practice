/**
 * Design a system that manages the reservation state of n seats that are numbered from 1 to n.

Implement the SeatManager class:

SeatManager(int n) Initializes a SeatManager object that will manage n seats numbered from 1 to n. All seats are initially available.
int reserve() Fetches the smallest-numbered unreserved seat, reserves it, and returns its number.
void unreserve(int seatNumber) Unreserves the seat with the given seatNumber.
 

Example 1:

Input
["SeatManager", "reserve", "reserve", "unreserve", "reserve", "reserve", "reserve", "reserve", "unreserve"]
[[5], [], [], [2], [], [], [], [], [5]]
Output
[null, 1, 2, null, 2, 3, 4, 5, null]
 */
import java.util.*;

class SeatReservation {

  PriorityQueue<Integer> minHeap = new PriorityQueue<>();
  int sm;

  public SeatReservation(int n) {
    sm = 1;
  }

  public int reserve() {
    if (!minHeap.isEmpty()) {
      int seat = minHeap.poll();
      return seat;
    }
    int seat = sm;
    sm++;
    return seat;
  }

  public void unreserve(int seatNumber) {
    minHeap.add(seatNumber);
  }

  public static void main(String[] args) {
    SeatReservation obj = new SeatReservation(5);
    int param_1 = obj.reserve();
    System.out.println(param_1);

    int param_2 = obj.reserve();
    System.out.println(param_2);

    obj.unreserve(2);

    int param_3 = obj.reserve();
    System.out.println(param_3);

    int param_4 = obj.reserve();
    System.out.println(param_4);

    int param_5 = obj.reserve();
    System.out.println(param_5);

    int param_6 = obj.reserve();
    System.out.println(param_6);

    obj.unreserve(5);

    int param_7 = obj.reserve();
    System.out.println(param_7);
    System.out.println("-------------------");

    while (!obj.minHeap.isEmpty()) {
      int element = obj.minHeap.poll();
      System.out.println("Dequeued: " + element);
    }
  }
}
