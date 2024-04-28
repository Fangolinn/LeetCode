import java.util.Stack;

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();

        int[] waitTime = new int[temperatures.length];

        for (int i = 0; i < waitTime.length; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]){
                int stackI = stack.pop();
                waitTime[stackI] = i - stackI;
            }
            
            stack.push(i);
        }

        return waitTime;
    }
}
