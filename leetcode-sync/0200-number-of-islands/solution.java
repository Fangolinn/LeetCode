import java.util.ArrayDeque;

class Solution {
    private final int[][] directions = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

    public int numIslands(char[][] grid) {
        int islands = 0;

        ArrayDeque<int[]> queue = new ArrayDeque<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    islands++;
                    // markIslandDFS(grid, i, j);
                    markIslandBFS(grid, i, j, queue);
                }
            }
        }

        return islands;
    }

    private void markIslandDFS(char[][] grid, int y, int x) {
        if (y < 0 || x < 0 || y == grid.length || x == grid[0].length) {
            return;
        }

        if (grid[y][x] != '1') {
            return;
        }

        grid[y][x] = '*';

        for (int[] dir : directions) {
            markIslandDFS(grid, y + dir[0], x + dir[1]);
        }
    }

    private void markIslandBFS(char[][] grid, int y, int x, ArrayDeque<int[]> queue) {
        queue.offer(new int[] { y, x });
        grid[y][x] = '*';

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();

            y = cell[0];
            x = cell[1];

            for (int[] dir : directions) {
                int ny = y + dir[0];
                int nx = x + dir[1];

                if (ny >= 0 && ny < grid.length && nx >= 0 && nx < grid[0].length && grid[ny][nx] == '1') {
                    grid[ny][nx] = '*';
                    queue.offer(new int[] {ny, nx});
                }
            }
        }
    }
}
