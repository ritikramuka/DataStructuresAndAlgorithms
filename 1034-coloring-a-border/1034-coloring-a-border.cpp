class Solution {
public:
    int dir[4][2] = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    void dfs(vector<vector<int>>& grid, int row, int col, int pcolor) {
        grid[row][col] = -pcolor;
        for(int i = 0; i < 4; i++) {
            int nrow = row + dir[i][0];
            int ncol = col + dir[i][1];
            if(nrow >= 0 and nrow < grid.size() and ncol >= 0 and ncol < grid[0].size() and grid[nrow][ncol] == pcolor) {
                dfs(grid, nrow, ncol, pcolor);
            }
        }
        if(row > 0 and row < grid.size() - 1 and col > 0 and col < grid[0].size() - 1 and abs(grid[row + 1][col]) == pcolor and abs(grid[row - 1][col]) == pcolor and abs(grid[row][col + 1]) == pcolor and abs(grid[row][col - 1]) == pcolor) {
            grid[row][col] = pcolor;
        }
    }
    
    vector<vector<int>> colorBorder(vector<vector<int>>& grid, int row, int col, int color) {
        dfs(grid, row, col, grid[row][col]);
        for(int i = 0; i < grid.size(); i++) {
            for(int j = 0; j < grid[0].size(); j++) {
                if(grid[i][j] < 0) {
                    grid[i][j] = color;
                }
            }
        }
        return grid;
    }
};