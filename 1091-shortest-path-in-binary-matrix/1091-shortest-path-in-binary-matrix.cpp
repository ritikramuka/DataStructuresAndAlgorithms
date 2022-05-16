class Solution {
public:
    int shortestPathBinaryMatrix(vector<vector<int>>& grid) {
        int n = grid.size();
        int m = grid[0].size();
        int dir[8][2] = {{-1, 0}, {1, 0}, {-1, -1}, {1, 1}, {0, -1}, {0, 1}, {1, -1}, {-1, 1}};
        
        if(grid[0][0] == 1 or grid[n - 1][m - 1] == 1) {
            return -1;
        }
        
        queue<pair<int, int>> que;
        que.push({0, 0});
        grid[0][0] = 1;
        int level = 1;
        while(que.size() != 0) {
            int size = que.size();
            while(size-->0) {
                int r = que.front().first;
                int c = que.front().second;
                que.pop();
                if(r == n - 1 and c == n - 1) {
                    return level;
                }
                
                for(int i = 0; i < 8; i++) {
                    int nr = r + dir[i][0];
                    int nc = c + dir[i][1];
                    
                    if(nr >= 0 and nr < n and nc >= 0 and nc < m and grid[nr][nc] == 0) {
                        grid[nr][nc] = 1;
                        que.push({nr, nc});
                    }
                }
            }
            level++;
        }
        
        return -1;
    }
};