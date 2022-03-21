class Solution {
public:
    int minFallingPathSum(vector<vector<int>>& matrix) {
        int n = matrix.size();
        if(n == 1) {
            return matrix[0][0];
        }
        
        vector<vector<int>> dp(n, vector<int> (n, 0));
        for(int col = 0; col < n; col++) {
            dp[n - 1][col] = matrix[n - 1][col];
        }
        
        int ans = INT_MAX;
        for(int row = n - 2; row >= 0; row--) {
            for(int col = 0; col < n; col++) {
                int b = dp[row + 1][col];
                int l = col - 1 >= 0 ? dp[row + 1][col - 1] : INT_MAX;
                int r = col + 1 < n ? dp[row + 1][col + 1] : INT_MAX;
                
                dp[row][col] = matrix[row][col] + min({b, l, r});
                if(row == 0) {
                    ans = min(ans, dp[row][col]);
                }
            }
        }
        
        return ans;
    }
};