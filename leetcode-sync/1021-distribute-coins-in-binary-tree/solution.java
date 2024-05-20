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

    int moves = 0;

    public int distributeCoins(TreeNode root) {
        amountNeeded(root);

        return moves;
    }

    private int amountNeeded(TreeNode root){
        if (root == null) return 0;

        int coinsToMove = amountNeeded(root.left) + amountNeeded(root.right) + root.val - 1;
        moves += Math.abs(coinsToMove);

        return coinsToMove;
    }
}
