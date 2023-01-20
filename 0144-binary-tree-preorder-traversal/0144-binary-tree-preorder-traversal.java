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
    public void poTraversal (TreeNode root,  List<Integer> ans) {
        if (root == null) return;
        
//         add my self
        ans.add(root.val);
        
//         call for left
        poTraversal (root.left, ans);
        
//         call for right
        poTraversal (root.right, ans);
    }
    
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        
        poTraversal (root, ans);
        
        return ans;
    }
}