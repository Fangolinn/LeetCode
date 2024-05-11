import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.reverseOrder());

        for (var stone : stones) heap.offer(stone);

        while (heap.size() >= 2){
            Integer stone1 = heap.poll();
            Integer stone2 = heap.poll();

            if (stone1.equals(stone2)){
                continue;
            }

            heap.offer(Math.abs(stone1 - stone2));
        }

        return heap.size() == 1 ? heap.poll() : 0;
    }
}
