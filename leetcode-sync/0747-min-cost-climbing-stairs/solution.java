class Solution {
    /*
     * int[] dp;
     * 
     * public int minCostClimbingStairs(int[] cost) {
     * int n = cost.length;
     * 
     * dp = new int[n];
     * return Math.min(minCostToStep(n - 1, cost), minCostToStep(n -2, cost));
     * }
     * 
     * public int minCostToStep(int step, int[] cost) {
     * if (step < 0) {
     * return 0;
     * }
     * 
     * if (step == 0 || step == 1) return cost[step];
     * 
     * if (dp[step] != 0) return dp[step];
     * 
     * dp[step] = cost[step] + Math.min(minCostToStep(step - 1, cost),
     * minCostToStep(step - 2, cost));
     * 
     * return dp[step];
     * }
     */

    /*
     * public int minCostClimbingStairs(int[] cost) {
     * int n = cost.length;
     * 
     * int[] dp = new int[n];
     * 
     * for (int i = 0; i < n; i++) {
     * if (i == 0 || i == 1)
     * dp[i] = cost[i];
     * else
     * dp[i] = cost[i] + Math.min(dp[i - 1], dp[i - 2]);
     * }
     * 
     * return Math.min(dp[n - 1], dp[n - 2]);
     * }
     */

    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int first = cost[0];
        int second = cost[1];

        if (n <= 2)
            return Math.min(first, second);

        for (int i = 2; i < n; i++) {
            int curr = cost[i] + Math.min(first, second);
            first = second;
            second = curr;
        }
        
        return Math.min(first, second);
    }
}
