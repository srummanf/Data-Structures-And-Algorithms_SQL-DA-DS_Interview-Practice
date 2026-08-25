class Solution {

    public boolean isOdd(int n) {
        return n % 2 == 1 ? true : false;
    }

    public boolean isEven(int n) {
        return n % 2 == 0 ? true : false;
    }

    public int singleNonDuplicate(int[] nums) {

        if (nums.length == 1)
            return nums[0];

        if (nums[0] != nums[1])
            return nums[0];
        if (nums[nums.length - 1] != nums[nums.length - 2])
            return nums[nums.length - 1];

        int l = 1;
        int r = nums.length - 2;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] != nums[mid - 1] && nums[mid] != nums[mid + 1])
                return nums[mid];

            // left elimination
            if ((isOdd(mid) && nums[mid] == nums[mid - 1]) || (isEven(mid) && nums[mid] == nums[mid + 1]))
                l = mid + 1;
            else
                r = mid - 1;

        }

        return -1;

    }
}