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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lo = new ArrayList<>();
        
        if (root == null) {
            return lo;
        }
        
        Queue<TreeNode> que = new ArrayDeque<>();
        que.add (root);
        
        while (que.size() > 0) {
            List<Integer> level = new ArrayList<>();
            
            int size = que.size();
            while (size-- > 0) {
                TreeNode rnode = que.remove();
                level.add (rnode.val);
                
                if (rnode.left != null) {
                    que.add (rnode.left);
                }
                
                if (rnode.right != null) {
                    que.add (rnode.right);
                }
            }
            
            lo.add (level);
        }
        
        return lo;
    }
}