/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        HashMap<TreeNode, TreeNode> parent = new HashMap<>();
        findParent(root, parent);
        
        Queue<TreeNode> que = new ArrayDeque<>();
        que.add(target);
        
        HashSet<TreeNode> vis = new HashSet<>();
        vis.add(target);
        
        List<Integer> ans = new ArrayList<>();
        
        while (que.size() != 0) {
            int size = que.size();
            
            if (k == 0) {
                while (que.size() != 0) {
                    ans.add(que.remove().val);
                }
                break;
            }
            
            while (size--> 0) {
                TreeNode rnode = que.remove();
                
                if (rnode.left != null && vis.contains(rnode.left) == false) {
                    que.add(rnode.left);
                    vis.add(rnode.left);
                }
                
                if (rnode.right != null && vis.contains(rnode.right) == false) {
                    que.add(rnode.right);
                    vis.add(rnode.right);
                }
                
                if (parent.getOrDefault(rnode, null) != null && vis.contains(parent.get(rnode)) == false) {
                    que.add(parent.get(rnode));
                    vis.add(parent.get(rnode));
                }
            }
            k--;
        }
        
        return ans;
    }
    
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
}