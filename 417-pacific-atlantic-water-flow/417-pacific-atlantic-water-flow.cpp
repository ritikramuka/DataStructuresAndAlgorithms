class Solution {
public:
    int n, m;
    int dir[4][2] = {{-1, 0}, {0, 1}, {0, -1}, {1, 0}};
    
    void dfs(vector<vector<int>>& heights, int r, int c, vector<vector<bool>>& ocean) {
        ocean[r][c] = true;
        for(int d = 0; d < 4; d++) {
            int nr = r + dir[d][0];
            int nc = c + dir[d][1];
            if(nr >= 0 && nc >= 0 && nr < n && nc < m && ocean[nr][nc] == false && heights[nr][nc] >= heights[r][c]) {
                dfs(heights, nr, nc, ocean);
            }
        }
    }
    
    vector<vector<int>> pacificAtlantic(vector<vector<int>>& heights) {
        n = heights.size();
        m = heights[0].size();
        vector<vector<bool>> pac(n, vector<bool>(m, false));
        vector<vector<bool>> atl(n, vector<bool>(m, false));
        for(int i = 0; i < n; i++) {
            dfs(heights, i, 0, pac);
            dfs(heights, i, m - 1, atl);
        }
        for(int i = 0; i < m; i++) {
            dfs(heights, 0, i, pac);
            dfs(heights, n - 1, i, atl);
        }
        vector<vector<int>> ans;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(pac[i][j] == true && atl[i][j] == true) {
                    ans.push_back({i, j});
                }
            }
        }
        return ans;
    }
};