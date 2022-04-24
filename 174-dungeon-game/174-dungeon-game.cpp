class Solution {
public:
    int dp[201][201];
    int memo(int n, int m, int r, int c, vector<vector<int>>& dungeon) {
        if(r == n - 1 && c == m - 1) {
            return dp[r][c] = (dungeon[r][c] < 0 ? 1 - dungeon[r][c] : 1);
        }
        
        if(dp[r][c] != 0) {
            return dp[r][c];
        }
        
        int right = INT_MAX;
        if(r + 1 < n) {
            right = memo(n, m, r + 1, c, dungeon);
        }
        int down = INT_MAX;
        if(c + 1 < m) {
            down = memo(n, m, r, c + 1, dungeon);
        }
        int req = min(right, down) - dungeon[r][c];
        
        return dp[r][c] = max(req, 1);
    }
    
    int calculateMinimumHP(vector<vector<int>>& dungeon) {
        int n = dungeon.size(), m = dungeon[0].size();
        memset(dp, 0, sizeof(dp));
        int ans = memo(n, m, 0, 0, dungeon);
        return ans;
    }
};