class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];
        for(int i = 0; i < n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        
        dp[0][0] = triangle.get(0).get(0);
        int ans = Integer.MAX_VALUE;
        for(int i = 1; i < n; i++) {
            for(int j = 0; j < triangle.get(i).size(); j++) {
                int topleft = j == 0 ? Integer.MAX_VALUE : dp[i - 1][j - 1];
                int top = dp[i - 1][j];
                dp[i][j] = Math.min(topleft, top) + triangle.get(i).get(j);
                if(i == n - 1) {
                    ans = Math.min(ans, dp[i][j]);
                }
            }
        }
        
        return ans == Integer.MAX_VALUE ? dp[0][0] : ans;
    }
}