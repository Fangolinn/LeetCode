import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    private int diff(int val, int k) {
        return (val ^ k) - val;
    }

    public long maximumValueSum(int[] nums, int k, int[][] edges) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(
                (i1, i2) -> Integer.compare(diff(nums[i2], k), diff(nums[i1], k)));

        for (int i = 0; i < nums.length; i++) {
            heap.add(i);
        }

        while (true) {
            int index1 = heap.poll();
            int index2 = heap.poll();

            if (diff(nums[index1], k) + diff(nums[index2], k) <= 0)
                break;

            nums[index1] ^= k;
            nums[index2] ^= k;

            heap.offer(index1);
            heap.offer(index2);
        }

        return Arrays.stream(nums).mapToLong(l -> l).sum();
    }
}
