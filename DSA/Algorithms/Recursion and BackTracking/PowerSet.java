import java.util.*;

class PowerSet {

    ArrayList<String> powerSetList = new ArrayList<>(); // Create an ArrayList to store the power set

    void generatePowerSet(String str, int index, String current) {
        int n = str.length();

        // If we've reached the end of the input string, add the current subset to the
        // list
        if (index == n) {
            powerSetList.add(current);
            return;
        }

        // Include the current character in the subset and recurse
        generatePowerSet(str, index + 1, current + str.charAt(index));

        // Exclude the current character from the subset and recurse
        generatePowerSet(str, index + 1, current);
    }

    public static void main(String args[]) {
        PowerSet obj = new PowerSet();
        String str = "abc";

        // Start generating the power set from an empty string and index 0
        obj.generatePowerSet(str, 0, "");

        // Now, obj.powerSetList contains the power set of the string "abc"
        // You can access the subsets using obj.powerSetList
        for (String subset : obj.powerSetList) {
            System.out.println(subset);
        }
    }
}

