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
            this.calls = 0;
        }
    }
    
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> post = new ArrayList<>();
        
        if (root == null) {
            return post;
        }
        
        Stack<Node> st = new Stack<>();
        st.push(new Node(root));
        
        while (st.size() != 0) {
            Node top = st.peek();
            
            if (top.calls < 1 && top.node.left != null) {
                Node left = new Node(top.node.left);
                top.calls = 1;
                st.push(left);
            } else if (top.calls < 2 && top.node.right != null) {
                Node right = new Node(top.node.right);
                top.calls = 2;
                st.push(right);
            } else {
                post.add(top.node.val);
                st.pop();
            }
        }
        
        return post;
    }
}