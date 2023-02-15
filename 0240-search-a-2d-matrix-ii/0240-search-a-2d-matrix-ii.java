class Solution {
    //  TC: O(N + M), SC: O(1)
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        
        int r = 0;
        int c = m - 1;
        
        while (r < n && c >= 0) {
            if (matrix[r][c] == target) {
                return true;
            } else if (matrix[r][c] < target) {
                //  move towards greater side               
                r += 1;
            } else {
                //  move towards smaller side
                c -= 1;
            }
        }
        
        return false;
    }
}