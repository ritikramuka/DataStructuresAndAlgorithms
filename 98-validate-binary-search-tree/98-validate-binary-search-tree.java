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
    public class Pair {
        boolean isBST = true;
        Integer min = null;
        Integer max = null;
    }
    
    public Pair isBST(TreeNode root) {
        if(root == null) {
            return new Pair();
        }
        
        Pair lp = isBST(root.left);
        Pair rp = isBST(root.right);
        
        Pair mp = new Pair();
        if(lp.isBST == true && rp.isBST == true) {
            if((lp.max == null || (lp.max != null && lp.max < root.val)) && (rp.min == null || (rp.min != null && rp.min > root.val))) {
                mp.isBST = true;    
            } else {
                mp.isBST = false;
            }
        } else {
            mp.isBST = false;
        }
        
        if(lp.min != null) {
            mp.min = Math.min(root.val, lp.min);
        } else {
            mp.min = root.val;
        }
        
        if(rp.max != null) {
            mp.max = Math.max(root.val, rp.max);
        } else {
            mp.max = root.val;
        }
        
        return mp;
    }
    
    public boolean isValidBST(TreeNode root) {
        Pair ans = isBST(root);
        return ans.isBST;
    }
}