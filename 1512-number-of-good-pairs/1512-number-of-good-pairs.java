class Solution {
    public int[][] createPascalsTriangle(int n) {
        int[][] pascalsTrianlge = new int[n][n];
        
        for (int i = 0; i < n; i++) {
            pascalsTrianlge[i][0] = 1;
        }
        
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= i; j++) {
                pascalsTrianlge[i][j] = pascalsTrianlge[i - 1][j] + pascalsTrianlge[i - 1][j - 1];
            }
        }
        
        return pascalsTrianlge;
    }
    
    public int numIdenticalPairs(int[] nums) {
        int[] freq = new int[101];
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            freq[num] += 1;
        }
        
        int[][] pascalsTriangle = createPascalsTriangle(101);
        
        int cnt = 0;
        for (int i = 0; i < 101; i++) {
            if(freq[i] > 1) {
                cnt += pascalsTriangle[freq[i]][2];
            }
        }
        
        return cnt;
    }
}