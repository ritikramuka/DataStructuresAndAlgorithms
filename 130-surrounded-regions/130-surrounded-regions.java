class Solution {

    private void dfs(int r, int c, char[][] arr) {
        arr[r][c] = 'D';
        if (r - 1 >= 0 && arr[r - 1][c] == 'O') {
            dfs(r - 1, c, arr);
        }
        if (r + 1 < arr.length && arr[r + 1][c] == 'O') {
            dfs(r + 1, c, arr);
        }
        if (c - 1 >= 0 && arr[r][c - 1] == 'O') {
            dfs(r, c - 1, arr);
        }
        if (c + 1 < arr[r].length && arr[r][c + 1] == 'O') {
            dfs(r, c + 1, arr);
        }
    }

    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;

        // first row
        for (int col = 0; col < m; col++) {
            if (board[0][col] == 'O') {
                dfs(0, col, board);
            }
        }

        // last row
        for (int col = 0; col < m; col++) {
            if (board[n - 1][col] == 'O') {
                dfs(n - 1, col, board);
            }
        }

        // first column
        for (int row = 0; row < n; row++) {
            if (board[row][0] == 'O') {
                dfs(row, 0, board);
            }
        }

        // last column
        for (int row = 0; row < n; row++) {
            if (board[row][m - 1] == 'O') {
                dfs(row, m - 1, board);
            }
        }

        // loop over and change 'D' -> 'O' and 'O' -> 'X'
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'D') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }
}
