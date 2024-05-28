class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int[] prefixSum = new int[s.length() + 1];

        for (int i = 0; i < s.length(); i++) {
            prefixSum[i + 1] = Math.abs(s.charAt(i) - t.charAt(i)) + prefixSum[i];
        }

        int maxLen = 0;

        int left = 0;
        int right = 1;
        while (right <= s.length()) {
            if (left == right) {
                right++;
                continue;
            }

            if (prefixSum[right] - prefixSum[left] > maxCost) {
                left++;
            } else {
                maxLen = Math.max(maxLen, right - left);
                right++;
            }
        }

        return maxLen;
    }
}
