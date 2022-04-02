class Solution {
public:
    int helper(vector<int>& arr, int idx, int time, vector<vector<int>>& dp) {
        if(idx == arr.size()) {
            return dp[idx][time] = 0;
        }
        
        if(dp[idx][time] != -1) {
            return dp[idx][time];
        }
        
        int ans = max(helper(arr, idx + 1, time, dp), helper(arr, idx + 1, time + 1, dp) + arr[idx] * time);
        return dp[idx][time] = ans;
    }
    
    int maxSatisfaction(vector<int>& arr) {
        sort(arr.begin(), arr.end());
        vector<vector<int>> dp(arr.size() + 1, vector<int>(arr.size() + 2, -1));
        int ans = helper(arr, 0, 1, dp);
        return ans;
    }
};