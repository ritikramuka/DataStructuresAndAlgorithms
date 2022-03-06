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
    class Robbery {
        int withoutRobbery = 0;
        int withRobbery = 0;
    }
    
    public Robbery rob_(TreeNode root) {
        if(root == null) 
            return new Robbery();
        
        Robbery left = rob_(root.left);
        Robbery right = rob_(root.right);
        
        Robbery myans = new Robbery();
        myans.withRobbery = root.val + left.withoutRobbery + right.withoutRobbery;
        myans.withoutRobbery = Math.max(left.withoutRobbery, left.withRobbery) + Math.max(right.withoutRobbery, right.withRobbery);
        
        return myans;
    }
    
    public int rob(TreeNode root) {
        Robbery ans = rob_(root);
        return Math.max(ans.withoutRobbery, ans.withRobbery);
    }
}