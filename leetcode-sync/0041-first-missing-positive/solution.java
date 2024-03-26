import java.util.HashSet;
import java.util.Set;

class Solution {
    public int v1(int[] nums) {
        // Slow solution, O(2n) I believe
        // Also O(n) space

        Set<Integer> numsSet = new HashSet<>();

        for (int num : nums) {
            numsSet.add(num);
        }

        for (int i = 1; i <= nums.length; i++) {
            if (!numsSet.contains(i)) {
                return i;
            }
        }

        return nums.length + 1;
    }

    public int v2(int[] nums) {
        // There exists some clever solution for this problem
        // Just gotta find it, preferably without help of leetcode Discussion section
        // In the end I used Discussion section to see the thought process

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= 0) {
                nums[i] = nums.length + 1;
            }
        }

        for (int i : nums) {
            int abs = Math.abs(i);

            if (abs > nums.length) {
                continue;
            }

            nums[abs - 1] = -Math.abs(nums[abs - 1]);
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0){
                return i + 1;
            }
        }

        return nums.length + 1;
    }

    public int firstMissingPositive(int[] nums) {
        return v2(nums);
    }
}
