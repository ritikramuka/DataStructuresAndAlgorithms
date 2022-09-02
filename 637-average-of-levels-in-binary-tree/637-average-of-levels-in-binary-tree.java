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
        List<Double> avgPerLevel = new ArrayList<>();
        
        Queue<TreeNode> que = new LinkedList<TreeNode>();
        que.add(root);
        while(que.isEmpty() == false) {
            int sizeOfLevel = que.size();
            double levelSum = 0;
            int size = sizeOfLevel;
            while(size-- > 0) {
                TreeNode rnode = que.poll();
                levelSum += rnode.val;
                if(rnode.left != null) que.add(rnode.left);
                if(rnode.right != null) que.add(rnode.right);
            }
            avgPerLevel.add(levelSum / sizeOfLevel);
        }
        
        return avgPerLevel;
    }
}