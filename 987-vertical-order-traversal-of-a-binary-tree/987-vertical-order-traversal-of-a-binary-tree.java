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
    
    private int leftMin = Integer.MAX_VALUE;
    private int rightMax = Integer.MIN_VALUE;
    private void findWidth(TreeNode root, int left, int right) {
        if(root == null) return;
        
        findWidth(root.left, left - 1, right - 1);
        findWidth(root.right, left + 1, right + 1);
        
        leftMin = Math.min(leftMin, left);
        rightMax = Math.max(rightMax, right);
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
        findWidth(root, 0, 0);
        int width = rightMax - leftMin + 1;
        
        List<List<Integer>> vo = new ArrayList<>();
        for(int i = 0; i < width; i++) vo.add(new ArrayList<>());
        
        PriorityQueue<Pair> pQue = new PriorityQueue<>();
        PriorityQueue<Pair> cQue = new PriorityQueue<>();
        pQue.add(new Pair(root, -leftMin));
       
        while(pQue.size() != 0) {    
            int size = pQue.size();
            while(size-->0) {
                Pair rp = pQue.poll();
                vo.get(rp.level).add(rp.node.val);
                
                if(rp.node.left != null) {
                    cQue.add(new Pair(rp.node.left, rp.level - 1));
                }
                
                if(rp.node.right != null) {
                    cQue.add(new Pair(rp.node.right, rp.level + 1));
                }
            }
            
            PriorityQueue<Pair> temp = cQue;
            cQue = new PriorityQueue<>();
            pQue = temp;
        }
        
        return vo;
    }
}