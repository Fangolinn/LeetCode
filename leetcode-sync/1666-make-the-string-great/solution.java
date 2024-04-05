class Solution {
    public String makeGood(String s) {
        StringBuilder result = new StringBuilder();

        int i = 0;
        while (i <= s.length() - 2) {
            if (Math.abs(s.charAt(i) - s.charAt(i + 1)) == 32) {
                i += 2;
            } else {
                result.append(s.charAt(i++));
            }
        }

        if (i == s.length() - 1)
            result.append(s.charAt(s.length() - 1));

        if (result.toString().equals(s)) {
            return s;
        } else {
            return makeGood(result.toString());
        }
    }
}
