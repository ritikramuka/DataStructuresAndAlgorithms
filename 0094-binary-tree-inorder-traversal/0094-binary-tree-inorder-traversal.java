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
    class Pair {
        TreeNode node;
        int call;
        
        Pair(TreeNode node) {
            this.node = node;
            this.call = 1;
        }
    }
    
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> in = new ArrayList<>();
        
        if (root == null) {
            return in;
        }
        
        Stack<Pair> callStack = new Stack<>();
        callStack.push(new Pair(root));
        
        while (callStack.size() != 0) {
            Pair rpair = callStack.peek();
            
            if (rpair.call == 1) {
                // call my left side   
                if (rpair.node.left != null) {
                    TreeNode leftNode = rpair.node.left;
                    callStack.push(new Pair(leftNode));
                }
                
                rpair.call = 2;
            } else if (rpair.call == 2) {  
                in.add(rpair.node.val);
                
                // call my right side 
                if (rpair.node.right != null) {
                    TreeNode rightNode = rpair.node.right;
                    callStack.push(new Pair(rightNode));
                }
                
                rpair.call = 3;
            } else {
                callStack.pop();
            }
        }
        
        return in;
    }
}