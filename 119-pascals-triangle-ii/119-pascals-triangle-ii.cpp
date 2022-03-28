class Solution {
public:
    vector<int> getRow(int rowIndex) {
        vector<int> ans(rowIndex + 1, 1);
        int temp = 0;
        for(int i = 0; i <= rowIndex; i++) {
            for(int j = 0; j <= i; j++) {
                if(j == 0 || j == i) {
                    temp = 1;
                    ans[j] = 1;
                } else {
                    int t = ans[j];
                    ans[j] = ans[j] + temp;
                    temp = t;
                }
            }
        }
        
        return ans;
    }
};