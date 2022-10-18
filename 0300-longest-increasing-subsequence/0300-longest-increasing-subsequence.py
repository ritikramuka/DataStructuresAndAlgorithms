class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        n = len(nums)
		
        dp = [1]*n
        maxLen = 1
        for i in range(n):
            for j in range(i):
                if nums[j] < nums[i]:
                    dp[i] = max(dp[i], dp[j] + 1)       
            maxLen = max(maxLen, dp[i])
		
        return maxLen