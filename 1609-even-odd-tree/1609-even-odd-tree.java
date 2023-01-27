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
    public boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> que = new ArrayDeque<>();
        que.add(root);
        
        int level = 0;
        while (que.size() != 0) {
            int size = que.size();
            
            int prevEle;
            if (level % 2 == 0) {
                prevEle = Integer.MIN_VALUE;
            } else {
                prevEle = Integer.MAX_VALUE;
            }
            
            while (size-->0) {
                TreeNode rnode = que.remove();
                
                if (level % 2 == 0) {
                    if (rnode.val % 2 == 0) {
                        return false;
                    }
                    
                    if (rnode.val <= prevEle) {
                        return false;
                    }
                    
                    prevEle = rnode.val;
                } else {
                    if (rnode.val % 2 == 1) {
                        return false;
                    }
                    
                    if (rnode.val >= prevEle) {
                        return false;
                    }
                    
                    prevEle = rnode.val;
                }
                
                if (rnode.left != null) {
                    que.add(rnode.left);
                }
                
                if (rnode.right != null) {
                    que.add(rnode.right);
                }
            }
            
            level++;
        }
        
        return true;
    }
}