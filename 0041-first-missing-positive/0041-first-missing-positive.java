class Solution {
    public int firstMissingPositive(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] >= 1 && nums[i] <= nums.length) {
                int correctPos = nums[i] - 1;
                if (correctPos != i && nums[correctPos] != correctPos + 1) {
                    int temp = nums[correctPos];
                    nums[correctPos] = nums[i];
                    nums[i] = temp;
                } else {
                    i++;
                }
            } else {
                i++;
            }
        }
        
        for (int j = 0; j < nums.length; j++) {
            if (j + 1 != nums[j]) {
                return j + 1;
            }
        }
        
        return nums.length + 1;
    }
}