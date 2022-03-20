class Solution {
public:
    #define MOD 1000000007
    #define ll long long
    int distinctSubseqII(string s) {
        int n = s.size();
        vector<int> lastOccurrenceOf(26, -1);
        vector<ll> dp(n + 1, 0);
        dp[0] = 1;
        for(int i = 0; i < n; i++) {
            dp[i + 1] = dp[i] * 2 % MOD;
            if(lastOccurrenceOf[s[i] - 'a'] != -1) {
                dp[i + 1] -= dp[lastOccurrenceOf[s[i] - 'a'] - 1];
            } 
            dp[i + 1] %= MOD;
            lastOccurrenceOf[s[i] - 'a'] = i + 1;
        }
        
        return dp[n] - 1 < 0 ? dp[n] += MOD - 1 : dp[n] - 1;
    }
};