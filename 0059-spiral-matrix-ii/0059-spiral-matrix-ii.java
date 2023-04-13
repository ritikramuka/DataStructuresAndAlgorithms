class Solution {
    public int[][] generateMatrix(int n) {
        int[][] mat = new int[n][n];
        int ele = 1;
        
        int sr = 0;
        int er = n - 1;
        
        int sc = 0;
        int ec = n - 1;
        
        int totalEle = n * n;
        int currEle = 0;
        
        while (true) {
            // go right
            for (int i = sc; i <= ec; i++) {
                mat[sr][i] = ele;
                ele++;
                currEle++;
            }
            sr++;
            
            if (currEle == totalEle) {
                break;
            }
            
            // go down
            for (int i = sr; i <= er; i++) {
                mat[i][ec] = ele;
                ele++;
                currEle++;
            }
            ec--;
            
            if (currEle == totalEle) {
                break;
            }
            
            // go left
            for (int i = ec; i >= sc; i--) {
                mat[er][i] = ele;
                ele++;
                currEle++;
            }
            er--;
            
            if (currEle == totalEle) {
                break;
            }
            
            // go up
            for (int i = er; i >= sr; i--) {
                mat[i][sc] = ele;
                ele++;
                currEle++;
            }
            sc++;
            
            if (currEle == totalEle) {
                break;
            }
        }
        
        return mat;
    }
}