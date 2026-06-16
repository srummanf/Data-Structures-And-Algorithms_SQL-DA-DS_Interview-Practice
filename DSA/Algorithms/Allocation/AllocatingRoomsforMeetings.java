/***
 * ## Allocating Rooms for Meetings: Detailed Explanation and Documentation

### Problem Statement

You are given an integer `n` representing the number of rooms numbered from `0` to `n-1`. You are also given a 2D integer array `meetings` where `meetings[i] = [starti, endi]` means that a meeting will be held during the half-closed time interval `[starti, endi)`. All the values of `starti` are unique.

Meetings are allocated to rooms in the following manner:
1. Each meeting will take place in the unused room with the lowest number.
2. If there are no available rooms, the meeting will be delayed until a room becomes free. The delayed meeting should have the same duration as the original meeting.
3. When a room becomes unused, meetings that have an earlier original start time should be given the room.

You need to return the number of the room that held the most meetings. If there are multiple rooms, return the room with the lowest number.

### Example

**Example 1:**
- Input: `n = 2, meetings = [[0,10],[1,5],[2,7],[3,4]]`
- Output: `0`
- Explanation:
  - At time 0, both rooms are not being used. The first meeting starts in room 0.
  - At time 1, only room 1 is not being used. The second meeting starts in room 1.
  - At time 2, both rooms are being used. The third meeting is delayed.
  - At time 3, both rooms are being used. The fourth meeting is delayed.
  - At time 5, the meeting in room 1 finishes. The third meeting starts in room 1 for the time period `[5,10)`.
  - At time 10, the meetings in both rooms finish. The fourth meeting starts in room 0 for the time period `[10,11)`.
  - Both rooms 0 and 1 held 2 meetings, so we return 0.

**Example 2:**
- Input: `n = 3, meetings = [[1,20],[2,10],[3,5],[4,9],[6,8]]`
- Output: `1`
- Explanation:
  - At time 1, all three rooms are not being used. The first meeting starts in room 0.
  - At time 2, rooms 1 and 2 are not being used. The second meeting starts in room 1.
  - At time 3, only room 2 is not being used. The third meeting starts in room 2.
  - At time 4, all three rooms are being used. The fourth meeting is delayed.
  - At time 5, the meeting in room 2 finishes. The fourth meeting starts in room 2 for the time period `[5,10)`.
  - At time 6, all three rooms are being used. The fifth meeting is delayed.
  - At time 10, the meetings in rooms 1 and 2 finish. The fifth meeting starts in room 1 for the time period `[10,12)`.
  - Room 0 held 1 meeting while rooms 1 and 2 each held 2 meetings, so we return 1.

### Approach

To solve the problem, we can use two priority queues:
1. **`busyRooms`**: This priority queue keeps track of rooms that are currently occupied. It is ordered by the end time of the meeting. If two rooms are free at the same time, the room with the lower number is prioritized.
2. **`idleRooms`**: This priority queue keeps track of rooms that are currently free, ordered by the room number.

#### Steps:
1. **Sort the meetings** based on their start times.
2. **Initialize the priority queues**:
   - `busyRooms` is used to manage the rooms that are currently in use.
   - `idleRooms` is used to manage the rooms that are currently free.
3. **Initialize the meeting count** array to keep track of the number of meetings held in each room.
4. **Process each meeting**:
   - Free up rooms in `busyRooms` that are no longer in use before the start of the current meeting.
   - If there are idle rooms available, assign the meeting to the room with the lowest number.
   - If there are no idle rooms, delay the meeting until the earliest room becomes free.
5. **Track the room usage**: Update the count for each room every time it is assigned a meeting.
6. **Find the room with the maximum number of meetings**: Iterate through the count array to find the room with the highest meeting count. In case of a tie, return the room with the lower number.

### Complexity
- **Time Complexity**: The main operations are sorting the meetings and managing the priority queues. The time complexity is:
  - Sorting the meetings: $$O(m \log m)$$, where `m` is the number of meetings.
  - Managing the priority queues: $$O(m \log n)$$, where `n` is the number of rooms.
  - Overall: $$O(m \log m + m \log n)$$
- **Space Complexity**: The space used by the priority queues and the count array is $$O(n)$$.

### Code
```java
import java.util.*;

class AllocatingRoomsforMeetings {

  public int mostBooked(int n, int[][] meetings) {
    Arrays.sort(meetings, (a, b) -> a[0] - b[0]);

    PriorityQueue<int[]> busyRooms = new PriorityQueue<>((a, b) ->
      a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]
    );

    PriorityQueue<Integer> idleRooms = new PriorityQueue<>();

    for (int i = 0; i < n; i++) {
      idleRooms.add(i);
    }

    int[] count = new int[n];

    for (int[] meeting : meetings) {
      int start = meeting[0];
      int end = meeting[1];

      while (!busyRooms.isEmpty() && start >= busyRooms.peek()[0]) {
        idleRooms.add(busyRooms.poll()[1]);
      }

      int roomID;

      if (!idleRooms.isEmpty()) {
        roomID = idleRooms.poll();
        busyRooms.add(new int[] { end, roomID });
      } else {
        int[] busyroom = busyRooms.poll();
        roomID = busyroom[1];

        busyRooms.add(new int[] { busyroom[0] + end - start, roomID });
      }

      count[roomID]++;
    }

    int mostBookedRoom = 0;

    for (int i = 0; i < n; i++) {
      if (count[mostBookedRoom] < count[i]) {
        mostBookedRoom = i;
      }
    }
    return mostBookedRoom;
  }
}
```

### Explanation of Code

1. **Sorting the Meetings**:
   - `Arrays.sort(meetings, (a, b) -> a[0] - b[0]);` sorts the meetings based on their start times.

2. **Initializing Priority Queues**:
   - `PriorityQueue<int[]> busyRooms = new PriorityQueue<>((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);` initializes the priority queue for busy rooms based on end time. If two rooms are free at the same time, the room with the lower number is prioritized.
   - `PriorityQueue<Integer> idleRooms = new PriorityQueue<>();` initializes the priority queue for idle rooms ordered by room number.

3. **Adding All Rooms to Idle Rooms**:
   - `for (int i = 0; i < n; i++) { idleRooms.add(i); }` adds all rooms (from `0` to `n-1`) to the `idleRooms` priority queue.

4. **Processing Each Meeting**:
   - For each meeting, we first free up rooms that are no longer in use (`while (!busyRooms.isEmpty() && start >= busyRooms.peek()[0]) { idleRooms.add(busyRooms.poll()[1]); }`).
   - If there are idle rooms available, assign the meeting to the room with the lowest number (`if (!idleRooms.isEmpty()) { roomID = idleRooms.poll(); busyRooms.add(new int[] { end, roomID }); }`).
   - If there are no idle rooms, delay the meeting until the earliest room becomes free (`else { int[] busyroom = busyRooms.poll(); roomID = busyroom[1]; busyRooms.add(new int[] { busyroom[0] + end - start, roomID }); }`).
   - Update the count of meetings for the assigned room (`count[roomID]++;`).

5. **Finding the Room with the Most Meetings**:
   - Iterate through the count array to find the room with the highest number of meetings (`for (int i = 0; i < n; i++) { if (count[mostBookedRoom] < count[i]) { mostBookedRoom = i; } }`).
   - Return the room with the most meetings (`return mostBookedRoom;`).

This solution effectively manages the allocation of rooms and handles delays by using priority queues to ensure that the room allocation is optimized and meets the problem's constraints.
 */
import java.util.Arrays;
import java.util.PriorityQueue;


class AllocatingRoomsforMeetings {

  public int mostBooked(int n, int[][] meetings) {
    Arrays.sort(meetings, (a, b) -> a[0] - b[0]);

    PriorityQueue<int[]> busyRooms = new PriorityQueue<>((a, b) ->
      a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]
    );

    PriorityQueue<Integer> idleRooms = new PriorityQueue<>();

    for (int i = 0; i < n; i++) {
      idleRooms.add(i);
    }

    int[] count = new int[n];

    for (int[] meeting : meetings) {
      int start = meeting[0];
      int end = meeting[1];

      while (!busyRooms.isEmpty() && start >= busyRooms.peek()[0]) {
        idleRooms.add(busyRooms.poll()[1]);
      }

      int roomID;

      if (!idleRooms.isEmpty()) {
        roomID = idleRooms.poll();
        busyRooms.add(new int[] { end, roomID });
      } else {
        int[] busyroom = busyRooms.poll();
        roomID = busyroom[1];

        busyRooms.add(new int[] { busyroom[0] + end - start, roomID });
      }

      count[roomID]++;
    }

    int mostBookedRoom = 0;

    for (int i = 0; i < n; i++) {
      if (count[mostBookedRoom] < count[i]) {
        mostBookedRoom = i;
      }
    }
    return mostBookedRoom;
  }
}
