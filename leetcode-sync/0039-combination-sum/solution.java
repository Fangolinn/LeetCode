import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();

        checkSubsets(candidates, target, 0, new ArrayList<>(), result);

        return result;
    }

    private int sumList(List<Integer> list) {
        Integer sum = 0;

        for (Integer integer : list) {
            sum += integer;
        }

        return sum;
    }

    private void checkSubsets(int[] candidates, int target, int currIndex, List<Integer> currentSubset,
            List<List<Integer>> result) {

        int sum = sumList(currentSubset);

        if (sum > target || currIndex == candidates.length)
            return;
        else if (sum == target) {
            result.add(currentSubset);
            return;
        }

        List<Integer> setCopy = new ArrayList<>(currentSubset);

        checkSubsets(candidates, target, currIndex + 1, currentSubset, result);

        setCopy.add(candidates[currIndex]);
        checkSubsets(candidates, target, currIndex, setCopy, result);
    }
}
