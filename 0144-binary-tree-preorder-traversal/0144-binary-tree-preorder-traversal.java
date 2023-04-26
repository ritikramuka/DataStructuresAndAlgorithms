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
    public void preOrder(TreeNode root, List<Integer> pre) {
        // base case
        if (root == null) {
            return;
        }
        
        // store root value
        pre.add(root.val);
        
        // call left subtree
        preOrder(root.left, pre);
        
        // call right subtree
        preOrder(root.right, pre);
    }
    
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> pre = new ArrayList<>();
        preOrder(root, pre);
        return pre;
    }
}