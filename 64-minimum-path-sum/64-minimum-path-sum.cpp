class Solution {
public:
    int minPathSum(vector<vector<int>>& grid) {
        int n = grid.size(), m = grid[0].size();
        int dp[n][m];
        for(int i = n - 1; i >= 0; i--) {
            for(int j = m - 1; j >= 0; j--) {
                if(i == n - 1 && j == m - 1) {
                    dp[i][j] = grid[i][j];
                    continue;
                }
                
                int right = INT_MAX, down = INT_MAX;
                if(i + 1 < n) {
                    right = dp[i + 1][j];
                }
                if(j + 1 < m) {
                    down = dp[i][j + 1];
                }
                
                dp[i][j] = min(right, down) + grid[i][j];
            }
        }
        
        return dp[0][0];
    }
};