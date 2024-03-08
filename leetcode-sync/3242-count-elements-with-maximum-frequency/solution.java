import java.util.*;

class Solution {
    private int v1(int[] nums) {
        Map<Integer, Integer> counts = new HashMap<>();

        for (int num : nums) {
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }

        int[] countCount = new int[Collections.max(counts.values()) + 1];

        int maxCount = 0;
        for (int count : counts.values()) {
            if (count < maxCount) {
                continue;
            }

            if (count > maxCount) {
                maxCount = count;
            }

            countCount[count]++;
        }

        int result = maxCount * countCount[maxCount];
        return result;
    }

    private int v2(int[] nums) {
        Map<Integer, Integer> counts = new HashMap<>();

        for (int num : nums) {
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }

        Map<Integer, Integer> countCount = new HashMap<>();

        int maxCount = 0;
        for (int count : counts.values()) {
            if (count < maxCount) {
                continue;
            }

            if (count > maxCount) {
                maxCount = count;
            }

            countCount.put(count, countCount.getOrDefault(count, 0) + 1);
        }

        int result = maxCount * countCount.get(maxCount);

        return result;
    }

    private int v3(int[] nums) {
        // Chat GPT
        Map<Integer, Integer> counts = new HashMap<>();

        for (int num : nums) {
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }

        // Find the maximum frequency
        int maxCount = 0;
        int maxFrequencyElementsCount = 0;
        for (int count : counts.values()) {
            if (count < maxCount){
                continue;
            }

            if (count > maxCount) {
                maxCount = count;
                maxFrequencyElementsCount = 0;
            }

            maxFrequencyElementsCount++;
        }

        // Calculate the result
        int result = maxCount * maxFrequencyElementsCount;

        return result;
    }

    private int v4(int[] nums){
        // Slower than v3

        Map<Integer, Integer> numCount = new HashMap<>();
        Set<Integer> factoredNums = new HashSet<>();

        int maxCount = 0;
        for (int num : nums) {
            numCount.put(num, numCount.getOrDefault(num, 0) + 1);
            int currentCount = numCount.get(num);

            if (currentCount > maxCount){
                maxCount = currentCount;
                factoredNums.clear();
                factoredNums.add(num);
            } else if (currentCount == maxCount) {
                factoredNums.add(num);
            }
        }

        return maxCount * factoredNums.size();
    }

    public int maxFrequencyElements(int[] nums) {
        return v3(nums);
    }
}

