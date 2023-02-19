/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        
        if (root == p ) return p;
        if (root == q) return q;
        
        TreeNode filc = lowestCommonAncestor (root.left, p, q);
        TreeNode firc = lowestCommonAncestor (root.right, p, q);
        
        if (filc != null && firc != null) return root; 
        if (filc != null) return filc;
        if (firc != null) return firc;
        
        return null;
    }
}