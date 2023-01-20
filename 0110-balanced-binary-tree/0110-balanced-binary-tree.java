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
    class bNode {
        int height;
        boolean isBalanced;
        
        bNode () {
            this.height = 0;
            this.isBalanced = true;
        }
        
        bNode (int height, boolean isBalanced) {
            this.height = height;
            this.isBalanced = isBalanced;
        }
    }
    
    public bNode isBalanced_ (TreeNode root) {
        if (root == null) {
            return new bNode ();
        }
        
        bNode left = isBalanced_ (root.left);
        bNode right = isBalanced_ (root.right);
        
        if (left.isBalanced == false || right.isBalanced == false || Math.abs(left.height - right.height) > 1) {
            return new bNode (Math.max(left.height, right.height) + 1, false);
        } else {
            return new bNode (Math.max(left.height, right.height) + 1, true);
        }
    }
    
    public boolean isBalanced (TreeNode root) {
        return isBalanced_ (root).isBalanced;
    }
}