class Solution {
    public int pivotInteger(int n) {
        int left = 1;
        int right = n;

        int prefixSum = left;
        int suffixSum = right;

        while (left < right) {
            if (prefixSum < suffixSum) {
                left++;
                prefixSum += left;
            } else {
                right--;
                suffixSum += right;
            }
        }

        if (prefixSum == suffixSum) {
            return left;
        } else {
            return -1;
        }
    }
}
