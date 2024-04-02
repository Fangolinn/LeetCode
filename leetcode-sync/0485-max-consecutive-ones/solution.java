class Solution {
    private int v1(int[] nums) {
        int maxCount = 0;

        int count = 0;
        for (int num : nums){
            if (num == 1) {
                count++;
            } else {
                maxCount = Math.max(count, maxCount);
                count = 0;
            }
            
        }

        return Math.max(count, maxCount);
    }
    
    public int findMaxConsecutiveOnes(int[] nums) {
        return v1(nums);
    }
}
