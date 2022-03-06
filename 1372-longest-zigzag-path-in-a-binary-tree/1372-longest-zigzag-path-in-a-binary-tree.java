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
    class ZigZag {
        // fs -> forward Slash '/'
        int fs = -1;
        // bs -> backward Slash '\'
        int bs = -1;
        // max -> max zigzag overall in subtree
        int max = 0;
    }
    
    public ZigZag lzz(TreeNode root) {
        if(root == null)
            return new ZigZag();
        
        ZigZag left = lzz(root.left);
        ZigZag right = lzz(root.right);
        
        ZigZag ans = new ZigZag();
        ans.fs = left.bs + 1;
        ans.bs = right.fs + 1;
        ans.max = Math.max(ans.fs, Math.max(ans.bs, Math.max(left.max, right.max)));
        
        return ans;
    }
    
    public int longestZigZag(TreeNode root) {
        return lzz(root).max;
    }
}