class Solution {
    public boolean areEquals (int[][] arr1, int[][] arr2) {
        int n = arr1.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr1[i][j] != arr2[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
    
    public void RotateMat (int[][] mat) {
        int n = mat.length;
        
        // transpose
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                // swap
                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }
        
        // swap comp cols
        for (int c = 0; c < n / 2; c++) {
            int cc = n - 1 - c;
            for (int r = 0; r < n; r++) {
                int temp = mat[r][c];
                mat[r][c] = mat[r][cc];
                mat[r][cc] = temp;    
            }
        }
        
        // mat -> is rotated??
    }
     
    public boolean findRotation(int[][] mat, int[][] target) {
        int n = mat.length;
        
        int rotations = 4;
        while (rotations > 0) {
            
            // will rotate by 90 clockwise
            RotateMat (mat);
            
            if (Arrays.deepEquals(mat, target) == true) {
                return true;
            }
            
            rotations--;
        }
        
        return false;
    }
}