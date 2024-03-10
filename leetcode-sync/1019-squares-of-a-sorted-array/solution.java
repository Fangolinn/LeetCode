import java.util.Arrays;
import java.util.Comparator;

class Solution {
    private int[] v1(int[] nums) {
        // The fun way
        return Arrays.stream(nums).map(i -> i * i).sorted().toArray();
    }

    private int[] v2(int[] nums) {
        // The more efficient way
        int[] result = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            result[i] = nums[i] * nums[i];
        }

        Arrays.sort(result);
        return result;
    }

    private int[] v3(int[] nums) {
        // The most efficient way???
        int[] result = new int[nums.length];

        int left = 0;
        int right = nums.length - 1;

        int leftSquared = nums[left] * nums[left];
        int rightSquared = nums[right] * nums[right];

        int resultIndex = result.length - 1;

        while (left < right) {
            if (leftSquared <= rightSquared) {
                result[resultIndex--] = rightSquared;
                right--;
                rightSquared = nums[right] * nums[right];
            } else if (leftSquared > rightSquared) {
                result[resultIndex--] = leftSquared;
                left++;
                leftSquared = nums[left] * nums[left];
            }
        }

        result[resultIndex] = leftSquared;

        return result;
    }

    public int[] sortedSquares(int[] nums) {
        return v3(nums);
    }
}
