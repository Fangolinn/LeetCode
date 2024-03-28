import java.util.Map;
import java.util.HashMap;

class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int result = 1;

        int left = 0;

        Map<Integer, Integer> currentFrequency = new HashMap<>();

        for (int right = 0; right < nums.length; right++) {
            currentFrequency.put(nums[right], currentFrequency.getOrDefault(nums[right], 0) + 1);

            while (currentFrequency.get(nums[right]) > k) {
                currentFrequency.compute(nums[left], (key, value) -> value - 1);
                left++;
            }

            result = Math.max(result, right - left + 1);
        }

        return result;
    }
}
