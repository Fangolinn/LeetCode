
class Solution {
    // Recursion, very slow solution
    /*
     * public int minimumLength(String s) {
     * char prefixStartChar = s.charAt(0);
     * char suffixEndChar = s.charAt(s.length() - 1);
     * 
     * if (prefixStartChar != suffixEndChar) {
     * return s.length();
     * }
     * 
     * if (s.length() == 1) {
     * return 1;
     * }
     * 
     * // get prefix len
     * int prefixLen = 0;
     * do {
     * prefixLen++;
     * 
     * if (prefixLen == s.length()){
     * return 0;
     * }
     * } while (s.charAt(prefixLen) == prefixStartChar);
     * 
     * // get suffix len
     * int suffixLen = 1;
     * while (s.charAt(s.length() - suffixLen - 1) == suffixEndChar) {
     * suffixLen++;
     * }
     * 
     * return minimumLength(s.substring(prefixLen, s.length() - suffixLen));
     * }
     */

    public int minimumLength(String s) {
        int subStrStart = 0, subStrEnd = s.length() - 1;

        while (subStrStart < subStrEnd && s.charAt(subStrStart) == s.charAt(subStrEnd)) {
            char currentChar = s.charAt(subStrStart);

            while (subStrStart <= subStrEnd && s.charAt(subStrStart) == currentChar) {
                subStrStart++;
            }

            while (subStrStart <= subStrEnd && s.charAt(subStrEnd) == currentChar) {
                subStrEnd--;
            }

        }

        return subStrEnd - subStrStart + 1;
    }
}
