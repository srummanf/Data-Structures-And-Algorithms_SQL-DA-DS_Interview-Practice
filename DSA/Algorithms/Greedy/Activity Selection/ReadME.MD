### Activity Selection Problem

The Activity Selection Problem is a classic problem in computer science and operations research that involves selecting the maximum number of activities that can be performed by a single person or machine, assuming that only one activity can be done at a time.

#### Problem Description

Given a set of activities with their start and end times, the task is to select the maximum number of activities that don't overlap. Each activity has a start time (`s[i]`) and a finish time (`f[i]`), where `0 ≤ i < n` and `n` is the number of activities.

#### Greedy Algorithm Approach

The most efficient way to solve this problem is by using a greedy algorithm. The idea is to always select the next activity that finishes the earliest and is compatible with the previously selected activities.

**Steps to Solve the Problem:**

1. **Sort Activities by Finish Time**: Sort the activities in increasing order of their finish time.
2. **Select the First Activity**: Always select the first activity since it finishes the earliest.
3. **Iterate and Select Further Activities**: For each subsequent activity, if its start time is greater than or equal to the finish time of the last selected activity, select it.
4. **Repeat** until all activities are considered.

#### Pseudocode

```pseudo
Sort the activities based on their finish time

Let A be the array of activities
Let n be the total number of activities
Let result be an array to store the selected activities

result.append(A[0])  // Select the first activity

for i from 1 to n-1 do:
    if A[i].start_time >= result.last().finish_time:
        result.append(A[i])  // Select this activity

return result
```

#### Time Complexity

- **Sorting**: The time complexity of sorting the activities is `O(n log n)`.
- **Selection**: The time complexity of iterating through the activities is `O(n)`.

Thus, the overall time complexity is `O(n log n)`.

### Example

Let's consider an example:

**Input**:

- Number of activities = 6
- Activities (start time, finish time): `[(1, 3), (2, 4), (3, 5), (0, 6), (5, 7), (8, 9)]`

**Step 1**: Sort the activities by their finish time:

- Sorted activities: `[(1, 3), (2, 4), (3, 5), (0, 6), (5, 7), (8, 9)]`

**Step 2**: Select the first activity `[(1, 3)]`.

**Step 3**: Iterate through the list:

- Skip `(2, 4)` as it overlaps with `(1, 3)`.
- Select `(3, 5)` as it does not overlap with `(1, 3)`.
- Skip `(0, 6)` as it overlaps with `(3, 5)`.
- Select `(5, 7)` as it does not overlap with `(3, 5)`.
- Select `(8, 9)` as it does not overlap with `(5, 7)`.

**Output**: The selected activities are `[(1, 3), (3, 5), (5, 7), (8, 9)]`.

### Implementation in Java

```java
import java.util.Arrays;

class Activity {
    int start;
    int finish;

    Activity(int start, int finish) {
        this.start = start;
        this

```java
        this.finish = finish;
    }
}

class Solution {
    public static List<Activity> selectActivities(Activity[] activities) {
        // Sort activities based on finish time
        Arrays.sort(activities, (a, b) -> Integer.compare(a.finish, b.finish));
      
        List<Activity> selectedActivities = new ArrayList<>();
        selectedActivities.add(activities[0]); // Select the first activity

        int lastSelectedIndex = 0;

        for (int i = 1; i < activities.length; i++) {
            if (activities[i].start >= activities[lastSelectedIndex].finish) {
                selectedActivities.add(activities[i]);
                lastSelectedIndex = i;
            }
        }
        return selectedActivities;
    }

    public static void main(String[] args) {
        Activity[] activities = {
            new Activity(1, 3),
            new Activity(2, 4),
            new Activity(3, 5),
            new Activity(0, 6),
            new Activity(5, 7),
            new Activity(8, 9)
        };

        List<Activity> selected = selectActivities(activities);
        for (Activity activity : selected) {
            System.out.println("Activity: Start = " + activity.start + ", Finish = " + activity.finish);
        }
    }
}
```

### Example Output

```
Activity: Start = 1, Finish = 3
Activity: Start = 3, Finish = 5
Activity: Start = 5, Finish = 7
Activity: Start = 8, Finish = 9
```

### LeetCode Problems Related to Activity Selection

Here are some problems on LeetCode that are related to the Activity Selection Problem or involve similar greedy approaches:

1. **[435. Non-overlapping Intervals](https://leetcode.com/problems/non-overlapping-intervals/)**

   - **Description**: Given a collection of intervals, find the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.
   - **Concept**: The problem is similar to the Activity Selection Problem where you need to select the maximum number of non-overlapping intervals, and the answer is derived by subtracting this number from the total number of intervals.
2. **[452. Minimum Number of Arrows to Burst Balloons](https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/)**

   - **Description**: Given a series of balloons represented by intervals, determine the minimum number of arrows required to burst all the balloons.
   - **Concept**: This is a variant of the interval selection problem where the goal is to minimize the number of selections (arrows) to cover all intervals (balloons).
3. **[1024. Video Stitching](https://leetcode.com/problems/video-stitching/)**

   - **Description**: You have an array of video clips represented by intervals. Find the minimum number of clips needed to cover a certain interval `[0, T]`.
   - **Concept**: This problem involves selecting intervals to cover a given range, which is closely related to the greedy approach in activity selection.
4. **[763. Partition Labels](https://leetcode.com/problems/partition-labels/)**

   - **Description**: You are given a string and need to partition it into as many parts as possible such that no letter appears in more than one part.
   - **Concept**: The problem can be solved using a greedy approach similar to activity selection by determining the farthest point each letter can reach.
5. **[56. Merge Intervals](https://leetcode.com/problems/merge-intervals/)**

   - **Description**: Given a collection of intervals, merge all overlapping intervals.
   - **Concept**: Though this problem focuses on merging rather than selecting intervals, understanding interval overlaps is key, making it related to the activity selection strategy.
6. **[986. Interval List Intersections](https://leetcode.com/problems/interval-list-intersections/)**

   - **Description**: Given two lists of closed intervals, find their intersections.
   - **Concept**: The problem involves finding common intervals, which relates to the idea of handling interval overlaps as seen in the Activity Selection Problem.

### Summary

The Activity Selection Problem is a fundamental problem that can be efficiently solved using a greedy algorithm by selecting activities based on their finish times. Understanding this problem is essential for tackling a variety of interval-related questions on LeetCode. By mastering this approach, you'll be better equipped to solve similar problems involving interval management and optimization.



### Activity Selection Problem: A Detailed Overview

#### 1. Introduction

The Activity Selection Problem is a classic optimization problem that involves selecting the maximum number of activities that don't overlap, given a set of activities with specified start and end times. This problem is a typical example of a greedy algorithm, where the solution is built piece by piece, choosing the next piece with the most immediate benefit.

#### 2. Problem Statement

Given `n` activities with their start and end times, select the maximum number of activities that can be performed by a single person or resource, assuming that a person can only work on a single activity at a time.

#### 3. Key Concepts

- **Greedy Algorithm**: The activity selection problem is solved using a greedy approach. The idea is to always select the activity that finishes the earliest and is compatible with the previously selected activities.
- **Sorting**: The activities are sorted based on their finish times. This is crucial because it allows the greedy choice to be made efficiently.

#### 4. Steps to Solve the Problem

1. **Sort Activities**: Start by sorting the activities based on their finish times in ascending order. This ensures that we can always pick the activity that leaves the most room for subsequent activities.
2. **Select the First Activity**: The first activity is always selected because after sorting by finish time, it is the one that finishes the earliest.
3. **Iterate Over Remaining Activities**: For each subsequent activity, check if its start time is greater than or equal to the finish time of the previously selected activity. If it is, select this activity.
4. **Repeat**: Continue this process until all activities have been considered.

#### 5. Pseudocode

```plaintext
1. Sort the activities by their finish times.
2. Select the first activity and add it to the result set.
3. For each remaining activity, do:
    a. If the start time of the current activity is greater than or equal to the finish time of the last selected activity:
        i. Select this activity.
        ii. Update the last selected activity's finish time.
4. Return the list of selected activities.
```
