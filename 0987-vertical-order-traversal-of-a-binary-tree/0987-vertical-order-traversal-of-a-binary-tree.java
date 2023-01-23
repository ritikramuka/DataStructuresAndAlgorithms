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
    int minLevel = 0;
    int maxLevel = 0;
    
    public void verticalLevels (TreeNode root, int level) {
        if (root == null) {
            return;
        }
        
        verticalLevels(root.left, level - 1);
        verticalLevels(root.right, level + 1);
        
        minLevel = Math.min(level, minLevel);
        maxLevel = Math.max(level, maxLevel);
    }
    
    class Pair implements Comparable<Pair> {
        TreeNode node;
        int vLevel;
        
        Pair (TreeNode node, int vLevel) {
            this.node = node;
            this.vLevel = vLevel;
        }
        
        @Override
        public int compareTo(Pair o) {
            if (this.vLevel == o.vLevel) {
                return this.node.val - o.node.val;
            }
            
            return this.vLevel - o.vLevel;
        }
    }
    
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        verticalLevels (root, 0);
        int width = maxLevel - minLevel;
        int numberOfLevels = width + 1;
        
        List<List<Integer>> vo = new ArrayList<>();
        for (int i = 0; i < numberOfLevels; i++) {
            vo.add(new ArrayList<>());
        }
        
        PriorityQueue<Pair> Ppq = new PriorityQueue<>();
        Ppq.add(new Pair(root, -minLevel));
        
        while (Ppq.size() > 0) {
            int size = Ppq.size();
            
            PriorityQueue<Pair> Cpq = new PriorityQueue<>();
            while (size > 0) {
                Pair rpair = Ppq.remove();
                
                vo.get(rpair.vLevel).add(rpair.node.val);
                
                if (rpair.node.left != null) {
                    Cpq.add(new Pair(rpair.node.left, rpair.vLevel - 1));
                }
                
                if (rpair.node.right != null) {
                    Cpq.add(new Pair(rpair.node.right, rpair.vLevel + 1));
                }
                
                size--;
            }
            
            Ppq = Cpq;
        }
        
        return vo;
    }
}