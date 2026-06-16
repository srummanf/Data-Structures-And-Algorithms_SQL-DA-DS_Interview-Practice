//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class NMeetingsInOneRoom {

  //Function to find the maximum number of meetings that can
  //be performed in a meeting room.
  public static int maxMeetings(int[] start, int[] end, int n) {
    // List to store the meeting times
    List<int[]> meetings = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      meetings.add(new int[] { start[i], end[i] });
    }

    // Sort meetings by their end time
    Collections.sort(meetings, Comparator.comparingInt(a -> a[1]));

    // The end time of the last selected meeting
    int lastEndTime = -1;
    int count = 0;

    // Iterate through sorted meetings
    for (int[] meeting : meetings) {
      int meetingStart = meeting[0];
      int meetingEnd = meeting[1];

      if (meetingStart > lastEndTime) {
        // If the meeting starts after the last end time, we can select it
        count++;
        lastEndTime = meetingEnd;
      }
    }

    return count;
  }
}
