import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public int beautifulSubsets(int[] nums, int k) {
        Arrays.sort(nums);

        return testSubsets(nums, 0, new HashSet<>(), k);
    }

    private int testSubsets(int[] nums, int currIndex, Set<Integer> set, int k) {
        if (currIndex == nums.length)
            return set.isEmpty() ? 0 : 1;

        int beautifulCount = 0;

        Set<Integer> setCopy = new HashSet<>(set);

        beautifulCount += testSubsets(nums, currIndex + 1, set, k);

        int currentVal = nums[currIndex];
        if (!setCopy.contains(currentVal - k)) {
            setCopy.add(nums[currIndex]);
            beautifulCount += testSubsets(nums, currIndex + 1, setCopy, k);
        }

        return beautifulCount;
    }
}
