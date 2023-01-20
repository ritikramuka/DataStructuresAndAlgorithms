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
    public void preorderTraversal_ (TreeNode root, List<Integer> pre) {
        if (root == null) {
            return;
        }
        
        pre.add (root.val);
        
        preorderTraversal_ (root.left, pre);
        
        preorderTraversal_ (root.right, pre);
        
        return;
    }
    
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> pre = new ArrayList<>();
        preorderTraversal_ (root, pre);
        return pre;
    }
}