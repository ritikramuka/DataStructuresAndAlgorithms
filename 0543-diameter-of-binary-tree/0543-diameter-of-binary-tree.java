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
    class Pair {
        int height;
        int diameter;
        
        Pair () {
            this.height = 0;
            this.diameter = 0;
        }
        
        Pair (int height, int diameter) {
            this.height = height;
            this.diameter = diameter;
        }
    }
    
    public Pair findDiameterPair (TreeNode root) {
        if (root == null) {
            return new Pair ();
        }
        
        Pair left = findDiameterPair (root.left);
        Pair right = findDiameterPair (root.right);
        
        int diameter = Math.max(Math.max(left.diameter, right.diameter), left.height + right.height);
        int height = Math.max (left.height, right.height) + 1;
        
        return new Pair (height, diameter);
    }
    
    public int diameterOfBinaryTree (TreeNode root) {
        return findDiameterPair (root).diameter;
    }
}