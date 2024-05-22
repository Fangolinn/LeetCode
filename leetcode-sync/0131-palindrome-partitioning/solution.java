import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();

        check(s, 0, 1, new ArrayList<>(), result);

        return result;
    }

    private void check(String s, int startIndex, int substrLen, List<String> currentPartition,List<List<String>> result){
        if (startIndex == s.length()){
            result.add(currentPartition);
            return;
        }
        
        if (s.length() - substrLen < startIndex) return;

        check(s, startIndex, substrLen + 1, new ArrayList<>(currentPartition), result);

        String currentSubstr = s.substring(startIndex, startIndex + substrLen);
        if (!isPalindrome(currentSubstr)) return;

        currentPartition.add(currentSubstr);
        check(s, startIndex + substrLen, 1, currentPartition, result);
    }

    private boolean isPalindrome(String s) {
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) return false;
        }

        return true;
    }
}
