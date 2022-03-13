class Solution {
public:
    bool isValid(string& s) {
        stack<char> st;
        for(int i = 0; i < s.size(); i++) {
            char ch = s[i];
            if(ch == '(') {
                st.push(ch);
            } else if(ch == ')') {
                if(st.size() == 0) {
                    return false;
                } else {
                    st.pop();
                }
            }
        }
        
        return st.size() == 0;
    }
    
    int getNumberOfInvalidParentheses(string& s) {
        stack<char> st;
        for(int i = 0; i < s.size(); i++) {
            char ch = s[i];
            if(ch == '(') {
                st.push(ch);
            } else if(ch == ')') {
                if(st.size() == 0 or st.top() == ')') {
                    st.push(ch);
                } else {
                    st.pop();
                }
            }
        }
        
        return st.size();
    }
    
    void helper(string s, int invalidParentheses, unordered_set<string>& allState, vector<string>& ans) {
        if(allState.find(s) == allState.end()) {
            allState.insert(s);
        } else {
            return;
        }
        
        if(invalidParentheses == 0) {
            if(isValid(s)) {
                ans.push_back(s);
            }
            return;
        }
        
        for(int i = 0; i < s.size(); i++) {
            char ch = s[i];
            if(ch == '(' or ch == ')') {
                string left = s.substr(0, i);
                string right = s.substr(i + 1);
                helper(left + right, invalidParentheses - 1, allState, ans);
            }
        }
    }
    
    vector<string> removeInvalidParentheses(string s) {
        int invalidParentheses = getNumberOfInvalidParentheses(s);
        unordered_set<string> allState;
        vector<string> ans;
        helper(s, invalidParentheses, allState, ans);
        return ans;
    }
};