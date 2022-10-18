class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        
        int maxSum = nums[0];
        int currSum = nums[0];
        for (int i = 1; i < n; i++) {
            int sum = currSum + nums[i];
            if (sum < nums[i]) {
                currSum = nums[i];
            } else {
                currSum = sum;
            }
            
            maxSum = Math.max(maxSum, currSum);
        }
        
        return maxSum;
    }
}