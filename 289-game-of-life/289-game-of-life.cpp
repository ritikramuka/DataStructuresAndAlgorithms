class Solution {
public:
    bool isOne(int a){
		if(a == 1 || a == -2) 
			return true;
		else
			return false;
	}
    
	int countNeighbours(vector<vector<int>>& board, int i, int j){
		int n = board.size();
		int m = board[0].size();
		int cnt = 0;
		
        if(i < n-1 && isOne(board[i + 1][j]))
			cnt++;
		if(j < m-1 && isOne(board[i][j + 1])) 
		   cnt++;
		if(i < n-1 && j < m-1 && isOne(board[i + 1][j + 1]))
		   cnt++;
		if(i > 0 && isOne(board[i - 1][j]))
			cnt++;
		if(j > 0 && isOne(board[i][j - 1])) 
		   cnt++;
		if(i > 0 && j > 0 && isOne(board[i - 1][j - 1]))
		   cnt++;

		if(i > 0 && j < m-1 && isOne(board[i - 1][j + 1]))
		   cnt++;
		if(i < n - 1 && j > 0 && isOne(board[i + 1][j - 1]))
		   cnt++;

		return cnt;
	}
    
	void gameOfLife(vector<vector<int>>& board) {
		int n = board.size();
		int m = board[0].size();
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				int cnt=countNeighbours(board, i, j);

				if(cnt < 2 && board[i][j] == 1) {
					board[i][j] = -2;
				}

				else if(cnt > 3 && board[i][j] == 1){
					board[i][j] = -2;
				}
				else if(board[i][j] == 0 && cnt == 3){
					board[i][j] = 2;
				}
			}
		}

        for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(board[i][j] == 2)
					board[i][j] = 1;
				else if(board[i][j] == -2)
					board[i][j] = 0;
			}
		}
	}
};