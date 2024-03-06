class Solution {
    public String maximumOddBinaryNumber(String s) {
        int onesCount = 0;
        
        for (char character : s.toCharArray()) {
            if (character == '1') {
                onesCount++;
            }
        }

        char[] resultString = new char[s.length()];

        for (int i = 0; i < onesCount - 1; i++) {
            resultString[i] = '1';
        }

        resultString[s.length() - 1] = '1';

        for (int i = 0; i < s.length() - onesCount; i++) {
            resultString[onesCount - 1 + i] = '0';
        }

        return new String(resultString);
    }
}
