class Solution {
public:
    
    bool areEquals (vector<vector<int>>& arr1, vector<vector<int>>& arr2) {
        int n = arr1.size();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr1[i][j] != arr2[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
    
    void RotateMat (vector<vector<int>>& mat) {
        int n = mat.size();
        
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
    
    bool findRotation(vector<vector<int>>& mat, vector<vector<int>>& target) {
        int n = mat.size();
        
        int rotations = 4;
        while (rotations > 0) {
            
            // will rotate by 90 clockwise
            RotateMat (mat);
            
            if (areEquals(mat, target) == true) {
                return true;
            }
            
            rotations--;
        }
        
        return false;   
    }
};