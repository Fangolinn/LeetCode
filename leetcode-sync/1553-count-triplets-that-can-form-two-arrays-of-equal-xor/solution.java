import java.util.Arrays;

class Solution {
    public int countTripletsTesting(int[] arr) {
        int[] prefixXOR = new int[arr.length + 1];

        for (int i = 1; i < prefixXOR.length; i++) {
            prefixXOR[i] = arr[i - 1] ^ prefixXOR[i - 1];
        }

        System.out.println(Arrays.toString(prefixXOR));

        return 0;
    }

    public int countTripletsV1(int[] arr) {
        // Works, althought slowly
        int tripletCount = 0;

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                for (int k = j; k < arr.length; k++) {
                    if (xorOfRange(arr, i, j - 1) == xorOfRange(arr, j, k))
                        tripletCount++;
                }
            }
        }

        return tripletCount;
    }

    /**
     * Calculate XOR of range in int array.
     * 
     * @param arr
     * @param start inclusive
     * @param end   inclusive
     * @return
     */
    private int xorOfRange(int[] arr, int start, int end) {
        int result = 0;
        for (int i = start; i <= end; i++)
            result ^= arr[i];

        return result;
    }

    public int countTriplets(int[] arr) {
        int[] prefixXOR = new int[arr.length + 1];

        for (int i = 1; i <= arr.length; i++) {
            prefixXOR[i] = arr[i - 1] ^ prefixXOR[i - 1];
        }

        int tripletCount = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (prefixXOR[i] == prefixXOR[j + 1])
                    tripletCount += (j - i);
            }
        }

        return tripletCount;
    }

}
