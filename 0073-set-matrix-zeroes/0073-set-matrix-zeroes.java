class Solution {
    public void setZeroes(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        
        HashSet<Integer> row = new HashSet<>();
        HashSet<Integer> col = new HashSet<>();
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 0) {
                    row.add(i);
                    col.add(j);
                }
            }
        }
        
        for (int r: row) {
            for (int j = 0; j < m; j++) {
                mat[r][j] = 0;
            }
        }
        
        for (int c: col) {
            for (int i = 0; i < n; i++) {
                mat[i][c] = 0;
            }
        }
    }
}