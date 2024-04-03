class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int left = 0;
        int right = (matrix.length * matrix[0].length) - 1;

        while (left <= right) {
            int middle = left + Math.floorDiv(right - left, 2);
            int middleVal = matrix[Math.floorDiv(middle, matrix[0].length)][middle % matrix[0].length];

            if (middleVal == target){
                return true;
            }

            if (middleVal > target) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }

        return false;
    }
}
