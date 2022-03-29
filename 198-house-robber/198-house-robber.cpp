class Solution {
public:
    // recursive   
    int rec(vector<int>& arr, int idx) {
        if(idx >= arr.size()) return 0;
        
        int rob = rec(arr, idx + 2) + arr[idx];
        int notRob = rec(arr, idx + 1);
        
        return max(rob, notRob);
    }    

    // memoization  
    int memo(vector<int>& arr, int idx, vector<int>& dp) {
        if(idx >= arr.size()) return 0;
        
        if(dp[idx] != 0) return dp[idx];
        
        int rob = rec(arr, idx + 2) + arr[idx];
        int notRob = rec(arr, idx + 1);
        
        return dp[idx] = max(rob, notRob);
    }    
    
    int rob(vector<int>& nums) {
        // recursive
        // return rec(arr, 0);
        
        // memoization
        // int n = nums.size();
        // vector<int> dp(n, 0);
        // return memo(nums, 0, dp);
        
        // tabulation
        int n = nums.size();
        if(n == 1) return nums[0]; 
        vector<int> dp(n, 0);
        dp[n - 1] = nums[n - 1];
        dp[n - 2] = max(nums[n - 2], dp[n - 1]);
        for(int i = n - 3; i >= 0; i--) {
            dp[i] = max(dp[i + 1], dp[i + 2] + nums[i]);
        }
        
        return dp[0];
    }
};