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
    public void findParent(TreeNode root, HashMap<TreeNode, TreeNode> parent) {
        if (root == null) {
            return;
        }
        
        if (root.left != null) {
            parent.put(root.left, root);
        }
        
        if (root.right != null) {
            parent.put(root.right, root);
        }
        
        findParent(root.left, parent);
        findParent(root.right, parent);
    }
    
    public TreeNode find(TreeNode root, int target) {
        if (root == null) {
            return null;
        }
        
        if (root.val == target) {
            return root;
        }
        
        TreeNode filc = find(root.left, target);
        if (filc != null) {
            return filc;
        }
        
        TreeNode firc = find(root.right, target);
        if (firc != null) {
            return firc;
        }
        
        return null;
    }
    
    public int amountOfTime(TreeNode root, int start) {
        HashMap<TreeNode, TreeNode> parent = new HashMap<>();
        findParent(root, parent);
        
        TreeNode startNode = find(root, start);
        
        Queue<TreeNode> que = new ArrayDeque<>();
        que.add(startNode);
        
        HashSet<TreeNode> infected = new HashSet<>();
        infected.add(startNode);
        
        int time = -1;
        
        while (que.size() > 0) {
            int size = que.size();
            while (size-->0) {
                TreeNode rnode = que.remove();
                
                if (rnode.left != null && infected.contains(rnode.left) == false) {
                    que.add(rnode.left);
                    infected.add(rnode.left);
                }
                
                if (rnode.right != null && infected.contains(rnode.right) == false) {
                    que.add(rnode.right);
                    infected.add(rnode.right);
                }
                
                if (parent.get(rnode) != null && infected.contains(parent.get(rnode)) == false) {
                    que.add(parent.get(rnode));
                    infected.add(parent.get(rnode));
                }
            }
            time++;
        }
        
        return time;
    }
}