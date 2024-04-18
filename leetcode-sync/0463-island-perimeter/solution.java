class Solution {
    private int v1_islandPerimeter(int[][] grid) {
        // Bruteforce approach, iterate through each cell and check it's borders
        int perimeter = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    if (i == 0 || grid[i - 1][j] == 0) {
                        perimeter++;
                    }

                    if (i == grid.length - 1 || grid[i + 1][j] == 0) {
                        perimeter++;
                    }

                    if (j == 0 || grid[i][j - 1] == 0) {
                        perimeter++;
                    }

                    if (j == grid[0].length - 1 || grid[i][j + 1] == 0) {
                        perimeter++;
                    }
                }
            }
        }

        return perimeter;
    }

    private int v2_islandPerimeter(int[][] grid) {
        // Slower than v1 lol
        for (int i = 0; i < grid.length * grid[0].length; i++) {
            if (grid[i / grid[0].length][i % grid[0].length] == 1) {
                return scan(grid, i / grid[0].length, i % grid[0].length);
            }
        }

        return 0;
    }

    private int scan(int[][] grid, int y, int x) {
        if (y < 0 || y == grid.length || x < 0 || x == grid[0].length || grid[y][x] == 0) {
            return 1;
        } else if (grid[y][x] == -1) {
            return 0;
        }

        grid[y][x] = -1;

        return scan(grid, y + 1, x) + scan(grid, y - 1, x) + scan(grid, y, x + 1) + scan(grid, y, x - 1);
    }

    public int islandPerimeter(int[][] grid) {
        return v2_islandPerimeter(grid);
    }
}
