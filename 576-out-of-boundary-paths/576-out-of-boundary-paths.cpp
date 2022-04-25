class Solution {
public:
    int dp[51][51][51];
    int mod = 1e9 + 7;
    int memo(int m, int n, int maxMove, int r, int c) {
        if(r == m || r < 0 || c == n || c < 0) {
            return 1;
        }
        
        if(maxMove == 0) {
            return dp[r][c][maxMove] = 0;
        }
        
        if(dp[r][c][maxMove] != -1) {
            return dp[r][c][maxMove];
        }
        
        long ans = 0;
        ans += memo(m, n, maxMove - 1, r + 1, c) % mod;
        ans += memo(m, n, maxMove - 1, r - 1, c) % mod;
        ans += memo(m, n, maxMove - 1, r, c + 1) % mod;
        ans += memo(m, n, maxMove - 1, r, c - 1) % mod;
        
        return dp[r][c][maxMove] = (int) (ans % mod);
    }
    
    int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        memset(dp, -1, sizeof(dp));
        int ans = memo(m, n, maxMove, startRow, startColumn) % mod;
        return ans;
    }
};