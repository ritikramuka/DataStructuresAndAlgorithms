class Solution {
public:
    int n, m;
    int dir[4][2] = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
    
    void getCurrAreaDFS(vector<vector<int>>& grid, int r, int c, int& area) {
        grid[r][c] = 2;
        area++;
        
        for(int d = 0; d < 4; d++) {
            int nr = r + dir[d][0];
            int nc = c + dir[d][1];
            if(nr >= 0 && nr < n && nc >= 0 && nc < m && grid[nr][nc] == 1) {
                getCurrAreaDFS(grid, nr, nc, area);
            }
        }
    }
    
    int maxAreaOfIsland(vector<vector<int>>& grid) {
        n = grid.size();
        m = grid[0].size();
        
        int maxArea = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == 1) {
                    int currArea = 0;
                    getCurrAreaDFS(grid, i, j, currArea);
                    maxArea = max(maxArea, currArea);
                }
            }
        }
        return maxArea;
    }
};