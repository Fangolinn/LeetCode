import java.util.Arrays;

class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);

        long result = 0;
        int len = happiness.length;

        for (int i = 0; i < k; i++) {
            result += Math.max(happiness[len - 1 - i] - i, 0);
        }

        return result;
    }
}
