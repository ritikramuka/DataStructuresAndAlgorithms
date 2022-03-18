class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int prev2 = cost[0], prev1 = cost[1];
        for(int i = 2; i < n; i++) {
            int curr = Math.min(prev1, prev2) + cost[i];
            prev2 = prev1;
            prev1 = curr;
        }
        
        return Math.min(prev1, prev2);
    }
}