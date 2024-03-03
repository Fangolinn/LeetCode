import java.util.*;

class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numsSet = new HashSet<>();
        for (int num : nums) {
            numsSet.add(num);
        }

        int longestSequence = 0;
        Iterator<Integer> numsIterator = numsSet.iterator();

        while (numsIterator.hasNext()) {
            int num = numsIterator.next();
            if (!numsSet.contains(num - 1)) { // If num is the start of a sequence
                int currentSequence = 0;
                do {
                    currentSequence++;
                    num++;
                } 
                while (numsSet.contains(num));
                longestSequence = Math.max(longestSequence, currentSequence);
            }
        }

        return longestSequence;
    }
}
