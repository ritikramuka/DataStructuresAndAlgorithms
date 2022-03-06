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
    public int findDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        
        int left = findDepth(root.left);
        int right = findDepth(root.right);
        
        return Math.max(left, right) + 1;
    }
    
    public TreeNode helper(TreeNode root, int curr, int depth) {
        if(root == null)
            return null;
        
        if(depth == curr) {
            return root;
        }
        
        TreeNode left = helper(root.left, curr + 1, depth);
        TreeNode right = helper(root.right, curr + 1, depth);
        
        if(left != null && right != null)
            return root;
            
        return left == null ? right : left;
    }
    
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        int depth = findDepth(root) - 1;
        return helper(root, 0, depth);
    }
}