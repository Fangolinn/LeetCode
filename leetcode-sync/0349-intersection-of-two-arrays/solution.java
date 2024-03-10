import java.util.*;

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> nums1Set = new HashSet<>(nums1.length);

        for (int num : nums1){
            nums1Set.add(num);
        }

        Set<Integer> common = new HashSet<>(Math.min(nums1Set.size(), nums2.length));

        for (int num : nums2) {
            if (nums1Set.contains(num)){
                common.add(num);
            }
        }

        int[] result = new int[common.size()];
        int index = 0;
        for (int num : common) {
            result[index++] = num;
        }

        return result;
    }
}
