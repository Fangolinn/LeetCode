class Solution {
    private void flipRow(int[] row) {
        for (int i = 0; i < row.length; i++) {
            row[i] = row[i] == 0 ? 1 : 0;
        }
    }

    private void flipCol(int col, int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            grid[i][col] = grid[i][col] == 0 ? 1 : 0;
        }
    }

    private boolean majorityZeros(int col, int[][] grid) {
        int zerosCount = 0;
        for (int i = 0; i < grid.length; i++) {
            zerosCount += grid[i][col] == 0 ? 1 : 0;
        }

        return zerosCount > (double) grid.length / 2;
    }

    public int matrixScore(int[][] grid) {
        for (int[] row : grid)
            if (row[0] == 0)
                flipRow(row);

        for (int col = 0; col < grid[0].length; col++) 
            if (majorityZeros(col, grid))
                flipCol(col, grid);
        
        int result = 0;

        for (int[] row : grid) {
            StringBuilder sb = new StringBuilder();

            for (int val : row) 
                sb.append(val);
            
            result += Integer.parseInt(sb.toString(), 2);
        }

        return result;
    }
}
