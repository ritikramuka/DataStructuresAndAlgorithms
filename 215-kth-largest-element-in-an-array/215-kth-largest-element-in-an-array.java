class Solution {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort (nums);
        int n = nums.length;
        return nums[n - k];
    }
}