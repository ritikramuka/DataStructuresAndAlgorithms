class Solution {
public:
    int memo(int r, int c1, int c2, vector<vector<int>>& grid) {
        if(r == grid.size()) {
            return dp[r][c1][c2] = 0;
        }
        
        if(dp[r][c1][c2] != 0) {
            return dp[r][c1][c2];
        }
        
        int ans = 0;
        for(int dir1 = -1; dir1 <= 1; dir1++) {
            for(int dir2 = -1; dir2 <= 1; dir2++) {
                if(c1 + dir1 >= 0 && c1 + dir1 < grid[0].size() && c2 + dir2 >= 0 && c2 + dir2 < grid[0].size()) {
                    if(c1 == c2) {
                        ans = max(ans, grid[r][c1] + memo(r + 1, c1 + dir1, c2 + dir2, grid));
                    } else {
                        ans = max(ans, grid[r][c1] + grid[r][c2] + memo(r + 1, c1 + dir1, c2 + dir2, grid));
                    }
                }
            }
        }
        
        return dp[r][c1][c2] = ans;
    }
    
    int dp[71][71][71];
    int cherryPickup(vector<vector<int>>& grid) {
        if(grid.size() == 0 || grid[0].size() == 0) return 0;
        memset(dp, 0, sizeof(dp));
        int ans = memo(0, 0, grid[0].size() - 1, grid);
        return ans;
    }
};