class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] ans = new int[2*n];
        
        int itr = 0;
        for (int i = 0, j = n; i < n && j < 2*n; i++, j++) {
            ans[itr] = nums[i];
            itr++;
            ans[itr] = nums[j];
            itr++;
        }
        
        return ans;
    }
}