class Solution {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[target] = 1;
        for(int tar = target - 1; tar >= 0; tar--) {
            for(int n : nums) {
                if(tar + n <= target)
                    dp[tar] += dp[tar + n];
            }
        }
        return dp[0];
    }
}