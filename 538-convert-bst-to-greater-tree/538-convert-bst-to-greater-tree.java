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
    int sum = 0;
    public void reverseIN(TreeNode root) {
        if(root == null) return;
        
        reverseIN(root.right);
        sum += root.val;
        root.val = sum;
        reverseIN(root.left);
    }
    
    public TreeNode convertBST(TreeNode root) {
        reverseIN(root);
        return root;
    }
}