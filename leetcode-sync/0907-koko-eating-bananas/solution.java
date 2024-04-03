import java.util.Arrays;

class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = Integer.MAX_VALUE;

        int bestK = right;

        while (left <= right) {
            int k = left + Math.floorDiv(right - left, 2);

            long timeToEat = 0;

            for (int pile : piles)
                timeToEat += Math.ceilDiv(pile, k);
            
            if (timeToEat <= h) {
                bestK = Math.min(bestK, k);
            } 

            if (timeToEat > h) {
                left = k + 1;
            } else {
                right = k - 1;
            }
        }

        return bestK;
    }
}
