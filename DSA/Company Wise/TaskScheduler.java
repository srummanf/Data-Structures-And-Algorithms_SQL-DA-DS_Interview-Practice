/** You are given an array of CPU tasks, each represented by letters A to Z, and a cooling time, n. Each cycle or interval allows the completion of one task. Tasks can be completed in any order, but there's a constraint: identical tasks must be separated by at least n intervals due to cooling time.

​Return the minimum number of intervals required to complete all tasks.

 

Example 1:

Input: tasks = ["A","A","A","B","B","B"], n = 2

Output: 8

Explanation: A possible sequence is: A -> B -> idle -> A -> B -> idle -> A -> B.

After completing task A, you must wait two cycles before doing A again. The same applies to task B. In the 3rd interval, neither A nor B can be done, so you idle. By the 4th cycle, you can do A again as 2 intervals have passed.

Example 2:

Input: tasks = ["A","C","A","B","D","B"], n = 1

Output: 6

Explanation: A possible sequence is: A -> B -> C -> D -> A -> B.

With a cooling interval of 1, you can repeat a task after just one other task.

Example 3:

Input: tasks = ["A","A","A", "B","B","B"], n = 3

Output: 10

Explanation: A possible sequence is: A -> B -> idle -> idle -> A -> B -> idle -> idle -> A -> B.

There are only two types of tasks, A and B, which need to be separated by 3 intervals. This leads to idling twice between repetitions of these tasks. */



// Whenever character freq is used -- Use array instead of HashMap

class Solution {
    public int leastInterval(char[] tasks, int p) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int[] freq = new int[26];

        int time = 0;
        for (char ch : tasks) {
            freq[ch - 'A']++;
        }

        for (int a : freq) {
            if (a > 0)
                pq.offer(a);
        }

        while (pq.isEmpty() == false) {
            ArrayList<Integer> temp = new ArrayList<>();
            int cycle = p + 1;
            int currtask = 0;
            while (cycle > 0 && pq.isEmpty() == false) {
                cycle--;
                int currfreq = pq.poll();
                if (currfreq > 1)
                    temp.add(currfreq - 1);
                currtask++;
            }
            temp.forEach(pq::offer);
            // for (int element : currtask) {
            //          pq.offer(element); }

            time += pq.isEmpty()? currtask : p+1;
        }

        return time;

    }
}


// ------------------------------------------------------------------------------------------------


class Solution {
    public int leastInterval(char[] tasks, int cooldown) {
        // Step 1: Count frequencies of each task
        int[] taskCounts = new int[26];
        int maxFrequency = 0;

        for (char task : tasks) {
            int index = task - 'A';
            taskCounts[index]++;
            maxFrequency = Math.max(maxFrequency, taskCounts[index]);
        }

        // Step 2: Count how many tasks have the maximum frequency
        int maxFrequencyTasks = 0;
        for (int count : taskCounts) {
            if (count == maxFrequency) {
                maxFrequencyTasks++;
            }
        }

        // Step 3: Calculate the minimum schedule length
        int minScheduleLength = Math.max(
            tasks.length, 
            (maxFrequency - 1) * (cooldown + 1) + maxFrequencyTasks
        );

        return minScheduleLength;
    } 
}
