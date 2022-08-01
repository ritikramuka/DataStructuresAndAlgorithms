class Solution {
public:
    int dp[101][101];
    
    int memo(int sr, int sc, int er, int ec) {
        if(sr >= er or sc >= ec) return dp[sr][sc] = 0;
        if(sr == er - 1 and sc == ec - 1) return dp[sr][sc] = 1;
        if(dp[sr][sc] != -1) return dp[sr][sc];
        return dp[sr][sc] = memo(sr + 1, sc, er, ec) + memo(sr, sc + 1, er, ec);
    }
    
    int uniquePaths(int m, int n) {
        memset(dp, -1, sizeof(dp));
        int ans = memo(0, 0, m, n);
        return ans;
    }
};