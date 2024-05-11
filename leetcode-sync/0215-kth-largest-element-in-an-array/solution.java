import java.util.PriorityQueue;

class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        for (var num : nums) {
            heap.add(num);
            if (heap.size() > k)
                heap.poll();
        }

        return heap.poll();
    }
}
