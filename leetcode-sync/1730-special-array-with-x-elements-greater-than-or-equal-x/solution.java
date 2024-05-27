import java.util.Arrays;

class Solution {
    public int specialArray(int[] nums) {
        Arrays.sort(nums);

        int len = nums.length;

        for (int i = 1; i <= len; i++)
            if (nums[len - i] >= i && (i == len || nums[len - i - 1] < i))
                return i;

        return -1;
    }
}
