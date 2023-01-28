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
    public TreeNode reverseOddLevels(TreeNode root) {
        Queue<TreeNode> que = new ArrayDeque<>();
        que.add (root);
        int level = 0;
        while (que.size() != 0) {
            int size = que.size();
            
            while (size-- > 0) {
                TreeNode rnode = que.remove();
                
                if (rnode.left != null) {
                    que.add (rnode.left);
                }
                
                if (rnode.right != null) {
                    que.add (rnode.right);
                }
            }
            level++;
            
            if (level % 2 == 1) {
                int[] val = new int[que.size()];
                int i = 0;
                for (TreeNode node : que) {
                    val[i++] = node.val;
                } 
                i = que.size() - 1;
                for (TreeNode node : que) {
                    node.val = val[i--];
                }
            }
        }
        
        return root;
    }
}