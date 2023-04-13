class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        
        int sr = 0;
        int er = matrix.length - 1;
        
        int sc = 0;
        int ec = matrix[0].length - 1;
        
        int totalEle = matrix.length * matrix[0].length;
        int currEle = 0;
        
        while (true) {
            // go right
            for (int i = sc; i <= ec; i++) {
                ans.add(matrix[sr][i]);
                currEle++;
            }
            sr++;
            
            if (currEle == totalEle) {
                break;
            }
            
            // go down
            for (int i = sr; i <= er; i++) {
                ans.add(matrix[i][ec]);
                currEle++;
            }
            ec--;
            
            if (currEle == totalEle) {
                break;
            }
            
            // go left
            for (int i = ec; i >= sc; i--) {
                ans.add(matrix[er][i]);
                currEle++;
            }
            er--;
            
            if (currEle == totalEle) {
                break;
            }
            
            // go up
            for (int i = er; i >= sr; i--) {
                ans.add(matrix[i][sc]);
                currEle++;
            }
            sc++;
            
            if (currEle == totalEle) {
                break;
            }
        }
        
        return ans;
    }
}