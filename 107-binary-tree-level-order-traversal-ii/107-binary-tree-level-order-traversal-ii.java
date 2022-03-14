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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans = new ArrayList();
        if(root == null)
            return ans;
        
        Queue<TreeNode> que = new ArrayDeque();
        que.add(root);
        
        while(que.size() != 0) {
            int size = que.size();
            List<Integer> currLevel = new ArrayList();
            while(size-->0) {
                TreeNode rnode = que.remove();
                currLevel.add(rnode.val);
                if(rnode.left != null) {
                    que.add(rnode.left);
                } 
                if(rnode.right != null) {
                    que.add(rnode.right);
                }
            }
            ans.add(currLevel);
        }
        Collections.reverse(ans);
        return ans;
    }
}