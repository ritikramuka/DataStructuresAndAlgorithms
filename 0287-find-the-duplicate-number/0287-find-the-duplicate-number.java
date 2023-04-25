class Solution {
    public int findDuplicate(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            int correctPos = nums[i] - 1;
            if (correctPos != i && nums[correctPos] != correctPos + 1) {
                int temp = nums[i];
                nums[i] = nums[correctPos];
                nums[correctPos] = temp;
            } else {
                i++;
            }
        }
        
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != j + 1) {
                return nums[j];
            }
        }
        
        return -1;
    }
}