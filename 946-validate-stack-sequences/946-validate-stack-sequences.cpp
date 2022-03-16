class Solution {
public:
    bool validateStackSequences(vector<int>& pushed, vector<int>& popped) {
        stack<int>st;
        int j=0;
        for(int e : pushed) {
            st.push(e);
            while(!st.empty() && j<pushed.size() && st.top()==popped[j]) {
                st.pop();
                j++;
            }
        }
        return j==pushed.size();
    }
};