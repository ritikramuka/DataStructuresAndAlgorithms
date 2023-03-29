class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        int n = satisfaction.length;
        
        Arrays.sort(satisfaction);
        
        int[][] dp = new int[n + 1][n + 2];
        
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n; j >= 1; j--) {
                dp[i][j] = Math.max(dp[i + 1][j + 1] + satisfaction[i] * j, dp[i + 1][j]);
            }
        }
        
        return dp[0][1];
    }
}