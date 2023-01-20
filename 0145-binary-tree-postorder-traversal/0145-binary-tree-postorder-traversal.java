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
    public void postTraversal (TreeNode root, List<Integer> ans) {
        if (root == null) {
            return;
        }
        
//         call left subtree
        postTraversal(root.left, ans);
        
//         call right subtree
        postTraversal(root.right, ans);
        
//         add myself
        ans.add(root.val);
    } 
    
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        postTraversal (root, ans);
        
        return ans;
    }
}