import java.util.Map;
import java.util.HashMap;

class Solution {
    public boolean isIsomorphic(String s, String t) {
        // As per question description, s.length() == t.length()
        
        Map<Character, Character> charMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            if (charMap.containsKey(s.charAt(i))) {
                if (t.charAt(i) != charMap.get(s.charAt(i))) {
                    return false;
                }
            } else {
                if (charMap.containsValue(t.charAt(i))){
                    return false;
                }
                charMap.put(s.charAt(i), t.charAt(i));
            }
        }

        return true;
    }
}
