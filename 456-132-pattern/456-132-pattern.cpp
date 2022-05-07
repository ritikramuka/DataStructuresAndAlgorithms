class Solution {
public:
    /*
         n1 n3 n2  -> 1 3 2
    */
    bool find132pattern(vector<int>& nums) {
        stack<int> st;
        int n3 = INT_MIN;
        for(int i = nums.size() - 1; i >= 0; i--) {
            if(n3 > nums[i]) {
                return true;
            }else {
                while(st.size() != 0 && st.top() < nums[i]) {
                    n3 = max(n3, st.top());
                    st.pop();
                }    
            }
            st.push(nums[i]);
        }
        return false;
    }
};