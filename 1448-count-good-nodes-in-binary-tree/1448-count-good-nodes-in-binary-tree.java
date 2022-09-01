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
    public int goodNodes;
    
    public void findGoodNodes(TreeNode root, int maxValueInPath) {
        if(root == null) return;
        
        if(maxValueInPath <= root.val) goodNodes++;
        
        findGoodNodes(root.left, Math.max(maxValueInPath, root.val));
        findGoodNodes(root.right, Math.max(maxValueInPath, root.val));
    }
    
    public int goodNodes(TreeNode root) {
        goodNodes = 0;
        findGoodNodes(root, Integer.MIN_VALUE);
        return goodNodes;
    }
}