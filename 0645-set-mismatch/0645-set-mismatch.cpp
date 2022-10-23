class Solution {
public:
    vector<int> findErrorNums(vector<int>& nums) {
        int n = nums.size();
        int xor1 = 0;
        for (int i = 1; i <= n; i++) {
            xor1 = xor1 xor i;
        }
        int occTwice = 1;
        for (int i = 0; i < n; i++) {
            int num = abs(nums[i]);
            xor1 = xor1 xor num;
            if (nums[num - 1] > 0) {
                nums[num - 1] = -nums[num - 1];
            } else {
                occTwice = num;
            }
        }
        return {occTwice, xor1 xor occTwice};
    }
};