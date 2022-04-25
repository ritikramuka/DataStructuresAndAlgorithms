class Solution {
public:
    int memo(vector<int>& nums1, vector<int>& nums2, int idx, int n, vector<vector<int>>& dp, int prev1, int prev2, int swap) {
        if(idx == n) {
            return dp[idx][swap] = 0;
        }
        
        if(dp[idx][swap] != -1) {
            return dp[idx][swap];
        }
        
        int whenSwap = 1e8;
        if(nums1[idx] > prev2 && nums2[idx] > prev1) {
            whenSwap = memo(nums1, nums2, idx + 1, n, dp, nums2[idx], nums1[idx], 1) + 1;
        }
        
        int whenNotSwap = 1e8;
        if(nums1[idx] > prev1 && nums2[idx] > prev2) {
            whenNotSwap = memo(nums1, nums2, idx + 1, n, dp, nums1[idx], nums2[idx], 0);
        }
        
        return dp[idx][swap] = min(whenSwap, whenNotSwap);
    }

    int minSwap(vector<int>& nums1, vector<int>& nums2) {
        int n = nums1.size();
        vector<vector<int>> dp(n + 1, vector<int>(2, -1));
        int ans = memo(nums1, nums2, 0, n, dp, -1, -1, 0);
        return ans;
    }
};