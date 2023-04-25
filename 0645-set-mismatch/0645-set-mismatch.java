class Solution {
    public int[] findErrorNums(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            int correctPos = nums[i] - 1;
            if (correctPos != i && nums[correctPos] != correctPos + 1) {
                int temp = nums[correctPos];
                nums[correctPos] = nums[i];
                nums[i] = temp;
            } else {
                i++;
            }
        }
        
        int[] ans = new int[2];
        for (int j = 0; j < nums.length; j++) {
            if (j + 1 != nums[j]) {
                ans[0] = nums[j];
                ans[1] = j + 1;
            }
        }
        
        return ans;
    }
}