class Solution {
    int dp[20001][5];
    int mod = 1e9 + 7;
    vector<vector<int>> next;
public:
    int memo(int n, int idx) {
        if(n == 1) {
            return dp[n][idx] = 1;
        }
        
        if(dp[n][idx] != 0) {
            return dp[n][idx];
        }
        
        int ans = 0;
        for(int i : next[idx]) {
            ans = (ans + memo(n - 1, i) % mod) % mod;
        }
        
        return dp[n][idx] = ans % mod;
    }
    
    int countVowelPermutation(int n) {
        next.push_back({1});
        next.push_back({0, 2});
        next.push_back({0, 1, 3, 4});
        next.push_back({2, 4});
        next.push_back({0});
        memset(dp, 0, sizeof(dp));
        int ans = 0;
        for(int i = 0; i < 5; i++) {
            ans = (ans + memo(n, i) % mod) % mod;
        }
        return ans;
    }
};