import java.util.Map;
import java.util.HashMap;

class Solution {
    private int v1(int[] nums, int k) {
        // Incredibly slow
        int result = 0;

        boolean subarrayFound = false;

        for (int left = 0; left < nums.length - k + 1; left++) {
            Map<Integer, Integer> currentInts = new HashMap<>();
            int right = left;

            subarrayFound = false;

            while (currentInts.size() <= k && right < nums.length) {
                currentInts.compute(nums[right++], (key, value) -> (value == null) ? 0 : (value + 1));
                if (currentInts.size() == k) {
                    result++;
                    subarrayFound = true;
                }
            }

            if (!subarrayFound) {
                break;
            }
        }

        return result;
    }

    private int subarraysWithAtMostKDistinct(int[] nums, int k) {
        int result = 0;

        int left = 0;

        Map<Integer, Integer> frequency = new HashMap<>();

        for (int right = 0; right < nums.length; right++) {
            frequency.put(nums[right], frequency.getOrDefault(nums[right], 0) + 1);

            while (frequency.size() > k) {
                // frequency.compute(nums[left], (key, value) -> (value - 1));
                frequency.put(nums[left], frequency.get(nums[left]) - 1);
                frequency.remove(nums[left++], 0);
            }

            result += right - left;
        }

        return result;
    }

    public int subarraysWithKDistinct(int[] nums, int k) {
        return subarraysWithAtMostKDistinct(nums, k) - subarraysWithAtMostKDistinct(nums, k - 1);
    }
}
