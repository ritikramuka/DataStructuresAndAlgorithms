class Solution {
public:
    bool backspaceCompare(string s, string t) {
        stack<char> sdash;
        stack<char> tdash;
        
        for(char ch : s) {
            if(ch == '#') {
                if(sdash.size() > 0) {
                    sdash.pop();
                }
            } else {
                sdash.push(ch);
            }
        }
        
        for(char ch : t) {
            if(ch == '#') {
                if(tdash.size() > 0) {
                    tdash.pop();
                }
            } else {
                tdash.push(ch);
            }
        }
        
        if(sdash.size() != tdash.size()) {
            return false;
        }
        
        while(sdash.size() != 0) {
            if(sdash.top() != tdash.top()) {
                return false;
            } else {
                sdash.pop();
                tdash.pop();
            }
        }
        
        return true;
    }
};