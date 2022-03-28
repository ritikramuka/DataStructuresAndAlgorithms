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
    public TreeNode construct(int[] arr, int lo, int hi) {
        if(lo > hi) 
            return null;
        
        int mid = lo + (hi - lo) / 2;
        TreeNode node = new TreeNode(arr[mid]);
        
        node.left = construct(arr, lo, mid - 1);
        node.right = construct(arr, mid + 1, hi);
        
        return node;
    }
    
    public TreeNode sortedArrayToBST(int[] nums) {
        return construct(nums, 0, nums.length - 1);
    }
}