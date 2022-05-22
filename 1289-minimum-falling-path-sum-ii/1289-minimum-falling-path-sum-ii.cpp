class Solution {
public:
    int minFallingPathSum(vector<vector<int>>& grid) {
        int n = grid.size();
        int ans = INT_MAX;
        vector<vector<int>> dp(n, vector<int>(n, INT_MAX));
        for(int j = 0; j < n; j++) {
            ans = min(ans, memo(grid, 0, j, n, dp));   
        }
        return ans;
    }
    
    int memo(vector<vector<int>>& grid, int r, int c, int n, vector<vector<int>>& dp) {
        if(r == n - 1) {
            return dp[r][c] = grid[r][c];
        }
        
        if(dp[r][c] != INT_MAX) {
            return dp[r][c];
        }
        
        int ans = INT_MAX;
        for(int j = 0; j < n; j++) {
            if(j != c) {
                ans = min(ans, memo(grid, r + 1, j, n, dp) + grid[r][c]);
            }
        }
        
        return dp[r][c] = ans;
    }
};