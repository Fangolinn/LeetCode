import java.util.*;

class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);

        int maxScore = 0;
        for (int start = 0, end = tokens.length - 1, score = 0; start <= end; maxScore = Math.max(score, maxScore)) {
            if (power >= tokens[start]) {
                score++;
                power -= tokens[start];
                start++;
                continue;
            } 
            
            if (score >= 1) {
                score--;
                power += tokens[end];
                end--;
                continue;
            }

            break;
        }

        return maxScore;
    }
}
