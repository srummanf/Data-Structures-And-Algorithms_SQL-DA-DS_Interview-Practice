// Day 4

// https://leetcode.com/problems/find-the-duplicate-number/

class DuplicateNumber {
    public int findDuplicate(int[] nums) {

        // Cycle Linked List Method + Turtoise method
        int slow = nums[0];
        int fast = nums[0];
        do{
            slow = nums[slow];
            fast = nums[nums[fast]];
        }while(slow!=fast);

        fast=nums[0];
        while(slow!=fast){
            slow=nums[slow];
            fast=nums[fast];
        }
        return slow;
    }
}