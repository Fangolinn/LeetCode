import java.util.*;

class Solution {
    private Character[] toCharacterArray(String s) {
        Character[] chars = new Character[s.length()];

        for (int i = 0; i < chars.length; i++) {
            chars[i] = s.charAt(i);
        }

        return chars;
    }

    public String v1(String order, String s) {
        Character[] sChars = toCharacterArray(s);

        Arrays.sort(sChars, (Character c1, Character c2) -> Integer.compare(order.indexOf(c1), order.indexOf(c2)));

        StringBuilder result = new StringBuilder(s.length());

        for (char c : sChars) {
            result.append(c);
        }

        return result.toString();
    }

    public String v2(String order, String s) {
        Map<Character, Integer> charCount = new HashMap<>();

        for (char c : s.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }

        StringBuilder result = new StringBuilder(s.length());

        for (char c : order.toCharArray()) {
            result.append(String.valueOf(c).repeat(charCount.getOrDefault(c, 0)));
            charCount.remove(c);
        }

        for (char c : charCount.keySet()) {
            result.append(String.valueOf(c).repeat(charCount.getOrDefault(c, 0)));
        }

        return result.toString();
    }

    public String v3(String order, String s) {
        // Slower than v2
        Map<Character, Integer> charCount = new LinkedHashMap<>();

        for (char c : order.toCharArray()) {
            charCount.put(c, 0);
        }

        for (char c : s.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }

        StringBuilder result = new StringBuilder(s.length());

        for (char c : charCount.keySet()) {
            for (int i = 0; i < charCount.getOrDefault(c, 0); i++) {
                result.append(c);
            }
        }

        return result.toString();
    }

    public String customSortString(String order, String s) {
        return v2(order, s);
    }
}
