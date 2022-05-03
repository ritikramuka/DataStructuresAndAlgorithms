/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int sum(TreeNode root, int[] tilt) {
        if(root == null) return 0;
        int leftKaSum = sum(root.left, tilt);
        int rightKaSum = sum(root.right, tilt);
        int tiltOfNode = Math.abs(leftKaSum - rightKaSum);
        tilt[0] += tiltOfNode;
        return leftKaSum + root.val + rightKaSum;
    }
    
    public int findTilt(TreeNode root) {
        int[] tilt = new int[1];
        sum(root, tilt);
        return tilt[0];
    }
}