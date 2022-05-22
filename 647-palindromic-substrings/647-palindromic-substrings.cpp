class Solution {
public:
    int dp[1001][1001];
    int countSubstrings(string s) {
        memset(dp, -1, sizeof(dp));
        int n = s.size();
        int ans = 0;
        for(int i = 0; i < n; i++) {
            for(int j = n - 1; j >= i; j--) {
                ans += memo(s, i, j);
            }
        }
        return ans;
    }
    
    int memo(string& s, int si, int ei) {
        if(si > ei) {
            return 1;
        }
        
        if(s[si] != s[ei]) {
            return dp[si][ei] = 0;
        }
        
        if(dp[si][ei] != -1) {
            return dp[si][ei];
        }
        
        if(memo(s, si + 1, ei - 1) == 1) {
            return dp[si][ei] = 1;
        }
        
        return dp[si][ei] = 0;
    }
};