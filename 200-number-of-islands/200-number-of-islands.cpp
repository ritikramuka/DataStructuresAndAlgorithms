class Solution {
public:
    int dir[4][2] = {{1, 0}, {0, 1}, {0, -1}, {-1, 0}};
    
    void dfs(vector<vector<char>>& grid, int sr, int sc, int er, int ec) {
        if(sr < 0 || sr >= er || sc < 0 || sc >= ec || grid[sr][sc] != '1') {
            return;
        }
        
        grid[sr][sc] = 3;
        for(int d = 0; d < 4; d++) {
            int nr = sr + dir[d][0];
            int nc = sc + dir[d][1];
            dfs(grid, nr, nc, er, ec);
        }
        
        return;
    }
    
    int numIslands(vector<vector<char>>& grid) {
        // 1 -> land
        // 2 -> water
        // 3 -> explored land
        
        int n = grid.size();
        int m = grid[0].size();
        
        int ans = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == '1') {
                    ans++;
                    dfs(grid, i, j, n, m);
                }
            }
        }
        
        return ans;
    }
};