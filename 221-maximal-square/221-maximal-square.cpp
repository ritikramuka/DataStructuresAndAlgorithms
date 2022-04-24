class Solution {
public:
    int dp[301][301];
    int memo(vector<vector<char>>& matrix, int r, int c, int n, int m) {
        if(matrix[r][c] == '0') {
            return 0;
        }
        
        if(dp[r][c] != -1) {
            return dp[r][c];
        }
        
        int right = 0, down = 0, diag = 0;
        if(r + 1 < n) {
            right = memo(matrix, r + 1, c, n, m);
        }
        if(c + 1 < m) {
            down = memo(matrix, r, c + 1, n, m);
        }
        if(r + 1 < n && c + 1 < m) {
            diag = memo(matrix, r + 1, c + 1, n, m);
        }

        return dp[r][c] = min({right, down, diag}) + 1;
    }
    
    int maximalSquare(vector<vector<char>>& matrix) {
        memset(dp, -1, sizeof(dp));
        int n = matrix.size(), m = matrix[0].size();
        int ans = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(matrix[i][j] == '1') {
                    ans = max(ans, memo(matrix, i, j, n, m));
                }
            }
        }
        return ans * ans;
    }
};