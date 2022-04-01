class Solution {
    public int memo(int idx, int k, List<List<Integer>> piles) {
        if(idx == piles.size() || k == 0) {
            return dp[idx][k] = 0;
        }
        
        if(dp[idx][k] != -1) {
            return dp[idx][k];
        }
        
        int best = memo(idx + 1, k, piles);
        
        int sum = 0;
        for(int i = 0; i < Math.min((int)piles.get(idx).size(), k); i++) {
            sum += piles.get(idx).get(i);
            best = Math.max(best, sum + memo(idx + 1, k - i - 1, piles));
        }
        
        return dp[idx][k] = best;
    }
    
    private int[][] dp;
    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        dp = new int[1001][2001];
        for(int i = 0; i < 1001; i++) {
            Arrays.fill(dp[i], -1);
        }
        return memo(0, k, piles);
    }
}