class Solution {
public:
    int coinChange(vector<int>& coins, int amount) {
        vector<vector<int>> dp(13, vector<int>(10001, INT_MAX));
        int ans = memo(coins, amount, 0, dp);
        return ans == INT_MAX or ans == INT_MAX - 1 ? -1 : ans;
    }
    
    int memo(vector<int>& coins, int amount, int idx, vector<vector<int>>& dp) {
        if(amount == 0) {
            return dp[idx][amount] = 0;
        }
        
        if(idx == coins.size()) {
            return dp[idx][amount] = INT_MAX - 1;
        }
        
        if(dp[idx][amount] != INT_MAX) {
            return dp[idx][amount];
        }
        
        int inc = INT_MAX, exc = INT_MAX;
        if(amount - coins[idx] >= 0) {
            inc = memo(coins, amount - coins[idx], idx, dp) + 1;
        }
        
        exc = memo(coins, amount, idx + 1, dp);
        
        return dp[idx][amount] = min(inc, exc);
    }
};