// A great question on Resource Allocation and Priority Queue

import java.util.*;

// https://leetcode.com/problems/meeting-rooms-iii/
// https://leetcode.com/problems/meeting-rooms-iii/discuss/1067802/Java-Priority-Queue-Solution-Explained
// https://www.youtube.com/watch?v=3Q_oYDQ2whs

public class MeetingRoomsIII {
    public int mostBooked(int n, int[][] meetings) {
        // Sort all the meetings by their start time
        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);

        // Priority queue to keep track of busy rooms
        // Sort by end time; if end times are same, sort by room id
        PriorityQueue<int[]> busyRooms = new PriorityQueue<>(
                (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

        // Priority queue for idle rooms, sorted by room id
        PriorityQueue<Integer> idleRooms = new PriorityQueue<>();

        // Initialize all rooms as idle
        for (int i = 0; i < n; i++) {
            idleRooms.offer(i);
        }

        // Counter for the number of meetings each room has
        int[] count = new int[n];

        // Iterate over all meetings
        for (int[] meeting : meetings) {
            int start = meeting[0], end = meeting[1];

            // Free up rooms that have finished their meeting before the start of the
            // current meeting
            while (!busyRooms.isEmpty() && busyRooms.peek()[0] <= start) {
                idleRooms.offer(busyRooms.poll()[1]);
            }

            // Choose a room for the current meeting
            int roomId;
            if (!idleRooms.isEmpty()) {
                // If there is an idle room available, use the one with the smallest id
                roomId = idleRooms.poll();
                // Add the meeting to the busy queue with the new end time and the room id
                busyRooms.offer(new int[] { end, roomId });
            } else {
                // If no idle room is available, wait for the next room to be free
                int[] busyRoom = busyRooms.poll();
                roomId = busyRoom[1];
                // Schedule the meeting in this room, adjusting the meeting length accordingly
                busyRooms.offer(new int[] { busyRoom[0] + end - start, roomId });
            }

            // Increment the count of meetings for the chosen room
            count[roomId]++;
        }

        // Find the room with the maximum number of meetings booked
        int mostBookedRoom = 0;
        for (int i = 0; i < n; i++) {
            if (count[mostBookedRoom] < count[i]) {
                mostBookedRoom = i;
            }
        }

        // Return the room id with the highest booking count
        return mostBookedRoom;
    }

    public static void main(String[] args) {
        MeetingRoomsIII meetingRoomsIII = new MeetingRoomsIII();
        int[][] meetings = { { 1, 3 }, { 2, 4 }, { 3, 5 }, { 4, 6 }, { 5, 7 } };
        System.out.println(meetingRoomsIII.mostBooked(2, meetings));
    }
}
