class Solution {
    private int n;
    private int m;
    
    private void swap(int[][] matrix, int x1, int y1, int x2, int y2) {
        int temp = matrix[x1][y1];
        matrix[x1][y1] = matrix[x2][y2];
        matrix[x2][y2] = temp;
    }
    
    private void transpose(int[][] matrix) {
        for(int r = 0; r < n; r++) {
            for(int c = 0; c < r; c++) {
                swap(matrix, r, c, c, r);
            }
        }
    }
    
    private void swapColumns(int[][] matrix, int col1, int col2) {
        for(int r = 0; r < n; r++) {
            swap(matrix, r, col1, r, col2);
        }
    }
    
    private void swapComplementaryColumns(int[][] matrix) {
        int columnIndex = 0;
        int complementaryColumnIndex = (m - 1) - columnIndex;
        while(columnIndex < complementaryColumnIndex) {
            swapColumns(matrix, columnIndex, complementaryColumnIndex);
            columnIndex++;
            complementaryColumnIndex--;
        }
    }
    
    public void rotate(int[][] matrix) {
        n = matrix.length;
        m = matrix.length;
        
        transpose(matrix);
        
        swapComplementaryColumns(matrix);
    }
}