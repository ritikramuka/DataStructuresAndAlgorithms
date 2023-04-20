class Solution {
    void swap(int[][] matrix, int x1, int y1, int x2, int y2) {
        int temp = matrix[x1][y1];
        matrix[x1][y1] = matrix[x2][y2];
        matrix[x2][y2] = temp;
    }
    
    void reverse(int[][] matrix, int r) {
        int si = 0;
        int ei = matrix[r].length - 1;
        while (si <= ei) {
            swap(matrix, r, si, r, ei);
            si++;
            ei--;
        }
    }
    
    void transpose(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < i; j++) {
                swap(matrix, i, j, j, i);
            }
        }
    }
    
    public void rotate(int[][] matrix) {
        transpose(matrix);
        for (int r = 0; r < matrix.length; r++) {
            reverse(matrix, r);
        }
    }
}