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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> rv = new ArrayList<>();
        
        if (root == null) {
            return rv;
        }
        
        Queue<TreeNode> que = new ArrayDeque<>();
        que.add (root);
        
        while (que.size() > 0) {
            int size = que.size();
            while (size > 0) {
                TreeNode rnode = que.remove();
                
                if (size == 1) {
                    rv.add (rnode.val);
                }
                
                if (rnode.left != null) {
                    que.add (rnode.left);
                }
                
                if (rnode.right != null) {
                    que.add (rnode.right);
                }
                
                size--;
            }
        }
        
        return rv;
    }
}