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
    StringBuilder ans;
    public void help(TreeNode root) {
        if(root == null) {
            return;
        }
        
        ans.append(root.val);
        
        if(root.left != null) {
            ans.append('(');
            help(root.left);
            ans.append(')');
        } else if(root.right != null) {
            ans.append('(');
            ans.append(')');
        }
        
        if(root.right != null) {
            ans.append('(');
            help(root.right);
            ans.append(')');
        }
    }
    public String tree2str(TreeNode root) {
        ans = new StringBuilder();
        help(root);
        return ans.toString();
    }
}