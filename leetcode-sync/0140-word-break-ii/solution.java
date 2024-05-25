import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        var sb = new StringBuilder(s);
        var wordsSet = new HashSet<String>(wordDict);
        
        var result = new ArrayList<String>();
        addSpaces(sb, 0, wordsSet, result);

        return result;
    }

    private void addSpaces(StringBuilder s, int startIndex, Set<String> wordDict, List<String> result){        
        if (startIndex == s.length()){
            result.add(s.substring(0, s.length() - 1));
            return;
        }
        
        for (int i = startIndex; i <= s.length(); i++) {
            String substring = s.substring(startIndex, i);

            if (wordDict.contains(substring)){
                s.insert(i, " ");
                addSpaces(s, i + 1, wordDict, result);
                s.deleteCharAt(i);
            }
        }
    }
}
