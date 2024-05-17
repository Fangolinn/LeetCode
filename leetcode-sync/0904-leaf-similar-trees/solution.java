import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    // public class TreeNode {
    //     int val;
    //     TreeNode left;
    //     TreeNode right;

    //     TreeNode() {
    //     }

    //     TreeNode(int val) {
    //         this.val = val;
    //     }

    //     TreeNode(int val, TreeNode left, TreeNode right) {
    //         this.val = val;
    //         this.left = left;
    //         this.right = right;
    //     }
    // }

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        return leafSequence(root1).equals(leafSequence(root2));
    }

    private List<Integer> leafSequence(TreeNode root) {
        if (root == null)
            return new ArrayList<>();
        
        if (root.left == null && root.right == null) {
            List<Integer> result = new ArrayList<>();
            result.add(root.val);
            return result;
        }

        List<Integer> result = leafSequence(root.left);
        result.addAll(leafSequence(root.right));
        return result;
    }
}
