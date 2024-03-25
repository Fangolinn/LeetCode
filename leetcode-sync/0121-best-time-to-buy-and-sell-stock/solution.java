class Solution {
    public int maxProfit(int[] prices) {
        int min = prices[0];
        
        int maxDiff = 0;
        for (int num : prices){
            if (num < min) {
                min = num;
            } else {
                maxDiff = Math.max(num - min, maxDiff);

            }
        }

        return maxDiff;
    }
}
