import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> result = new ArrayList<>();

        String digits = "123456789";

        int lowLen = Integer.toString(low).length();
        int highLen = Integer.toString(high).length();

        for (int windowSize = lowLen; windowSize <= highLen; windowSize++) {
            for (int i = 0; i <= digits.length() - windowSize; i++) {
                Integer val = Integer.parseInt(digits.substring(i, i + windowSize));

                if (val < low)
                    continue;
                else if (val > high)
                    break;

                result.add(val);
            }
        }

        return result;
    }
}
