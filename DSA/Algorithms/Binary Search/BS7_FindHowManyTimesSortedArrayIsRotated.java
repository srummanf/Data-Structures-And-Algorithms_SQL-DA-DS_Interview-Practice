
class BS7_FindHowManyTimesSortedArrayIsRotated {

    public int findMin(int[] nums) {

        int l = 0;
        int r = nums.length - 1;

        while (l < r) {

            int mid = l + (r - l) / 2;

            if (nums[mid] > nums[r]) {
                // Minimum is on the right
                l = mid + 1;
            } else // Minimum is at mid or on the left
            {
                r = mid;
            }
        }

        return l;
    }

    public static void main(String[] args) {
        BS7_FindHowManyTimesSortedArrayIsRotated obj = new BS7_FindHowManyTimesSortedArrayIsRotated();
        int[] nums = {3, 4, 5, 1, 2};
        System.out.println("Number of times the sorted array is rotated : " + obj.findMin(nums));
    }

}
