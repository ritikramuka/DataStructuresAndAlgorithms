class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        n = len(nums)
        
        maxSum = nums[0];
        currSum = nums[0];
        
        for i in range(1, n):
            sum = currSum + nums[i];
            if sum < nums[i]:
                currSum = nums[i];
            else:
                currSum = sum;
            
            maxSum = max(maxSum, currSum);
        
        return maxSum;