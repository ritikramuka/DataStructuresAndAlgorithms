class Solution {
    public void swap(int[] nums, int si, int ei) {
        int temp = nums[si];
        nums[si] = nums[ei];
        nums[ei] = temp;
    }
    
    public void reverse(int[] nums, int si, int ei) {
        while (si <= ei) {
            swap(nums, si, ei);
            si++;
            ei--;
        }
    }
    
    // TC: O(N), SC: O(1)
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        
        k = k % n;
        
        reverse(nums, n - k, n - 1);
        reverse(nums, 0, n - k - 1);
        reverse(nums, 0, n - 1);
    }
}