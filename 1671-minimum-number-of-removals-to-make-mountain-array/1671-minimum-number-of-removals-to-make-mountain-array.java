class Solution {
    public int minimumMountainRemovals(int[] nums) {
        int n = nums.length;
        
        int[] lis1 = new int[n];
        Arrays.fill(lis1, 1);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    lis1[i] = Math.max(lis1[i], lis1[j] + 1);
                }
            }
        }
        
        int[] lis2 = new int[n];
        Arrays.fill(lis2, 1);
        for (int i = n - 2; i >= 0; i--) {
            for (int j = n - 1; j > i; j--) {
                if (nums[i] > nums[j]) {
                    lis2[i] = Math.max(lis2[i], lis2[j] + 1);
                }
            }
        }
        
        int si = 0;
        while(lis1[si] == 1) {
            si++;
        }
        if (si != 0) {
            si = si - 1;
        }
        
        int ei = n - 1;
        while(lis2[ei] == 1) {
            ei--;
        }
        if (ei != n - 1) {
            ei = ei + 1;
        }
        
        int longestMountainLen = 0;
        for (int i = si; i <= ei; i++) {
            longestMountainLen = Math.max(longestMountainLen, lis1[i] + lis2[i] - 1);
        }
        
        return n - longestMountainLen;
    }
}