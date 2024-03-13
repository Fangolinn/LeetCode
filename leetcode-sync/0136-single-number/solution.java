import java.util.HashSet;
import java.util.Set;

class Solution {
    private int v1(int[] nums) {
        Set<Integer> previousNums = new HashSet<>();

        for (int num : nums){
            if(previousNums.contains(num)){
                previousNums.remove(num);
            } else {
                previousNums.add(num);
            }
        }

        return previousNums.iterator().next();
    }
    
    private int v2(int[] nums) {
        int result = 0;
        
        for (int num : nums){
            result = result ^ num;
        }

        return result;
    }

    public int singleNumber(int[] nums) {
        return v2(nums);
    }
}
