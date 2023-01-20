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
    public void postorderTraversal_ (TreeNode root, List<Integer> post) {
        if (root == null) {
            return;
        }
        
        postorderTraversal_ (root.left, post);
        
        postorderTraversal_ (root.right, post);
        
        post.add (root.val);
        
        return;
    }
    
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> post = new ArrayList<>();
        postorderTraversal_ (root, post);
        return post;
    }
}