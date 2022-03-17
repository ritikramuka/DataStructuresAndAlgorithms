class Solution {
public:
    int scoreOfParentheses(string S) {
        stack<int> st;
        st.push(0);
        for(char ch : S) {
            if(ch == '(')
                st.push(0);
            else {
                int a = st.top(); st.pop();
                int b = st.top(); st.pop();
                st.push(max(1, 2 * a) + b);
            }
        }
        return st.top();
    }
};