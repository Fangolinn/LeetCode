import java.util.ArrayList;

class Solution {
    public int subsetXORSum(int[] nums) {
        int result = 0;
        List<List<Integer>> subsets = new ArrayList<>();
        generateSubsets(nums, 0, new ArrayList<>(), subsets);
        
        for (List<Integer> subset : subsets)
            result += XORTotal(subset);

        return result;
    }

    private int XORTotal(List<Integer> arr) {
        int total = 0;
        for (var val : arr)
            total ^= val;

        return total;
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
