class Solution {
    int n, m;
    int[][] dir = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
    long mod = (long)(1e9+7);
    public int inc_path(int r, int c, int[][] arr, int[][] dp) {
        long ans = 1;
        if(dp[r][c] != 0)
            return dp[r][c];
        
        for(int[] a : dir) {
            int nr = a[0] + r;
            int nc = a[1] + c;
            
            if(nr >= 0 && nr < n && nc >= 0 && nc < m && arr[nr][nc] > arr[r][c]) {
                ans += inc_path(nr, nc, arr, dp);
                ans %= mod;
            }
        }
        
        return dp[r][c] = (int)ans;
    }
    
    public int countPaths(int[][] mat) {
        n = mat.length;
        m = mat[0].length;
        long ans = 0;
        int[][] dp = new int[n][m];
        for(int[] a : dp)
            Arrays.fill(a, 0);
        
        for(int i = n - 1; i >= 0; i--) {
            for(int j = m - 1; j >= 0; j--) {
                int t = inc_path(i, j, mat, dp);
                // System.out.println(t);
                ans += t;
                ans %= mod;
            }
        }
        
        return (int)ans;
    }
}