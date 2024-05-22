import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);

        Set<List<Integer>> subsets = new HashSet<>();
        generateSubsets(nums, 0, new ArrayList<>(), subsets);
        return subsets.stream().toList();
    }

    private void generateSubsets(int[] nums, int currIndex, List<Integer> set, Set<List<Integer>> result) {
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
