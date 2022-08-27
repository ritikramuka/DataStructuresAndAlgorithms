class Solution {
public:
    int maxSumSubmatrix(vector<vector<int>>& matrix, int K) {
        int n = matrix.size();
        int m = matrix[0].size();
        
        int pSum[n][m + 1];
        memset(pSum, 0, sizeof(pSum));
        for(int i = 0; i < n; i++) {
            for(int j = 1; j <= m; j++) {
                pSum[i][j] = pSum[i][j - 1] + matrix[i][j - 1];
            }
        }
        
        int ans = INT_MIN;
        for(int i = 0; i < m; i++) {
            for(int j = i + 1; j <= m; j++) {
                for(int k = 0; k < n; k++) {
                    int val = 0;
                    for(int l = k; l < n; l++) {
                        val += pSum[l][j] - pSum[l][i];
                        if(val < K) ans = max(val, ans);
                        else if(val == K) return val;
                    }
                }
            }
        }
        
        return ans;
    }
};