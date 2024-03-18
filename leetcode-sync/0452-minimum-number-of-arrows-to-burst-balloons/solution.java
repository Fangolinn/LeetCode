import java.util.Arrays;

class Solution {
    public int findMinArrowShots(int[][] points) {
        if (points == null || points.length == 0) return 0;

        Arrays.sort(points, (a, b) -> {
            if (a[1] < b[1]) return -1;
            else if (a[1] > b[1]) return 1;
            else return 0;
        });

        int arrows = 1;
        long end = points[0][1];

        for (int i = 1; i < points.length; i++) {
            if ((long) points[i][0] > end) {
                arrows++;
                end = points[i][1];
            }
        }

        return arrows;
    }
}
