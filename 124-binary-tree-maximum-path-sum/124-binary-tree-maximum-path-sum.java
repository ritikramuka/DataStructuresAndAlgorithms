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
    static int maxPathSum;
    
    public int pathSum(TreeNode root) {
        if(root == null) {
            return 0;
        }
        
        int pathFromLeft = pathSum(root.left);
        int pathFromRight = pathSum(root.right);
        int pathFromLeftIncludingRoot = pathFromLeft + root.val;
        int pathFromRightIncludingRoot = pathFromRight + root.val;
        int bestIncludingRoot = Math.max(pathFromRightIncludingRoot, pathFromLeftIncludingRoot);
        int allPath = pathFromLeft + pathFromRight + root.val;
        maxPathSum = Math.max(maxPathSum, Math.max(root.val, Math.max(allPath, Math.max(pathFromRightIncludingRoot, pathFromLeftIncludingRoot))));
        
        return Math.max(root.val, Math.max(pathFromLeftIncludingRoot, pathFromRightIncludingRoot));
    }
    
    public int maxPathSum(TreeNode root) {
        maxPathSum = Integer.MIN_VALUE;
        pathSum(root);
        return maxPathSum;
    }
}