class Solution {
public:
    int lengthOfLIS(vector<int>& nums) {
        int n = nums.size();
        vector<int> lis(n + 1, 1);
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < i; ++j) {
                if(nums[j] < nums[i]) 
                    lis[i] = max(lis[i], lis[j] + 1);
            }
        }
        
        int ans = 0;
        for(int e : lis)
            ans = max(ans, e);
        
        return ans;
    }
};