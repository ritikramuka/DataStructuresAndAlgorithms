class Solution {
private:
    int n;
    int m;
    
    int dir[4][2] = {{-1, 0}, {0, 1}, {0, -1}, {1, 0}};
    
    void dfs(vector<vector<int>>& image, int sr, int sc, int prevColor, int newColor) {
        image[sr][sc] = newColor;
        
        for(int d = 0; d < 4; d++) {
            int nr = sr + dir[d][0];
            int nc = sc + dir[d][1];
            
            if(nr >= 0 and nc >= 0 and nr < n and nc < m and image[nr][nc] == prevColor) {
                dfs(image, nr, nc, prevColor, newColor);
            }
        }
    }
    
public:
    vector<vector<int>> floodFill(vector<vector<int>>& image, int sr, int sc, int color) {
        if(image[sr][sc] == color) return image;
        
        n = image.size();
        m = image[0].size();
        
        dfs(image, sr, sc, image[sr][sc], color);
        
        return image;
    }
};