import java.util.Arrays;

class Solution {
    public int[][] largestLocal(int[][] grid) {
        return largestLocalV1(grid);
    }

    // Attempt 1 - naive approach, calculate the max every time independantly. 
    // Definetely can be improved
    private int largest(int[][] grid, int iCenter, int jCenter) {
        int max = 0;
        for (int i = iCenter - 1; i <= iCenter + 1; i++) {
            for (int j = jCenter - 1; j <= jCenter + 1; j++) {
                max = Math.max(max, grid[i][j]);
            }
        }

        return max;
    }

    public int[][] largestLocalV1(int[][] grid) {
        for (int i = 1; i < grid[0].length - 1; i++) {
            for (int j = 1; j < grid.length - 1; j++) {
                grid[i - 1][j - 1] = largest(grid, i, j);
            }
        }

        grid = Arrays.copyOf(grid, grid.length - 2);

        for (int i = 0; i < grid.length; i++) {
            grid[i] = Arrays.copyOf(grid[i], grid.length);
        }

        return grid;
    }


}
