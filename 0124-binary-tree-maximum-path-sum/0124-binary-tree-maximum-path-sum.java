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
    class Pair {
        int sum;
        int maxPathSum;
        
        Pair (int sum, int maxPathSum) {
            this.sum = sum;
            this.maxPathSum = maxPathSum;
        }
        
        Pair () {
            this.sum = 0;
            this.maxPathSum = Integer.MIN_VALUE;
        }
    }
    
    public Pair pathSum(TreeNode root) {
        if (root == null) return new Pair();
        
        Pair leftSum = pathSum(root.left);
        Pair rightSum = pathSum(root.right);
        
        int leftPath = Math.max(leftSum.sum, 0);
        int rightPath = Math.max(rightSum.sum, 0);
        int currMaxPathSum = leftPath + root.val + rightPath;
        
        int overallMaxPathSum = Math.max(currMaxPathSum, Math.max(leftSum.maxPathSum, rightSum.maxPathSum));
        Pair rootPair = new Pair(Math.max(leftPath + root.val, rightPath + root.val), overallMaxPathSum);
        return rootPair;
    }
    
    public int maxPathSum(TreeNode root) {
        return pathSum(root).maxPathSum;
    }
}