class Solution {
    public int[] countBits(int n) {
        n++;
        int[] out = new int[n];

        out[0] = 0;

        for (int i = 1; i < n; i++) {
            out[i] = out[i / 2] + i % 2;
        }

        return out;
    }
}
