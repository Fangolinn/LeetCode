

class Solution {
    public boolean isPalindrome(String s) {
        for (int left = 0, right = s.length() - 1; left < right;) {
            char leftChar = s.charAt(left);

            if (!Character.isLetterOrDigit(leftChar)) {
                left++;
                continue;
            }

            char rightChar = s.charAt(right);

            if (!Character.isLetterOrDigit(rightChar)) {
                right--;
                continue;
            }

            if (Character.toLowerCase(leftChar) != Character.toLowerCase(rightChar)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}
