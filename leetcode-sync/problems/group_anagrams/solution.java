
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.HashMap;

class Solution {
    public boolean isAnagram(String s, String t) {
        char[] sChars = s.toCharArray(), tChars = t.toCharArray();

        Arrays.sort(sChars);
        Arrays.sort(tChars);

        return new String(sChars).equals(new String(tChars));
    }

    public String sortString(String str) {
        char[] strChars = str.toCharArray();
        Arrays.sort(strChars);
        return new String(strChars);
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> groupedAnagrams = new HashMap<>();

        for (String str : strs) {
            String sortedStr = sortString(str);

            if (!groupedAnagrams.containsKey(sortedStr)){
                groupedAnagrams.put(sortedStr, new ArrayList<String>());
            }

            groupedAnagrams.get(sortedStr).add(str);
        }

        List<List<String>> resultList = new ArrayList<>();

        for (List<String> group : groupedAnagrams.values()) {
            resultList.add(group);
        }

        return resultList;
    }
}