class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int middle = left + Math.floorDiv(right - left, 2);

            if (nums[middle] <= nums[middle == 0 ? nums.length - 1 : middle - 1])
                return nums[middle];

            if (nums[middle] > nums[right]) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }

        throw new UnsupportedOperationException("Under question constraints the code shouldn't reach here.");
    }
}
