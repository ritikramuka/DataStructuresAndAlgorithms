class Solution {
public:
    bool isValid(string s) {
        stack<int> st;
        st.push(s[0]);
        for(int i = 1; i < s.size(); i++) {
            char ch = s[i];
            if(ch == '(' or ch == '[' or ch == '{') {
                st.push(ch);
            } else if(ch == ')') {
                if(st.size() and st.top() == '(')
                    st.pop();
                else
                    return false;
            } else if(ch == '}') {
                if(st.size() and st.top() == '{')
                    st.pop();
                else
                    return false;
            } else if(ch == ']') {
                if(st.size() and st.top() == '[')
                    st.pop();
                else
                    return false;
            }
        }
        
        return st.size() == 0;
    }
};