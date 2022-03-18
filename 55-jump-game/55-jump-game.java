class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        
        int desti = n - 1;
        for(int i = n - 1; i >= 0; i--) {
            if(i + nums[i] >= desti) {
                desti = i;
            }
        }
        
        return desti == 0;
    }
}