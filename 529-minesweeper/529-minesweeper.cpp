class Solution {
public:
    vector<vector < int>> moves = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
    
    bool valid(int i, int j, vector<vector<int>> &vis, int r, int c) {
        if (i < 0 or j < 0 or i >= r or j >= c or vis[i][j]) {
            return true;
        }
        return false;
    }
    
    void dfs(int i, int j, int r, int c, vector<vector<char>> &b, vector<vector<int>> &vis) {
        if (valid(i, j, vis, r, c)) {
            return;
        }
        
        vis[i][j] = 1;
        if (b[i][j] == 'M') {
            b[i][j] = 'X';
            return;
        }
        
        int countM = 0;
        for (auto x: moves) {
            int cx = i + x[0];
            int cy = j + x[1];
            if (valid(cx, cy, vis, r, c)) continue;
            if (b[cx][cy] == 'M') {
                countM++;
            }
        }
        
        if (countM) {
            b[i][j] = char(countM + '0');
            return;
        }
        
        b[i][j] = 'B';
        for (auto x: moves) {
            int cx = i + x[0];
            int cy = j + x[1];
            if (valid(cx, cy, vis, r, c)) continue;
            dfs(cx, cy, r, c, b, vis);
        }
    }
    
    vector<vector < char>> updateBoard(vector<vector<char>> &board, vector<int> &click) {
        int r = board.size();
        int c = board[0].size();
        vector<vector<int>> vis(r, vector<int> (c, 0));
        dfs(click[0], click[1], r, c, board, vis);
        return board;
    }
    
};