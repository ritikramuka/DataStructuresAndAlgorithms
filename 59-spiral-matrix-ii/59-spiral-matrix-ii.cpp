class Solution {
public:
    vector<vector<int>> generateMatrix(int n) {
        vector<vector<int>> ans (n, vector<int> (n));
        int sr = 0, er = n - 1, sc = 0, ec = n - 1;
        int num = 1;
        while(sr <= er and ec <= ec) {
            for(int i = sc; i <= ec; i++) {
                ans[sr][i] = num;
                num++;
            }
            sr++;
            
            for(int i = sr; i <= er; i++) {
                ans[i][ec] = num;
                num++;
            }
            ec--;
            
            for(int i = ec; i >= sc; i--) {
                ans[er][i] = num;
                num++;
            }
            er--;
            
            for(int i = er; i >= sr; i--) {
                ans[i][sc] = num;
                num++;
            }
            sc++;
        }
        
        return ans;
    }
};