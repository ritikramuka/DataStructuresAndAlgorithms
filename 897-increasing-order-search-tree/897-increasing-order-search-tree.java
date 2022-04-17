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
    public TreeNode ans;
    public void in(TreeNode root) {
        if(root == null) return;
        in(root.left);
        ans.right = root;
        ans.right.left = null;
        ans = ans.right;
        in(root.right);
    }
    public TreeNode increasingBST(TreeNode root) {
        ans = new TreeNode(-1);
        TreeNode nroot = ans;
        in(root);
        return nroot.right;
    }
}