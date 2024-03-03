
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> counts = new HashMap<>();

        for (int num : nums) {
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }

        List<Integer>[] buckets = new List[Collections.max(counts.values()) + 1];

        for (int num : counts.keySet()) {
            int numCount = counts.get(num);
            if (buckets[numCount] == null) {
                buckets[numCount] = new ArrayList<>();
            }

            buckets[numCount].add(num);
        }

        List<Integer> result = new ArrayList<>();

        for (int i = buckets.length - 1; result.size() < k; --i) {
            if (buckets[i] != null) {
                result.addAll(buckets[i]);
            }
        }

        return result.stream().mapToInt(i -> i).toArray();
    }
}