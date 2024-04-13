import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    private int largestRectangleArea(int[] heights) {
        int ans = 0;
        Deque<Integer> stack = new ArrayDeque<>();
    
        for (int i = 0; i <= heights.length; ++i) {
          while (!stack.isEmpty() && (i == heights.length || heights[stack.peek()] > heights[i])) {
            int h = heights[stack.pop()];
            int w = stack.isEmpty() ? i : i - stack.peek() - 1;
            ans = Math.max(ans, h * w);
          }
          stack.push(i);
        }
    
        return ans;
      }

    public int maximalRectangle(char[][] matrix) {
        int[] histogram = new int[matrix[0].length];
        int maxArea = 0;

        for (char[] row : matrix){
            for (int i = 0; i < row.length; i++) {
                if (row[i] == '1') {
                    histogram[i]++;
                } else {
                    histogram[i] = 0;
                }
            }

            maxArea = Math.max(largestRectangleArea(histogram), maxArea);
        }
        
        return maxArea;
    }

}
