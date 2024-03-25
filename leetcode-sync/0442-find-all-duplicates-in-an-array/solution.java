// import java.util.ArrayList;
// import java.util.HashSet;
// import java.util.List;
// import java.util.Set;

class Solution {
    // public List<Integer> v1(int[] nums) {
    //     // Hashmap solution
    //     // Leetcode wants constant space but I don't know a solution to that yet
    //     Set<Integer> alreadyPresent = new HashSet<>();
    //     List<Integer> result = new ArrayList<>();

    //     for (int num : nums) {
    //         if (alreadyPresent.contains(num)) {
    //             result.add(num);
    //             continue;
    //         }

    //         alreadyPresent.add(num);
    //     }

    //     return result;
    // }

    public List<Integer> v2(int[] nums) {
        // O(1) space solution, found on leetcode comments
        List<Integer> result = new ArrayList<>();

        for (int pointer : nums) {
            int val = nums[Math.abs(pointer) - 1];

            if (val < 0) {
                result.add(Math.abs(pointer));
            } else {
                nums[Math.abs(pointer) - 1] = -val;
            }
        }

        return result;
    }

    public List<Integer> findDuplicates(int[] nums) {
        return v2(nums);
    }
}
