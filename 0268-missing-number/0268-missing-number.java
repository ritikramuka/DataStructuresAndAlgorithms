class Solution {
    public int missingNumber(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            int correctPos = nums[i];
            if (correctPos != nums.length && correctPos != i) {
                int temp = nums[i];
                nums[i] = nums[correctPos];
                nums[correctPos] = temp;
            } else {
                i++;
            }
        }
        
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != j) {
                return j;
            }
        }
        
        return nums.length;
    }
}