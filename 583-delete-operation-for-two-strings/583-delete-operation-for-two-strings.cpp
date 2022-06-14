class Solution {
public:
    int LIS(string word1, string word2, int i, int j) {
        if(i == word1.size() || j == word2.size()) {
            return dp[i][j] = 0;
        }
        
        if(dp[i][j] != -1) {
            return dp[i][j];
        }
        
        if(word1[i] == word2[j]) {
            return dp[i][j] = LIS(word1, word2, i + 1, j + 1) + 1;
        } else {
            return dp[i][j] = max({LIS(word1, word2, i + 1, j), LIS(word1, word2, i, j + 1), LIS(word1, word2, i + 1, j + 1)});
        }
    }
    
    int dp[501][501];
    int minDistance(string word1, string word2) {
        memset(dp, -1, sizeof(dp));
        int lis = LIS(word1, word2, 0, 0);
        return word1.size() + word2.size() - 2*lis;
    }
};