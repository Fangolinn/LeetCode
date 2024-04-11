import java.util.ArrayDeque;

class Solution {
    public String v1(String num, int k) {
        // Probably could be cleanup up quite a bit
        if (k == num.length()) {
            return "0";
        }

        int removed = 0;
        StringBuilder numSB = new StringBuilder(num);
        int lastRemovalAt = 0;

        while (removed < k) {
            boolean wasRemoved = false;
            for (int i = Math.max(lastRemovalAt - 1, 0); i < numSB.length() - 1; i++) {
                if (numSB.charAt(i) > numSB.charAt(i + 1)) {
                    numSB.deleteCharAt(i);
                    lastRemovalAt = i;
                    wasRemoved = true;
                    break;
                }
            }

            if (!wasRemoved) {
                numSB.deleteCharAt(numSB.length() - 1);
                lastRemovalAt = numSB.length();
            }

            removed++;
        }

        while (true) {
            if (numSB.length() > 0 && numSB.charAt(0) == '0') {
                numSB.deleteCharAt(0);
            } else {
                break;
            }
        }

        if (numSB.length() == 0) {
            numSB.append('0');
        }

        return numSB.toString();
    }

    public String v2(String num, int k) {
        // Solution found on leetcode
        ArrayDeque<Character> numStack = new ArrayDeque<>();

        for (char digit : num.toCharArray()) {
            while (k > 0 && !numStack.isEmpty() && digit < numStack.peekLast()) {
                numStack.pollLast();
                k--;
            }

            numStack.offer(digit);
        }

        while (k > 0) {
            numStack.pollLast();
            k--;
        }

        StringBuilder result = new StringBuilder();

        while (!numStack.isEmpty())
            result.append(numStack.pop());

        while (true) {
            if (result.length() > 0 && result.charAt(0) == '0') {
                result.deleteCharAt(0);
            } else {
                break;
            }
        }

        if (result.length() == 0)
            result.append('0');

        return result.toString();
    }

    public String removeKdigits(String num, int k) {
        return v2(num, k);
    }
}
