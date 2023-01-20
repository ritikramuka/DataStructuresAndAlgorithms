class Solution {
    public boolean isPossibleToDivide(int[] nums, int pen, int maxOpt) {
        int currOpt = 0;
        for (int i = 0; i < nums.length; i++) {
            int divide = (nums[i] - 1) / pen;
            currOpt += divide;
        }
        return currOpt <= maxOpt;
    }

    public int minimumSize(int[] nums, int maxOperations) {
        int lo = 1;
        int hi = 0;
        for (int i = 0; i < nums.length; i++) {
            hi = Math.max(hi, nums[i]);
        }

        int res = -1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (isPossibleToDivide(nums, mid, maxOperations) == true) {
                res = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        return res;
    }
}