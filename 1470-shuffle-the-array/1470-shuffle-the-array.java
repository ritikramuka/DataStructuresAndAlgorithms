class Solution {
    public int[] shuffle(int[] nums, int n) {
        int ans[] = new int[2 * n];
        for (int i = 0, j = 0; i < n && j < 2 * n; i++, j += 2) {
            ans[j] = nums[i];
            ans[j + 1] = nums[n + i];
        }
        return ans;
    }
}