import java.util.*;

class Solution {
    public int[] v1(int[] numbers, int target) {
        // Naive approach, works the same for sorted and unsorted array.
        Map<Integer, Integer> numsIndexes = new HashMap<>(numbers.length);

        int i = 0;
        for (int num : numbers) {
            if (numsIndexes.keySet().contains(target - num)) {
                return new int[] { numsIndexes.get(target - num) + 1, i + 1 };
            }

            numsIndexes.put(num, i++);
        }

        return new int[] { -1, -1 };
    }

    public int[] v2(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            int currentSum = numbers[left] + numbers[right];

            if (currentSum < target) {
                left++;
                continue;
            } else if (currentSum > target){
                right--;
                continue;
            }

            return new int[] { left + 1, right + 1 };
        }

        return new int[] { -1, -1 };

    }

    public int[] twoSum(int[] numbers, int target) {
        return v2(numbers, target);
    }
}
