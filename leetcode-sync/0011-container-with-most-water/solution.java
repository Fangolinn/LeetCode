class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;

        int maxVolume = 0;

        while (left < right) {
            maxVolume = Math.max((right - left) * Math.min(height[left], height[right]), maxVolume);

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxVolume;
    }
}
