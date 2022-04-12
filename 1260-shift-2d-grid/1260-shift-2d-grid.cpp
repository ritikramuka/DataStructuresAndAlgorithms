class Solution {
public:
    vector<vector<int>> shiftGrid(vector<vector<int>>& grid, int k) {
        int r = grid.size(), c = grid[0].size();
        vector<vector<int>> ans(r, vector<int>(c));
        
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                int newj = (j + k) % c;
                int newi = (i + (j + k) / c) % r;
                ans[newi][newj] = grid[i][j];
            }
        }
        
        return ans;
    }
};