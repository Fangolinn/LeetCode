import java.util.*;

class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxLen = 0;
        int count = 0;
        
        map.put(0, -1); // Initial sum is 0 at index -1
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                count--;
            } else {
                count++;
            }
            
            if (map.containsKey(count)) {
                maxLen = Math.max(maxLen, i - map.get(count));
            } else {
                map.put(count, i);
            }
        }
        
        return maxLen;
    }
}
