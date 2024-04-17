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
    public String smallestFromLeaf(TreeNode root, String s) {
        s = String.valueOf((char)(root.val + 97)).concat(s);

        if (root.left == null && root.right == null) {
            return s;
        }

        if (root.left == null){
            return smallestFromLeaf(root.right, s);
        } else if (root.right == null){
            return smallestFromLeaf(root.left, s);
        }

        String left = smallestFromLeaf(root.left, s);
        String right = smallestFromLeaf(root.right, s);

        if (left.compareTo(right) <= 0) {
            return left;
        } else {
            return right;
        }
    }

    public String smallestFromLeaf(TreeNode root) {
        return smallestFromLeaf(root, "");
    }
}
