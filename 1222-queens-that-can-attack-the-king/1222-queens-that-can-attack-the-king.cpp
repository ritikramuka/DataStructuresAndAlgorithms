class Solution {
private:
    // all directions that can be travelled
    int dir[8][2] = {{1, 0}, {0, 1}, {0, -1}, {-1, 0}, {1, 1}, {-1, 1}, {1, -1}, {-1, -1}};
    
public:
    vector<vector<int>> queensAttacktheKing(vector<vector<int>>& queens, vector<int>& king) {
        int size = 8;
        bool board[size][size];
        memset(board, false, sizeof(board));
        
        // mark queens location
        for (vector<int>& queen : queens) {
            board[queen[0]][queen[1]] = true;
        }
        
        vector<vector<int>> hittingQueens;
        
        // find first queen in king's radar (8 directions)
        for (int d = 0; d < 8; d++) {
            int nr = king[0] + dir[d][0];
            int nc = king[1] + dir[d][1];
            while (nr >= 0 and nr < size && nc >= 0 && nc < size) {
                if (board[nr][nc] == true) {
                    hittingQueens.push_back({nr, nc});
                    break;
                }
                nr += dir[d][0];
                nc += dir[d][1];
            }
        }
        
        return hittingQueens;
    }
};