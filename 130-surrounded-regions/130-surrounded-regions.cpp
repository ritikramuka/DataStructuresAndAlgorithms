class Solution {
private:
    int n, m;
    int dir[4][2] = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    
    void dfs(int r, int c, vector<vector<char>>& board) {
        board[r][c] = 'D';
        for(int d = 0; d < 4; d++) {
            int nr = dir[d][0] + r;
            int nc = dir[d][1] + c;
            if(nr >= 0 and nc >= 0 and nr < n and nc < m and board[nr][nc] == 'O') {
                dfs(nr, nc, board);
            }
        }
    }
    
public:
    void solve(vector<vector<char>>& board) {
        n = board.size();
        m = board[0].size();
        
        for(int i = 0; i < n; i++) {
            if(board[i][0] == 'O') dfs(i, 0, board);
            if(board[i][m - 1] == 'O') dfs(i, m - 1, board);
        }
        
        for(int i = 0; i < m; i++) {
            if(board[0][i] == 'O') dfs(0, i, board);
            if(board[n - 1][i] == 'O') dfs(n - 1, i, board);
        }
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(board[i][j] == 'D') board[i][j] = 'O';
                else board[i][j] = 'X';
            }
        }
    }
};