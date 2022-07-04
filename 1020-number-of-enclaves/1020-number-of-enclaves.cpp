class Solution {
public:
    int dir[4][2] = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    int n, m;
    int cnt = 0;
    void dfs_closeIsland(vector<vector<int>>& grid, int r, int c) {
        grid[r][c] = 0;
        cnt++;
        for(int d = 0; d < 4; d++) {
            int nr = r + dir[d][0];
            int nc = c + dir[d][1];
            if(nr >= 0 && nr < n && nc >= 0 && nc < m && grid[nr][nc] == 1) {
                dfs_closeIsland(grid, nr, nc);
            }
        }
    }
    
    int numEnclaves(vector<vector<int>>& grid) {
        n = grid.size();
        m = grid[0].size();
        int ans = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == 1) ans++;
            }
        }
        
        for(int i = 0; i < n; i++) {
            if(grid[i][0] == 1) {
                dfs_closeIsland(grid, i, 0);
            }
            if(grid[i][m - 1] == 1) {
                dfs_closeIsland(grid, i, m - 1);
            }
        }
        for(int j = 0; j < m; j++) {
            if(grid[0][j] == 1) {
                dfs_closeIsland(grid, 0, j);
            }
            if(grid[n - 1][j] == 1) {
                dfs_closeIsland(grid, n - 1, j);
            }
        }
        return ans - cnt;
    }
};