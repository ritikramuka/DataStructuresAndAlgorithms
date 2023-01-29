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
    public TreeNode LCA (TreeNode root, int p, int q) {
        if (root == null) {
            return root;
        }
        
        if (root.val == p || root.val == q) {
            return root;
        }
        
        TreeNode LCA_left = LCA (root.left, p, q);
        TreeNode LCA_right = LCA (root.right, p, q);
        
        if (LCA_left != null && LCA_right != null) {
            return root;
        } else if (LCA_left != null) {
            return LCA_left;
        } else if (LCA_right != null) {
            return LCA_right;
        } else {
            return null;
        }
    }
    
    public boolean getPath (TreeNode root, int dest, StringBuilder path) {
        if (root == null) {
            return false;
        }
        
        if (root.val == dest) {
            return true;
        }
        
        path.append("L");
        if (getPath (root.left, dest, path) == true) {
            return true;
        }
        path.deleteCharAt(path.length() - 1);
        
        path.append("R");
        if (getPath (root.right, dest, path) == true) {
            return true;
        }
        path.deleteCharAt(path.length() - 1);
        
        return false;
    }
    
    public String getDirections(TreeNode root, int startValue, int destValue) {
        TreeNode lca = LCA (root, startValue, destValue);
        
        StringBuilder lcaToStart = new StringBuilder();
        StringBuilder lcaToDest = new StringBuilder();
        
        getPath (lca, startValue, lcaToStart);
        getPath (lca, destValue, lcaToDest);
        
        for (int i = 0; i < lcaToStart.length(); i++) {
            lcaToStart.setCharAt(i, 'U');
        }
        
        lcaToStart.append(lcaToDest);
        return lcaToStart.toString();
    }
}