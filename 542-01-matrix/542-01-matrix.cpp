class Solution {
private:
    int n;
    int m;
    int dir[4][2] = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    
public:
    vector<vector<int>> updateMatrix(vector<vector<int>>& mat) {
        n = mat.size();
        m = mat[0].size();
        
        queue<pair<int, int>> que;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(mat[i][j] == 0) {
                    que.push({i, j});
                } else {
                    mat[i][j] = -1;
                }
            }
        }
        
        while(que.size() != 0) {
            int size = que.size();
            while(size-->0) {
                int r = que.front().first;
                int c = que.front().second;
                que.pop();
                
                for(int d = 0; d < 4; d++) {
                    int nr = dir[d][0] + r;
                    int nc = dir[d][1] + c;
                    
                    if(nr >= 0 and nc >= 0 and nr < n and nc < m and mat[nr][nc] == -1) {
                        mat[nr][nc] = mat[r][c] + 1;
                        que.push({nr, nc});
                    }
                }                
            }
        }
        
        return mat;
    }
};