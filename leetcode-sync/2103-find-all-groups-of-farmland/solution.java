import java.util.ArrayList;

class Solution {
    public int[][] findFarmland(int[][] land) {
        ArrayList<int[]> farmlands = new ArrayList<>();
        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[0].length; j++) {
                if (land[i][j] == 1 && ((i == 0 && j == 0) || (i == 0 && land[i][j - 1] == 0) || (j == 0 && land[i - 1][j] == 0) || (i > 0 && j > 0 && land[i][j - 1] == 0 && land[i - 1][j] == 0))) {
                    int[] bottomRight = findBottomRightCorner(land, i, j);
                    farmlands.add(new int[] {i, j, bottomRight[0], bottomRight[1]});
                }
            }
        }

        int[][] result = new int[farmlands.size()][];

        for (int i = 0; i < result.length; i++) {
            result[i] = farmlands.get(i);
        }

        return result;
    }

    private int[] findBottomRightCorner(int[][] land, int y, int x) {
        while (y < land.length - 1 && land[y + 1][x] == 1) y++;
        while (x < land[0].length - 1 && land[y][x + 1] == 1) x++;

        return new int[] {y, x};
    }
}
