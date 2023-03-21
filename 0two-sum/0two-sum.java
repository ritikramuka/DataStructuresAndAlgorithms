class Solution {
    public int[] twoSum(int[] nums, int target) {
        int sum = 0;
        for(int i = 0; i < nums.length; i++) {
            for(int j = i + 1; j < nums.length; j++) {
                sum = nums[i] + nums[j];
                if(sum == target)
                    return new int[] {i, j};
            }
        }
        
        return new int[] {0};
    }
}
