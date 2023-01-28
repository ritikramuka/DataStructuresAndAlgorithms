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
        int sum;
        int cnt;
        int cntOfNodesFollowingAvg;
        
        Pair () {
            this.sum = 0;
            this.cnt = 0;
            this.cntOfNodesFollowingAvg = 0;
        }
        
        Pair (int sum, int cnt, int cntOfNodesFollowingAvg) {
            this.sum = sum;
            this.cnt = cnt;
            this.cntOfNodesFollowingAvg = cntOfNodesFollowingAvg;
        }
    }
    
    public Pair solve (TreeNode root) {
        if (root == null) {
            return new Pair();
        }
        
        Pair lp = solve (root.left);
        Pair rp = solve (root.right);
        
        int currSum = lp.sum + root.val + rp.sum;
        int currCnt = lp.cnt + 1 + rp.cnt;
        
        int avg = currSum / currCnt;
        
        int cntOfNodesFollowingAvg = lp.cntOfNodesFollowingAvg + rp.cntOfNodesFollowingAvg;
        if (avg == root.val) {
            cntOfNodesFollowingAvg += 1;
        }
        
        return new Pair (currSum, currCnt, cntOfNodesFollowingAvg);
    }
    
    public int averageOfSubtree(TreeNode root) {
       return solve (root).cntOfNodesFollowingAvg;
    }
}