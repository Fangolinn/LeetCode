import java.util.PriorityQueue;

class Solution {

    private double distanceToZeroZero(int[] point) {
        return Math.sqrt((double) (point[0] * point[0]) + (double) (point[1] * point[1]));
    }

    public int[][] kClosest(int[][] points, int k) {
        // Can definetely be optimized, since heapify'ing causes the distance for each
        // point to be calculated multiple times. I just don't care at the moment.
        PriorityQueue<int[]> heap = new PriorityQueue<int[]>(
                (point1, point2) -> Double.compare(distanceToZeroZero(point1), distanceToZeroZero(point2)));

        for (var point : points)
            heap.offer(point);

        int[][] result = new int[k--][2];

        for (; k >= 0; k--)
            result[k] = heap.poll();

        return result;

    }
}
