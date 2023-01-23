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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> zigzag = new ArrayList<>();
        
//         if no root, hence return empty List
        if (root == null) {
            return zigzag;
        }
        
        Queue<TreeNode> que = new ArrayDeque<>();
//         step 1: add root
        que.add(root);
        int level = 0;
        
//         step 2: do your work till que size is greater than zero
        while (que.size() > 0) {
//             step 3: get curr size of the que
            int size = que.size();
            List<Integer> currLevel = new ArrayList<>();
            
//             step 4: remove size amt of fronts from the que and add there chilren, these size amt of people will lie on same level
            while (size > 0) {
                TreeNode rnode = que.remove();
                currLevel.add(rnode.val);

//              step 5: see if children are there, add them   
                if (rnode.left != null) {
                    que.add(rnode.left);
                }
                if (rnode.right != null) {
                    que.add(rnode.right);
                }
                
                size--;
            }
            
            if(level % 2 == 0) {
                zigzag.add(currLevel);
            } else {
                Collections.reverse(currLevel);
                zigzag.add(currLevel);
            }
            
            
            level++;
        }
        
        return zigzag;
    }
}