class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder result = new StringBuilder();

        while (columnNumber != 0) {
            int modulus = columnNumber % 26;
            result.append(modulus != 0 ? (char) (modulus + 64) : 'Z');
            columnNumber -= modulus != 0 ? modulus : 26;
            columnNumber = Math.floorDiv(columnNumber, 26);
        }

        return result.reverse().toString();
    }
}
