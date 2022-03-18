class Solution {
    public int memoJump(int[] nums, int idx, int[] dp) {
        if(idx >= nums.length - 1) {
            return 0;
        }
        
        if(dp[idx] != -1) {
            return dp[idx];
        }
        
        int ans = Integer.MAX_VALUE;
        for(int i = 1; i <= nums[idx]; i++) {
            int t1 = memoJump(nums, idx + i, dp);
            int t2 = t1 == Integer.MAX_VALUE ? Integer.MAX_VALUE : t1 + 1;
            ans = Math.min(ans, t2);
        }
        
        return dp[idx] = ans;
    }
    
    public int jump(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        int ans = memoJump(nums, 0, dp);
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}