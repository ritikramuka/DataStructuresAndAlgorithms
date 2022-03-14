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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ans = new ArrayList();
        if(root == null)
            return ans;
        
        Queue<TreeNode> que = new ArrayDeque();
        que.add(root);
        
        while(que.size() != 0) {
            int size = que.size();
            int div = size;
            double sum = 0;
            while(size-->0) {
                TreeNode rnode = que.remove();
                sum += rnode.val;
                if(rnode.left != null) {
                    que.add(rnode.left);
                } 
                if(rnode.right != null) {
                    que.add(rnode.right);
                }
            }
            sum = sum / div;
            ans.add(sum);
        }
        
        return ans;
    }
}