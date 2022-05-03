class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        
        Queue<Pair> que = new ArrayDeque<>();
        // all intitally rotten oranges
        for(int r = 0; r < n; r++) {
            for(int c = 0; c < m; c++) {
                if(grid[r][c] == 2) {
                    que.add(new Pair(r, c));
                }
            }
        }
        int time = 0;
        while(que.size() != 0) {
            int size = que.size();
            while(size-->0) {
                Pair rm = que.remove();
                for(int i = 0; i < 4; i++) {
                    int nr = rm.row + dir[i][0];
                    int nc = rm.col + dir[i][1];
                    
                    if(nr >= 0 && nc >= 0 && nr < n && nc < m && grid[nr][nc] == 1) {
                        grid[nr][nc] = 2;
                        que.add(new Pair(nr, nc));
                    }
                }
            }
            time++;
        }
        
        // cheack for fresh orange 
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == 1) {
                    return -1;
                }
            }
        }
        
        return time - 1 < 0 ? 0 : time - 1;
    }
    
    class Pair {
        int row;
        int col;
        Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}