import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        generateSubsets(nums, 0, new ArrayList<>(), subsets);
        return subsets;
    }

    private void generateSubsets(int[] nums, int currIndex, List<Integer> set, List<List<Integer>> result) {
        if (currIndex == nums.length) {
            result.add(set);
            return;
        }

        List<Integer> setCopy = new ArrayList<>(set);

        generateSubsets(nums, currIndex + 1, set, result);

        setCopy.add(nums[currIndex]);
        generateSubsets(nums, currIndex + 1, setCopy, result);
    }
}
