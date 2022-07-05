class Solution {
public:
    int dir[4][2] = {{-1, 0}, {0, 1}, {0, -1}, {1, 0}};
    int n, m;
    
    void dfs(vector<vector<char>>& arr, int r, int c) {
        arr[r][c] = '2';
        for(int d = 0; d < 4; d++) {
            int nr = r + dir[d][0];
            int nc = c + dir[d][1];
            if(nr >= 0 && nr < n && nc >= 0 && nc < m && arr[nr][nc] == '1') {
                dfs(arr, nr, nc);
            }
        }
    }
    
    int numIslands(vector<vector<char>>& grid) {
        n = grid.size();
        m = grid[0].size();
        int ans = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == '1') {
                    dfs(grid, i, j);
                    ans++;
                }
            }
        }
        return ans;
    }
};