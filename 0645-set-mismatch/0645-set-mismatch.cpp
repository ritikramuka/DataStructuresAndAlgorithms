class Solution {
public:
    vector<int> findErrorNums(vector<int>& nums) {
        int n = nums.size();
        vector<int> occ (n, 0);
        for (int i = 0; i < n; i++) {
            occ[nums[i] - 1]++;
        }
        int missingNum, occTwice;
        for (int i = 0; i < n; i++) {
            if (occ[i] == 0) {
                missingNum = i + 1;
            } else if (occ[i] == 2) {
                occTwice = i + 1;
            }
        }
        return {occTwice, missingNum};
    }
};