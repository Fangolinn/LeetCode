class Solution {
    public int v1(int x) {
        // Repeated subtraction
        int sqrt = 0;
        for (int i = 1; x >= i; i += 2, sqrt++) {
            x -= i;
        }

        return sqrt;
    }

    public int mySqrt(int x) {
        return v1(x);
    }
}
