class Solution {
    public int trap(int[] height) {
        int[] ans = new int[height.length];
        int max = 0;
        for (int i = height.length - 1; i >= 0; i--) {
            if (height[i] > max)
                max = height[i];
            ans[i] = max;
        }
        max = 0;
        int sol = 0;
        for (int i = 0; i < height.length; i++) {
            if (height[i] > max)
                max = height[i];
            sol += Math.min(max, ans[i]) - height[i];
        }

        return sol;

    }
}
