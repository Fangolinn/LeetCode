import java.math.BigInteger;
import java.util.Arrays;

class Solution {
    public int numStepsV1(String s) {
        // Naive approach, but works (although slower than it could)
        BigInteger val = new BigInteger(s, 2);

        int steps = 0;
        while (val.compareTo(BigInteger.valueOf(1)) > 0){
            if (val.mod(BigInteger.valueOf(2l)) == BigInteger.valueOf(0)) {
                val = val.divide(BigInteger.valueOf(2));
            } else {
                val = val.add(BigInteger.valueOf(1));
            }

            steps++;
        }

        return steps;
    }

    public int numSteps(String s) {
        int steps = 0;
        boolean carry = false;
        for (int i = s.length() - 1; i > 0; i--) {
            char currentChar = s.charAt(i);

            if (currentChar == '0' && carry){
                carry = false;
                currentChar = '1';
            }
            
            if (currentChar == '1' && !carry){
                steps++;
                carry = true;
            }
            
            steps++;
        }

        if (s.charAt(0) == '1' && carry){
            steps ++;
        }

        return steps;
    }
}
