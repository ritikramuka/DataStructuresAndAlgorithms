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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList();
        if(root == null)
            return ans;
        
        Queue<TreeNode> que = new ArrayDeque();
        que.add(root);
        boolean leftToRight = true;
        
        while(que.size() != 0) {
            int size = que.size();
            List<Integer> currLevel = new ArrayList<>();
            for(int i = 0; i < size; i++) {
                TreeNode rnode = que.remove();
                currLevel.add(rnode.val);
                if(rnode.left != null) {
                    que.add(rnode.left);
                } 
                if(rnode.right != null) {
                    que.add(rnode.right);
                }
            }
            if(leftToRight == false) {
                Collections.reverse(currLevel);
            }
            leftToRight = !leftToRight;
            ans.add(currLevel);
        }
        
        return ans;
    }
}