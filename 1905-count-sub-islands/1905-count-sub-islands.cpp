class Solution {
public:
    int n, m;
    int dir[4][2] = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    
    void dfs(vector<vector<int>>& grid1, vector<vector<int>>& grid2, int r, int c, bool& res) {
        grid2[r][c] = 0;
        for(int d = 0; d < 4; d++) {
            int nr = r + dir[d][0];
            int nc = c + dir[d][1];
            if(nr >= 0 && nc >= 0 && nr < n && nc < m && grid2[nr][nc] == 1) {
                if(grid1[nr][nc] == 0) {
                    res = false;
                }
                dfs(grid1, grid2, nr, nc, res);
            }
        }
    }
    
    int countSubIslands(vector<vector<int>>& grid1, vector<vector<int>>& grid2) {
        int ans = 0;
        n = grid1.size();
        m = grid1[0].size();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid2[i][j] == 1 && grid1[i][j] == 1) {
                    bool res = true;
                    dfs(grid1, grid2, i, j, res);
                    if(res == true) {
                        ans++;
                    }
                }
            }
        } 
        return ans;
    }
};