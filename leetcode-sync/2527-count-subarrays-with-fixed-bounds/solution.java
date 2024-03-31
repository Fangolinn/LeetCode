class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        long result = 0;

        int lastMinK = -1;
        int lastMaxK = -1;
        int lastOutsideRange = -1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < minK || nums[i] > maxK) {
                lastOutsideRange = i;
            }
            if (nums[i] == minK) {
                lastMinK = i;
            }
            if (nums[i] == maxK) {
                lastMaxK = i;
            }

            if (lastMinK == -1 || lastMaxK == -1 || lastOutsideRange > Math.min(lastMinK, lastMaxK)) {
                continue;
            }

            result += Math.min(lastMinK, lastMaxK) - lastOutsideRange;
        }

        return result;
    }
}
