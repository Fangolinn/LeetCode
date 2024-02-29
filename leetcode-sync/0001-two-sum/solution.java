import java.lang.ArrayIndexOutOfBoundsException;
import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> numsMap = new HashMap<>();

        // TODO: Optimize by iterating for-each instead of indexes
        for (int i = 0; i < nums.length; ++i){
            if(numsMap.containsKey(target - nums[i])){
                int secondValIndex = numsMap.get(target - nums[i]);

                int[] result = {i, secondValIndex};
                return result;
            }

            numsMap.put(nums[i], i);
        }

        throw new ArrayIndexOutOfBoundsException("No two-sum has been found.");
    }
}
