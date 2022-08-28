class Solution {
    // private void dfs(int r, int c, int[][] image, int pColor, int nColor) {
    //     image[r][c] = nColor;
    //     if(r - 1 >= 0 && image[r - 1][c] == pColor) {
    //         dfs(r - 1, c, image, pColor, nColor);
    //     }
    //     if(r + 1 < image.length && image[r + 1][c] == pColor) {
    //         dfs(r + 1, c, image, pColor, nColor);
    //     }
    //     if(c - 1 >= 0 && image[r][c - 1] == pColor) {
    //         dfs(r, c - 1, image, pColor, nColor);
    //     }
    //     if(c + 1 < image[r].length && image[r][c + 1] == pColor) {
    //         dfs(r, c + 1, image, pColor, nColor);
    //     }
    // }
    
    private class Pair {
        int r;
        int c;
        Pair() {}
        Pair(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    
    private void bfs(int r, int c, int[][] image, int color) {
        Queue<Pair> que = new LinkedList<>();
        int pc = image[r][c];
        que.add(new Pair(r, c));
        while(que.size() != 0) {
            int size = que.size();
            while(size-- > 0) {
                Pair rp = que.poll();
                int cr = rp.r;
                int cc = rp.c;
                image[cr][cc] = color;
                if(cr - 1 >= 0 && image[cr - 1][cc] == pc) {
                    que.add(new Pair(cr - 1, cc));
                }
                if(cr + 1 < image.length && image[cr + 1][cc] == pc) {
                    que.add(new Pair(cr + 1, cc));
                }
                if(cc - 1 >= 0 && image[cr][cc - 1] == pc) {
                    que.add(new Pair(cr, cc - 1));
                }
                if(cc + 1 < image[cr].length && image[cr][cc + 1] == pc) {
                    que.add(new Pair(cr, cc + 1));
                }
            }
        }
    }
    
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(color == image[sr][sc]) return image;
        // dfs(sr, sc, image, image[sr][sc], color);
        bfs(sr, sc, image, color);
        return image;
    }
}