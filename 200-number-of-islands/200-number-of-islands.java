class Solution {
    private int n;
    private int m;
    private int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    
    private void dfs(int r, int c, char[][] grid) {
        grid[r][c] = '2';
        for(int d = 0; d < 4; d++) {
            int nr = r + dir[d][0];
            int nc = c + dir[d][1];
            
            if(nr >= 0 && nr < n && nc >=0 && nc < m && grid[nr][nc] == '1') {
                dfs(nr, nc, grid);
            }
        }
    }
    
    public int numIslands(char[][] grid) {
        n = grid.length;
        m = grid[0].length;
        
        int numOfIslands = 0;
        for(int r = 0; r < n; r++) {
            for(int c = 0; c < m; c++) {
                if(grid[r][c] == '1') {
                    dfs(r, c, grid);
                    numOfIslands++;
                }
            }
        }
        
        return numOfIslands;
    }
}