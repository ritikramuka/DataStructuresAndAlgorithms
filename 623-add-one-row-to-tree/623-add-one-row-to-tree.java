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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(depth == 1) {
            return new TreeNode(val, root, null);
        }
        
        if(depth == 2) {
            TreeNode nl = new TreeNode(val, root.left, null);
            root.left = nl;
            TreeNode nr = new TreeNode(val, null, root.right);
            root.right = nr;
        }
        
        if(root.left != null) {
            addOneRow(root.left, val, depth - 1);
        }
        
        if(root.right != null) {
            addOneRow(root.right, val, depth - 1);
        }
        
        return root;
    }
}