class Solution {
    private int[][] dir = {{-2, -1}, {-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}};
    private int[][] board = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {-1, 0, -1}};
    private int mod = 1000000007;
    private long[][][] dp;
    private long helper(int n, int r, int c) {
        if(board[r][c] == -1) {
            return 0;
        }
        
        if(n == 1) {
            return dp[n][r][c] = 1;
        }
        
        if(dp[n][r][c] != 0) {
            return dp[n][r][c];
        }
        
        long ans = 0;
        for(int i = 0; i < 8; i++) {
            int nr = r + dir[i][0];
            int nc = c + dir[i][1];
            if(nr >= 0 && nc >= 0 && nr < 4 && nc < 3 && board[nr][nc] != -1) {
                ans += helper(n - 1, nr, nc) % mod;
            }
        }
        
        return dp[n][r][c] = ans % mod;
    }
    
    public int knightDialer(int n) {
        dp = new long[n + 1][5][4];
        long ans = 0;
        for(int r = 0; r < 4; r++) {
            for(int c = 0; c < 3; c++) {
                ans += helper(n, r, c) % mod;        
            }
        }
        return (int) (ans % mod);
    }
}