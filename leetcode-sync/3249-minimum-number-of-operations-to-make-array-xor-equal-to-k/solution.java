class Solution {
    public int minOperations(int[] nums, int k) {
        int xor = nums[0];

        for (int i = 1; i < nums.length; i++) {
            xor ^= nums[i];
        }

        int result = 0;

        while (xor > 0 || k > 0){
            if ((xor % 2) != (k % 2))
                result++;
            
            xor >>= 1;
            k >>= 1;
        }

        return result;
    }
}
