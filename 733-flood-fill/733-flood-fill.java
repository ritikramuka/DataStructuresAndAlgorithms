class Solution {
    private void dfs(int r, int c, int[][] image, int pColor, int nColor) {
        image[r][c] = nColor;
        if(r - 1 >= 0 && image[r - 1][c] == pColor) {
            dfs(r - 1, c, image, pColor, nColor);
        }
        if(r + 1 < image.length && image[r + 1][c] == pColor) {
            dfs(r + 1, c, image, pColor, nColor);
        }
        if(c - 1 >= 0 && image[r][c - 1] == pColor) {
            dfs(r, c - 1, image, pColor, nColor);
        }
        if(c + 1 < image[r].length && image[r][c + 1] == pColor) {
            dfs(r, c + 1, image, pColor, nColor);
        }
    }
    
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(color == image[sr][sc]) return image;
        dfs(sr, sc, image, image[sr][sc], color);
        return image;
    }
}