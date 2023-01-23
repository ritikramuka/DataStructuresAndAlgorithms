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
        
        int leftPathIncRoot = leftSum.sum + root.val;
        int rightPathIncRoot = rightSum.sum + root.val;
        int leftRightRootPathSum = leftSum.sum + root.val + rightSum.sum;
        int rootVal = root.val;
        int currMaxPathSum = Math.max(Math.max(rootVal, leftRightRootPathSum), Math.max(leftPathIncRoot, rightPathIncRoot));
        
        int overallMaxPathSum = Math.max(currMaxPathSum, Math.max(leftSum.maxPathSum, rightSum.maxPathSum));
        Pair rootPair = new Pair(Math.max(root.val, Math.max(leftPathIncRoot, rightPathIncRoot)), overallMaxPathSum);
        return rootPair;
    }
    
    public int maxPathSum(TreeNode root) {
        return pathSum(root).maxPathSum;
    }
}