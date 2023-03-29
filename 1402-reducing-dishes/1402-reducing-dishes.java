class Solution {
    public int memo(int[] satisfaction, int idx, int time, int[][] dp) {
        if (idx ==  satisfaction.length) {
            return 0;
        } 
        
        if (dp[idx][time] != -1) {
            return dp[idx][time];
        }
        
        int inc = memo(satisfaction, idx + 1, time + 1, dp) + satisfaction[idx] * time;
        int exc = memo(satisfaction, idx + 1, time, dp);
        
        return dp[idx][time] = Math.max(inc, exc);
    }
    
    public int maxSatisfaction(int[] satisfaction) {
        int n = satisfaction.length;
        
        Arrays.sort(satisfaction);
        
        int[][] dp = new int[n][n + 1];
        for (int[] a : dp) {
            Arrays.fill(a, -1);
        }
        
        return memo(satisfaction, 0, 1, dp);
    }
}