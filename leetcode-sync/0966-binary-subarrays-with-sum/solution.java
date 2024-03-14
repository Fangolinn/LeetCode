import java.util.Map;
import java.util.HashMap;

class Solution {
    public static long factorial(int number) {
        long result = 1;

        for (int factor = 2; factor <= number; factor++) {
            result *= factor;
        }

        return result;
    }

    private int v1(int[] nums, int goal){
        // Sliding window
        int left = 0;
        int right = 0;

        int sum = 0;
        int result = 0;

        while (right < nums.length){
            if (sum == goal){
                result++;
            }

            if (sum >= goal) {
                sum -= nums[left++];
            }
            
            if (left >= right || sum < goal){
                right++;
                if (right < nums.length){
                    sum += nums[right];
                }
            }
        }

        return result;
    }

    private int v2(int[] nums, int goal){
        // Prefix sum, Chat GPT
        int count = 0;
        int sum = 0;
        // Map to store the frequency of prefix sums
        Map<Integer, Integer> prefixSumFreq = new HashMap<>();
        // Initialize the map with 0 prefix sum frequency as 1
        prefixSumFreq.put(0, 1);

        for (int num : nums) {
            sum += num;
            // Check if there exists a prefix sum such that sum - prefix_sum = goal
            if (prefixSumFreq.containsKey(sum - goal)) {
                count += prefixSumFreq.get(sum - goal);
            }
            // Update the frequency of current prefix sum
            prefixSumFreq.put(sum, prefixSumFreq.getOrDefault(sum, 0) + 1);
        }

        return count;
    }

    public int numSubarraysWithSum(int[] nums, int goal) {
        return v2(nums, goal);
    }
}
