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
    public List<Integer> rightSideView(TreeNode root) {
       List<Integer> rv = new ArrayList<>();
        
//         if no root, hence return empty List
        if (root == null) {
            return rv;
        }
        
        Queue<TreeNode> que = new ArrayDeque<>();
//         step 1: add root
        que.add(root);
        
//         step 2: do your work till que size is greater than zero
        while (que.size() > 0) {
//             step 3: get curr size of the que
            int size = que.size();
            
//             step 4: remove size amt of fronts from the que and add there chilren, these size amt of people will lie on same level
            while (size > 0) {
                TreeNode rnode = que.remove();
                
//                 size == 1, means removing last node of the currLevel
                if (size == 1) {
                    rv.add(rnode.val);
                }

//              step 5: see if children are there, add them   
                if (rnode.left != null) {
                    que.add(rnode.left);
                }
                if (rnode.right != null) {
                    que.add(rnode.right);
                }
                
                size--;
            }
            
        }
        
        return rv;
    }
}