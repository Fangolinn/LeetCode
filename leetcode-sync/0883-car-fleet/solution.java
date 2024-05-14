import java.util.PriorityQueue;

class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        PriorityQueue<double[]> stack = new PriorityQueue<>((v1, v2) -> Double.compare(v2[0], v1[0]));

        // [position, arrival time]
        for (int i = 0; i < position.length; i++) {
            stack.offer(new double[] {position[i], (double)(target - position[i]) / speed[i]});
        }

        double prev = stack.poll()[1];
        int fleets = 1;

        while (!stack.isEmpty()) {
            double curr = stack.poll()[1];

            if (curr > prev){
                fleets += 1;
                prev = curr;
            }
        }

        return fleets;
    }
}
