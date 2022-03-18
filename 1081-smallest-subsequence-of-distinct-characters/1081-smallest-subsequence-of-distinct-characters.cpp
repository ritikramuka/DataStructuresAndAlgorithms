class Solution {
public:
    string smallestSubsequence(string s) {
        int n = s.size();
        
        vector<int> lastIndexOfChar(26, -1);
        for(int i = 0; i < n; i++) {
            lastIndexOfChar[s[i] - 'a'] = i;
        }
        
        stack<char> st;
        vector<bool> vis(26, false);
        for(int i = 0; i < n; i++) {
            char ch = s[i];
            if(vis[ch - 'a'] == true) {
                continue;
            }
            while(st.size() > 0 && st.top() > ch && lastIndexOfChar[st.top() - 'a'] > i) {
                vis[st.top() - 'a'] = false;
                st.pop();
            }
            vis[ch - 'a'] = true;
            st.push(ch);
        }
        
        string ans = "";
        while(st.size() > 0) {
            ans += st.top();
            st.pop();
        }
        
        reverse(ans.begin(), ans.end());
        return ans;
    }
};