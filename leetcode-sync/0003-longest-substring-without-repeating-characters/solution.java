import java.util.HashMap;
import java.util.Map;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> chars = new HashMap<>();
        
        int left = 0;
        int right = 0;

        int maxLen = 0;

        while (right < s.length()){
            char currChar = s.charAt(right++);
            chars.put(currChar, chars.getOrDefault(currChar, 0) + 1);
            
            while (chars.get(currChar) > 1) {
                chars.compute(s.charAt(left), (k, v) -> v - 1);
                left++;
            }

            maxLen = Math.max(maxLen, right - left);
        }

        return maxLen;
    }
}
