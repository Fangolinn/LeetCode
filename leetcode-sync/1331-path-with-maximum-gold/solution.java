class Solution {
    public int getMaximumGold(int[][] grid) {
        int max = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                max = Math.max(dfsFromCoords(grid, i, j), max);
            }
        }

        return max;
    }

    private int max(int v1, int v2, int v3, int v4) {
        return Math.max(Math.max(v1, v2), Math.max(v3, v4));
    }

    private int dfsFromCoords(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
            return 0;
        }

        if (grid[i][j] == 0) {
            return 0;
        }

        int gold = grid[i][j];
        grid[i][j] = 0;

        int max = max(dfsFromCoords(grid, i - 1, j), dfsFromCoords(grid, i + 1, j),
                dfsFromCoords(grid, i, j - 1), dfsFromCoords(grid, i, j + 1));

        grid[i][j] = gold;
        return gold + max;
    }
}
