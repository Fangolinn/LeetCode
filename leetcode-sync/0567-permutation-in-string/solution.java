import java.util.Arrays;

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        int[] s1Chars = new int[26];

        for (int c : s1.chars().toArray())
            s1Chars[c - 'a']++;

        int[] s2SubstringChars = new int[26];

        int right = 0;
        while (right < s1.length())
            s2SubstringChars[s2.charAt(right++) - 'a']++;

        if (Arrays.equals(s1Chars, s2SubstringChars))
            return true;

        while (right < s2.length()){
            s2SubstringChars[s2.charAt(right - s1.length()) - 'a']--;
            s2SubstringChars[s2.charAt(right++) - 'a']++;

            if (Arrays.equals(s1Chars, s2SubstringChars))
                return true;
        }

        return false;
    }
}
