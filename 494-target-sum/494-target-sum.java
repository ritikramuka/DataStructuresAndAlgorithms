class Solution {
    public int memo(int[] nums, int target, int idx) {
        if(idx == nums.length) {
            if(target == 0) {
                return dpPos[idx][target] = 1;
            }
            if(target < 0) {
                return dpNeg[idx][-target] = 0;
            }
            else {
                return dpPos[idx][target] = 0;   
            }
        }
        
        if(target < 0 && dpNeg[idx][-target] != 0) {
            return dpNeg[idx][-target];
        }
        
        if(target > 0 && dpPos[idx][target] != 0) {
            return dpPos[idx][target];
        }
        
        int pos = memo(nums, target + nums[idx], idx + 1);
        int neg = memo(nums, target - nums[idx], idx + 1);
        
        if(target < 0) {
            dpNeg[idx][-target] = pos + neg;
        }
        
        if(target > 0) {
            dpPos[idx][target] = pos + neg;
        }
        
        return pos + neg;
    }
    
    public int[][] dpPos;
    public int[][] dpNeg;
    public int sum;
    public int findTargetSumWays(int[] nums, int target) {
        sum = 0;
        for(int n : nums) {
            sum += n;
        }
        
        if(target > sum || -target > sum) {
            return 0;
        }
        
        dpPos = new int[nums.length + 1][2 * sum + 1];
        dpNeg = new int[nums.length + 1][2 * sum + 1];
        int ans = memo(nums, target, 0);
        return ans;
    }
}