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
    class Node {
        TreeNode node;
        int calls;
        
        Node(TreeNode node) {
            this.node = node;
            this.calls = 1;
        }
    }
    
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> in = new ArrayList<>();
        
        if (root == null) {
            return in;
        }
        
        Stack<Node> st = new Stack<>();
        st.push(new Node(root));
        
        while (st.size() != 0) {
            Node top = st.peek();
            
            if (top.calls == 1) {
                top.calls = 2;
                
                if (top.node.left != null) {
                    Node left = new Node(top.node.left);
                    st.push(left);
                }
            } else if (top.calls == 2) {
                in.add(top.node.val);
                top.calls = 3;
                
                if (top.node.right != null) {
                    Node right = new Node(top.node.right);
                    st.push(right);
                }
            } else {
                st.pop();
            }
        }
        
        return in;
    }
}