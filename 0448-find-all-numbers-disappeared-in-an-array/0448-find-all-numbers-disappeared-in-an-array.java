class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
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
        
        List<Integer> ans = new ArrayList<>();
        for (int j = 0; j < nums.length; j++) {
            if (j + 1 != nums[j]) {
                ans.add(j + 1);
            }
        }
        
        return ans;
    }
}