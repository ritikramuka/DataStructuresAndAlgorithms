class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] ans = new int[2*n];
        
        int i = 0;
        int j = n;
        
        int itr = 0;
        
        while (i < n && j < 2*n) {
            ans[itr] = nums[i];
            i++;
            itr++;
            
            ans[itr] = nums[j];
            j++;
            itr++;
        }
        
        return ans;
    }
}