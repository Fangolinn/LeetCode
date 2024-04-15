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
    /* private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    } */

    private int sumNumbers(TreeNode root, String number) {
        if (root == null) {
            return 0;
        }
        
        number = number.concat(Integer.toString(root.val));
        if (root.left == null && root.right == null) {
            // System.out.println("Number: ".concat(number));
            return Integer.valueOf(number);
        } else {
            return sumNumbers(root.left, number) + sumNumbers(root.right, number);
        }
    }

    public int sumNumbers(TreeNode root) {
        return sumNumbers(root, "");
    }
}
