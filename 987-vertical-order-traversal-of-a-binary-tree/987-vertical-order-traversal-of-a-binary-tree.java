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
    
    private int minLevel = 0;
    private int maxLevel = 0;
    private void findLevel(TreeNode root, int level) {
        if(root == null) return;
        
        findLevel(root.left, level - 1);
        findLevel(root.right, level + 1);
        
        minLevel = Math.min(minLevel, level);
        maxLevel = Math.max(maxLevel, level);
    }
    
    private class Pair implements Comparable<Pair> {
        TreeNode node;
        int level;
        
        Pair() {}
        
        Pair(TreeNode node, int level) {
            this.node = node;
            this.level = level;
        }
        
        @Override
        public int compareTo(Pair o) {
            if (this.level == o.level) return this.node.val - o.node.val;
            return this.level - o.level;
        }
    }
    
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        findLevel(root, 0);
        int width = Math.abs(minLevel) + 1 + Math.abs(maxLevel);
        
        List<List<Integer>> vo = new ArrayList();
        for(int i = 0; i < width; i++) vo.add(new ArrayList());
        
        PriorityQueue<Pair> pQue = new PriorityQueue<>();
                                                       
        pQue.add(new Pair(root, Math.abs(minLevel)));
        while(pQue.isEmpty() == false) {
            int size = pQue.size();
            PriorityQueue<Pair> cQue = new PriorityQueue<>();
            while(size-->0) {
                Pair rp = pQue.poll();
                vo.get(rp.level).add(rp.node.val);
                if(rp.node.left != null) cQue.add(new Pair(rp.node.left, rp.level - 1));
                if(rp.node.right != null) cQue.add(new Pair(rp.node.right, rp.level + 1));
            }
            pQue = cQue;
        }
        
        return vo;
    }
}