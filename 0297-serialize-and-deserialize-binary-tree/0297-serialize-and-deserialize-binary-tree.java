/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    
    public void serialize(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("null,");
            return;
        }
        
        sb.append(root.val + ",");
        serialize(root.left, sb);
        serialize(root.right, sb);
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }
    
    int idx = 0;
    
    public TreeNode constructTree(String[] pre) {
        String data = pre[idx];
        idx++;
        
        if (idx == pre.length || data.equals("null")) {
            return null;
        }
        
        int val = Integer.parseInt(data);
        TreeNode root = new TreeNode(val);
        
        root.left = constructTree(pre);
        root.right = constructTree(pre);
        
        return root;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] pre = data.split(",");
        idx = 0;
        return constructTree(pre);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));