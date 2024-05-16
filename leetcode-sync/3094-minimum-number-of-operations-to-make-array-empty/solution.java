import java.util.HashMap;
import java.util.Map;

class Solution {
    public int minOperations(int[] nums) {
        Map<Integer, Integer> numCountMap = new HashMap<>();

        for (int val : nums) 
            numCountMap.put(val, numCountMap.getOrDefault(val, 0) + 1);
        
        int operations = 0;
        for (var val : numCountMap.values()) {
            if (val == 1) {
                return -1;
            }

            operations += Math.ceilDiv(val, 3);
        }

        return operations;
    }
}
