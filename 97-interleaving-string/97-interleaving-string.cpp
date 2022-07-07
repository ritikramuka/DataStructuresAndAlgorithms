class Solution {
public:
    bool help(string& s1, int i, string& s2, int j, string& s3, int k, vector<vector<int>>& dp) {
        if(dp[i][j] != -1)
            return dp[i][j];
        
        if(i == s1.length() && j == s2.length() && k == s3.length())
            return true;
        
        bool ans = false;
        
        if(i < s1.length() && s1[i] == s3[k])
            ans |= help(s1, i + 1, s2, j, s3, k + 1, dp);
        if(j < s2.length() && s2[j] == s3[k])
            ans |= help(s1, i, s2, j + 1, s3, k + 1, dp);
        
        return dp[i][j] = ans;
    }
    
    bool isInterleave(string s1, string s2, string s3) {
        if(!s1.length() || !s2.length()) {
            return !s1.length() ? s2 == s3 : s1 == s3;
        }
        if(s1.length() + s2.length() != s3.length())
            return false;
        
        vector<vector<int>> dp(s1.length() + 1, vector<int>(s2.length() + 1, -1));
        return help(s1, 0, s2, 0, s3, 0, dp);
    }
};