class Solution {
public:
    string minRemoveToMakeValid(string s) {
        int n = s.size();
        stack<int> st;
        vector<bool> toRemove(n, false);
        
        for(int i = 0; i < n; i++) {
            char ch = s[i];
            if(ch == '(')
                st.push(i);
            else if(ch == ')') {
                if(st.size() > 0 && s[st.top()] == '(') {
                    st.pop();
                } else {
                    toRemove[i] = true;
                }
            }
        }
        
        while(st.size() != 0) {
            toRemove[st.top()] = true;
            st.pop();
        }
        
        string ans = "";
        for(int i = 0; i< n; i++) {
            if(toRemove[i] == true) {
                continue;
            } else {
                ans += s[i];
            }
        }
        
        return ans;
    }
};