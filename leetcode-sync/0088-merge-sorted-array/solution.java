import java.util.*;

class Solution {
    private void v1(int[] nums1, int m, int[] nums2, int n) {
        // Bruteforce solution, merge arrays and then sort.

        for (int i = m; i < m + n; i++) {
            nums1[i] = nums2[i - m];
        }

        Arrays.sort(nums1);
    }

    private void v2(int[] nums1, int m, int[] nums2, int n) {
        // Sort into third array, then rewrite nums1
        // Beats 100% somehow lol
        int[] numsMerged = new int[n + m];

        int i = 0;
        int im = 0;
        int in = 0;
        while (im < m && in < n) {
            if (nums1[im] < nums2[in]) {
                numsMerged[i] = nums1[im];
                im++;
            } else {
                numsMerged[i] = nums2[in];
                in++;
            }
            i++;
        }

        for(;im < m; im++, i++){
            numsMerged[i] = nums1[im];
        }

        for(;in < n; in++, i++){
            numsMerged[i] = nums2[in];
        }

        for (i = 0; i < m + n; i++){
            nums1[i] = numsMerged[i];
        }
    }

    private void v3(int[] nums1, int m, int[] nums2, int n) {
        // Use queue to put away elements which need to be pushed back, grab them when needed?
        // FIXME Doesn't work atm, I moved to another solution
        if (n == 0){
            return;
        }
        
        Queue<Integer> pushedBack = new ArrayDeque<>();

        for (int i = 0, in = 0; i < n + m; i++){
            if (!pushedBack.isEmpty() && pushedBack.peek() < nums2[in]){
                pushedBack.add(nums1[i]);
                nums1[i] = pushedBack.poll();
                continue;
            }
            
            if (nums1[i] <= nums2[in]){
                continue;
            }

            if (nums1[i] > nums2[in]){
                pushedBack.add(nums1[i]);
                nums1[i] = nums2[in];
                in++;
            }
        }
    }

    private void v4(int[] nums1, int m, int[] nums2, int n) {
        // Go backwards? Proposed by leetcode people
        // When I think about it it makes sense, no need to push items back like when going from the front

        int i = (m + n) - 1;
        m--;
        n--;
        while (m >= 0 && n >= 0){
            if (nums1[m] > nums2[n]){
                nums1[i--] = nums1[m--];
            } else {
                nums1[i--] = nums2[n--];
            }
        }
        
        while (i >= 0 && n >= 0){
            nums1[i--] = nums2[n--];
        }
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        v4(nums1, m, nums2, n);
    }
}
