class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] prefixProduct = new int[nums.length + 1];
        prefixProduct[0] = 1;

        for (int i = 0; i < nums.length; i++){
            prefixProduct[i + 1] = prefixProduct[i] * nums[i];
        }

        int[] suffixProduct = new int[nums.length + 1];
        suffixProduct[suffixProduct.length - 1] = 1;

        for (int i = nums.length - 1; i > 0; i--){
            suffixProduct[i] = suffixProduct[i + 1] * nums[i];
        }

        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++){
            result[i] = prefixProduct[i] * suffixProduct[i + 1];
        }

        return result;
    }
}
