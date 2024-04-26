class Solution {
    public int minFallingPathSum(int[][] grid) {
        // Chat GPT solution
        int n = grid.length;
        
        // Create a dp array to store the minimum falling path sum for each cell
        int[][] dp = new int[n][n];
        
        // Initialize the first row of dp with the values from the grid
        for (int j = 0; j < n; j++) {
            dp[0][j] = grid[0][j];
        }
        
        // Iterate through the remaining rows
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // Initialize the current cell in dp with the value from the grid
                dp[i][j] = grid[i][j];
                
                // Find the minimum value from the previous row that is not in the same column
                int minPrev = Integer.MAX_VALUE;
                for (int k = 0; k < n; k++) {
                    if (k != j) {
                        minPrev = Math.min(minPrev, dp[i - 1][k]);
                    }
                }
                
                // Add the minimum value from the previous row to the current cell
                dp[i][j] += minPrev;
            }
        }
        
        // Find the minimum falling path sum from the last row of dp
        int minSum = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            minSum = Math.min(minSum, dp[n - 1][j]);
        }
        
        return minSum;
    }
}

