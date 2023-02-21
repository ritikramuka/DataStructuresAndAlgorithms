class Solution {
    public int singleNonDuplicate(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        
        int lo = 0;
        int hi = nums.length - 1;
        
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            
            if (mid - 1 < 0) {
                if (nums[mid + 1] != nums[mid]) {
                    return nums[mid];
                } else {
                    lo = mid + 1;
                }
            } else if (mid + 1 >= nums.length) {
                if (nums[mid - 1] != nums[mid]) {
                    return nums[mid];
                } else {
                    hi = mid - 1;
                }
            } else {
                if (nums[mid + 1] != nums[mid] && nums[mid - 1] != nums[mid]) {
                    return nums[mid];
                } else {
                    if (nums[mid - 1] == nums[mid]) {
                        if (mid % 2 == 1) {
                            lo = mid + 1;
                        } else {
                            hi = mid - 2;
                        }
                    } else {
                        if (mid % 2 == 0) {
                            lo = mid + 2;
                        } else {
                            hi = mid - 1;
                        }
                    }
                }
            }
        }
        
        return -1;
    }
}