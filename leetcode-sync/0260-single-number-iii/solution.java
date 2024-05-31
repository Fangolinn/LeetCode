import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public int[] singleNumberV1(int[] nums) {
        // intended solution probably involves XOR, but let's do this instead
        Set<Integer> numsCount = new HashSet<>();

        // If num is in the set, it was seen once before (or an odd number of times to
        // be precise)
        for (int x : nums) {
            if (numsCount.contains(x))
                numsCount.remove(x);
            else {
                numsCount.add(x);
            }
        }

        // Due to problem constraints there is no need to check if set has two elements
        // left
        var iter = numsCount.iterator();
        return new int[] { iter.next(), iter.next() };
    }

    public int[] singleNumber(int[] nums) {
        if (nums.length == 2)
            return nums;

        Arrays.sort(nums);

        int[] result = new int[2];
        int resulti = 0;

        int xor = 0;
        int i = 0;

        while (i < nums.length - 1) {
            xor ^= nums[i];
            xor ^= nums[i + 1];

            if (xor != 0) {
                result[resulti++] = nums[i++];
                xor = 0;
            } else {
                i += 2;
            }
        }

        if (resulti != 2)
            result[resulti] = nums[nums.length - 1];

        return result;

    }
}
