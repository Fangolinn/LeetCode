class Solution {
    public boolean isSubsequence(String s, String t) {
        int sIter = 0;
        int tIter = 0;

        while (sIter < s.length() && tIter < t.length()) {
            if (s.charAt(sIter) == t.charAt(tIter)){
                sIter++;
            }

            tIter++;
        }

        return sIter == s.length();
    }
}
