class Solution {
    class Pair {
        int row;
        int col;
        Pair() {}
        Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
    
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dir = {{-1, 0}, {1, 0}, {-1, -1}, {1, 1}, {0, -1}, {0, 1}, {1, -1}, {-1, 1}};
        
        if(grid[0][0] == 1 || grid[n - 1][m - 1] == 1) {
            return -1;
        }
        
        Queue<Pair> que = new ArrayDeque<>();
        que.add(new Pair(0, 0));
        grid[0][0] = 1;
        int level = 1;
        while(que.size() != 0) {
            int size = que.size();
            while(size-->0) {
                int r = que.peek().row;
                int c = que.peek().col;
                que.remove();
                if(r == n - 1 && c == n - 1) {
                    return level;
                }
                
                for(int i = 0; i < 8; i++) {
                    int nr = r + dir[i][0];
                    int nc = c + dir[i][1];
                    
                    if(nr >= 0 && nr < n && nc >= 0 && nc < m && grid[nr][nc] == 0) {
                        grid[nr][nc] = 1;
                        que.add(new Pair(nr, nc));
                    }
                }
            }
            level++;
        }
        
        return -1;
    }
}