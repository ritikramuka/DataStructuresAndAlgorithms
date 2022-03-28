class Solution {
public:
    bool search(vector<int>& nums, int target) {
        int lb = 0, ub = nums.size() - 1;
        while(lb <= ub) {
            int mid = lb + (ub - lb) / 2;
            
            if(nums[mid] == target) {
                return true;
            }
            
            if((nums[mid] == nums[ub]) && (nums[mid] == nums[lb])) {
                ub--;
                lb++;
            } else if(nums[lb] <= nums[mid]) {
                if((nums[lb] <= target) && (nums[mid] > target)) 
                    ub = mid - 1;
                else 
                    lb = mid + 1; 
            }
            else {
                if((nums[mid] < target) && (nums[ub] >= target)) 
                    lb = mid + 1;
                else 
                    ub = mid - 1;
            }
        }
        
        return false;
    }
};