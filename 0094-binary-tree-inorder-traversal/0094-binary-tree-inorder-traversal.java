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
    public void inorderTraversal_ (TreeNode root, List<Integer> in) {
        if (root == null) {
            return;
        }
        
        inorderTraversal_ (root.left, in);
        
        in.add (root.val);
        
        inorderTraversal_ (root.right, in);
        
        return;
    }
    
    public List<Integer> inorderTraversal (TreeNode root) {
        List<Integer> in = new ArrayList<>();
        inorderTraversal_ (root, in);
        return in;
    }
}