import java.util.HashSet;
import java.util.ArrayDeque;

class Solution {
    private int turn(int state, int wheel, int amount) {
        int[] stateArr = new int[4];

        for (int i = 3; i >= 0; i--) {
            stateArr[i] = state % 10;
            state /= 10;
        }

        if (stateArr[wheel] == 9 && amount == 1) {
            stateArr[wheel] = 0;
        } else if (stateArr[wheel] == 0 && amount == -1) {
            stateArr[wheel] = 9;
        } else {
            stateArr[wheel] += amount;
        }

        int result = 0;
        for (int i = 0; i < stateArr.length; i++) {
            result = result * 10 + stateArr[i];
        }
        return result;
    }

    public int openLock(String[] deadends, String target) {
        HashSet<Integer> deadendsSet = new HashSet<>();
        for (String end : deadends) {
            deadendsSet.add(Integer.parseInt(end));
        }

        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] { 0000, 0 });

        int targetInt = Integer.parseInt(target);

        while (!queue.isEmpty()) {
            int[] state = queue.poll();

            if (deadendsSet.contains(state[0])) {
                continue;
            }

            if (state[0] == targetInt) {
                return state[1];
            }

            deadendsSet.add(state[0]);

            for (int i = 0; i < 4; i++) {
                int newState = turn(state[0], i, 1);

                if (!deadendsSet.contains(newState)) {
                    queue.add(new int[] { newState, state[1] + 1 });
                }
            }

            for (int i = 0; i < 4; i++) {
                int newState = turn(state[0], i, -1);

                if (!deadendsSet.contains(newState)) {
                    queue.add(new int[] { newState, state[1] + 1 });
                }
            }
        }

        return -1;
    }
}
