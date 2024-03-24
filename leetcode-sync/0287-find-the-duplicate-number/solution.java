class Solution {
    public int findDuplicate(int[] nums) {
        int tortoise = 0;
        int hare = 0;

        while (true) {
            tortoise = nums[tortoise];
            hare = nums[nums[hare]];

            if (tortoise == hare) {
                break;
            }
        }

        int seek = 0;

        while (true) {
            tortoise = nums[tortoise];
            seek = nums[seek];

            if (tortoise == seek){
                break;
            }
        }

        return seek;
    }
}
