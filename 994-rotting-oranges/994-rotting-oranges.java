class Solution {
    public class Pair {
        int row;
        int col;
        
        Pair() {};
        Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
    
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        Queue<Pair> que = new LinkedList<>();
        for(int r = 0; r < n; r++) {
            for(int c = 0; c < m; c++) {
                if(grid[r][c] == 2) {
                    que.add(new Pair(r, c));
                }
            }
        }
        
        int time = 0;
        while(!que.isEmpty()) {
            int size = que.size();
            while(size-->0) {
                Pair rp = que.poll();
                int cr = rp.row;
                int cc = rp.col;
                
                // right
                if(cc + 1 < m && grid[cr][cc + 1] == 1) {
                    grid[cr][cc + 1] = 2;
                    que.add(new Pair(cr, cc + 1));
                }
                
                // left
                if(cc - 1 >= 0 && grid[cr][cc - 1] == 1) {
                    grid[cr][cc - 1] = 2;
                    que.add(new Pair(cr, cc - 1));
                }
                
                // top
                if(cr - 1 >= 0 && grid[cr - 1][cc] == 1) {
                    grid[cr - 1][cc] = 2;
                    que.add(new Pair(cr - 1, cc));
                }
                
                // bottom
                if(cr + 1 < n && grid[cr + 1][cc] == 1) {
                    grid[cr + 1][cc] = 2;
                    que.add(new Pair(cr + 1, cc));
                }
            }
            time++;
        }
        
        for(int r = 0; r < n; r++) {
            for(int c = 0; c < m; c++) {
                if(grid[r][c] == 1) {
                    return -1;
                }
            }
        }
        
        return time - 1 < 0 ? 0 : time - 1;
    }
}