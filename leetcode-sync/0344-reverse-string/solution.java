class Solution {
    public void reverseString(char[] s) {
        int len = s.length;

        for (int i = 0; i <= (s.length - 1) / 2; i++) {
            char tmp = s[i];
            s[i] = s[--len];
            s[len] = tmp;
        }
    }
}
