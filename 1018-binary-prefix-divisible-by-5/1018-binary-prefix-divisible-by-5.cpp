class Solution {
public:
    vector<bool> prefixesDivBy5(vector<int>& nums) {
        int n = 0;
        vector<bool> ans;
        for(int i = 0; i < nums.size(); i++) {
            if(nums[i] == 1)
                n = n * 2 + 1;
            else 
                n = n * 2;
            
            if(n % 5 == 0)
                ans.push_back(true);
            else
                ans.push_back(false);
            
            n %= 5;
        }
        return ans;
    }
};