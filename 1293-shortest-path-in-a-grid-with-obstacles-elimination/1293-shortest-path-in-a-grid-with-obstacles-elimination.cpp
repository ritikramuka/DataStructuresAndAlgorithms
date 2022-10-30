class Solution {
public:
    int shortestPath(vector<vector<int>>& grid, int k) {
        int n = grid.size();
        int m = grid[0].size();
        
        vector<vector<int>> visited(n, vector<int>(m, -1));
        queue<vector<int>> que;
        
        que.push({0, 0, k, 0});
        while(que.size() != 0) {
            vector<int> temp = que.front();
            que.pop();
            
            int r = temp[0];
            int c = temp[1];
            
            if(r < 0 or r >= n or c < 0 or c >= m)
                continue;
            
            if(r == n - 1 and c == m - 1)
                return temp[3];
            
            if(grid[r][c] == 1) 
                if(temp[2] <= 0)
                    continue;
                else
                    temp[2]--;
            
            if(visited[r][c] != -1 and visited[r][c] >= temp[2])
                continue;
            
            visited[r][c] = temp[2];
            que.push({r + 1, c, temp[2], temp[3] + 1});
            que.push({r - 1, c, temp[2], temp[3] + 1});
            que.push({r, c + 1, temp[2], temp[3] + 1});
            que.push({r, c - 1, temp[2], temp[3] + 1});
        }
        
        return -1;
    }
};