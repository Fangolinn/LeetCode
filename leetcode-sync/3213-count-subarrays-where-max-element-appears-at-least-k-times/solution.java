class Solution {
    private int arrayMax(int[] nums) {
        int max = nums[0];

        for (int num : nums) {
            max = Math.max(max, num);
        }

        return max;
    }

    public long countSubarrays(int[] nums, int k) {
        long result = 0;

        int max = arrayMax(nums);

        int count = 0;
        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == max)
                count++;

            while (count >= k) {
                if (nums[left++] == max) {
                    count--;
                } 
            }

            result += left;
        }

        return result;
    }
}
