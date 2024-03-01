import java.util.HashSet;

class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> numsSet = new HashSet<>();

        // for (int num : nums) {
        //     numsSet.add(num);
        // }

        // return nums.length != numsSet.size();

        for (int num : nums) {
            if (numsSet.contains(num)) {
                return true;
            }

            numsSet.add(num);
        }

        return false;
    }
}
