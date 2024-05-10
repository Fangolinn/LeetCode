import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        // Naive approach: compute all possible fractions > sort > extract
        Map<Double, int[]> decimalFractionMap = new HashMap<>();
        List<Double> decimals = new ArrayList<>();
        
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                int[] fraction = new int[]{arr[j], arr[i]};
                double decimal = (double)fraction[0] / (double)fraction[1];

                decimalFractionMap.put(decimal, fraction);
                decimals.add(decimal);
            }
        }

        Collections.sort(decimals);
        return decimalFractionMap.get(decimals.get(k - 1));
    }
}
