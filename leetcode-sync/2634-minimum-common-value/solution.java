class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        if (nums1[nums1.length - 1] < nums2[0] || nums1[0] > nums2[nums2.length - 1]) {
            return -1;
        }

        int iterNums1 = 0;
        int iterNums2 = 0;
        while (iterNums1 < nums1.length && iterNums2 < nums2.length) {
            int num1 = nums1[iterNums1];
            int num2 = nums2[iterNums2];
            if (num1 < num2) {
                iterNums1++;
            } else if(num1 > num2) {
                iterNums2++;
            } else if(num1 == num2) {
                return nums1[iterNums1];
            }
        }

        return -1;
    }
}
