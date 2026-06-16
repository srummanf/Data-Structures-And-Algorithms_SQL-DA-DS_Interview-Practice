/** 
 * Problem Statement
Given the logs of users in the form of a 2D array with each log containing username, login date, and login time. The same user may have multiple login times on the same date. Your task is to find the number of logins on a date by a user and present the results in the form of a 2D array. Each array should contain the username, login date, and login count. The usernames should be sorted in lexical order, and for each user, the dates should appear in chronological order. Some entries may have invalid dates and times (like hour greater than 24 or 29 February in a non-leap year). Such entries should be filtered out.

Sample Input

String[][] logs = {
    {"alice", "2023-02-28", "10:30"},
    {"bob", "2023-03-01", "09:00"},
    {"alice", "2023-02-28", "12:00"},
    {"alice", "2023-02-30", "08:00"},  // Invalid date
    {"alice", "2023-02-28", "25:00"},  // Invalid time
    {"bob", "2023-03-01", "15:00"},
    {"carol", "2023-02-29", "14:00"},  // Invalid date (non-leap year)
    {"bob", "2023-03-02", "07:00"},
    {"carol", "2023-03-01", "08:00"},
    {"carol", "2023-03-01", "09:00"},
};


Sample Output

String[][] result = {
    {"alice", "2023-02-28", "2"},
    {"bob", "2023-03-01", "2"},
    {"bob", "2023-03-02", "1"},
    {"carol", "2023-03-01", "2"}
};

Explanation
1. For the user "alice", the entry with date "2023-02-30" is invalid and is filtered out. The entry with time "25:00" is invalid and is filtered out. The valid entries are two logins on "2023-02-28".
2. For the user "bob", there are two logins on "2023-03-01" and one login on "2023-03-02".
3. For the user "carol", the entry with date "2023-02-29" is invalid and is filtered out. There are two valid logins on "2023-03-01".

The final output contains the usernames in lexical order, and for each user, the dates are sorted in chronological order along with the count of logins on each date.
 */

import java.util.*;

class LogSchedule {

    public static boolean isLeapYear(int year) {
        return ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0));
    }

    public static boolean isDay(int day, int month, int year) {
        int[] daysInMonth = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        if (isLeapYear(year)) daysInMonth[2] = 29;
        return 1 <= day && day <= daysInMonth[month];
    }

    public static boolean isCorrectDate(String date) {
        String[] parts = date.split("-");
        int year = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]);
        int day = Integer.parseInt(parts[2]);
        if (month < 1 || month > 12) return false;
        return isDay(day, month, year);
    }

    public static boolean isCorrectTime(String time) {
        String[] parts = time.split(":");
        int hours = Integer.parseInt(parts[0]);
        int mins = Integer.parseInt(parts[1]);
        if (hours < 0 || hours >= 24) return false;
        if (mins < 0 || mins >= 60) return false;
        return true;
    }

    public static String[][] logCount(String[][] logs) {
        Map<String, Map<String, Integer>> userLogs = new TreeMap<>();

        for (String[] log : logs) {
            String user = log[0];
            String date = log[1];
            String time = log[2];

            if (!isCorrectDate(date) || !isCorrectTime(time)) {
                continue;
            }

            userLogs.putIfAbsent(user, new TreeMap<>());
            Map<String, Integer> dateLogs = userLogs.get(user);
            dateLogs.put(date, dateLogs.getOrDefault(date, 0) + 1);
        }

        List<String[]> result = new ArrayList<>();
        for (Map.Entry<String, Map<String, Integer>> userEntry : userLogs.entrySet()) {
            String user = userEntry.getKey();
            Map<String, Integer> dateLogs = userEntry.getValue();
            for (Map.Entry<String, Integer> dateEntry : dateLogs.entrySet()) {
                String date = dateEntry.getKey();
                int count = dateEntry.getValue();
                result.add(new String[] { user, date, String.valueOf(count) });
            }
        }

        return result.toArray(new String[0][]);
    }

    public static void main(String[] args) {
        String[][] logs = {
            {"alice", "2023-02-28", "10:30"},
            {"bob", "2023-03-01", "09:00"},
            {"alice", "2023-02-28", "12:00"},
            {"alice", "2023-02-30", "08:00"},  // Invalid date
            {"alice", "2023-02-28", "25:00"},  // Invalid time
            {"bob", "2023-03-01", "15:00"},
            {"carol", "2023-02-29", "14:00"},  // Invalid date (non-leap year)
            {"bob", "2023-03-02", "07:00"},
            {"carol", "2023-03-01", "08:00"},
            {"carol", "2023-03-01", "09:00"},
        };

        String[][] result = logCount(logs);

        for (String[] entry : result) {
            System.out.println(Arrays.toString(entry));
        }
    }
}
