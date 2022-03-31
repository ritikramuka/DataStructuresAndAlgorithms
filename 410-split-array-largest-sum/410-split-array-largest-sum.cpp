class Solution {
public:
    #define ll long long
    int splitArray(vector<int>& nums, int m) {
        ll sum = 0;
        int maxEle = 0;
        for(int i : nums) {
            sum += i;
            maxEle = max(maxEle, i);
        }
        
        ll lb = maxEle, ub = sum;
        while(lb < ub) {
            int mid = (lb + ub) / 2;
            if(isPossible(nums, mid, m) == true) {
                ub = mid;
            } else {
                lb = mid + 1;
            }
        }
        
        return lb;
    }
    
    bool isPossible(vector<int>& nums, ll sum, int m) {
        ll curSum = 0;
        for(int num : nums) {
            if(curSum + num <= sum) {
                curSum += num;
            } else {
                if((--m) == 0) 
                    return false;
                curSum = num;
            }
        }
        
        return curSum <= sum;
    }
};