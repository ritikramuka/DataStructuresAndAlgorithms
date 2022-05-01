class Solution {
public:
    bool backspaceCompare(string s, string t) {
        int i = s.size() - 1, j = t.size() - 1;
        while(i >= 0 || j >= 0) {
            int backSpace = 0;
            while(i >= 0) {
                if(s[i] == '#') {
                    i--;
                    backSpace++;
                } else if(backSpace > 0) {
                    i--;
                    backSpace--;
                } else {
                    break;
                }
            }
            
            backSpace = 0;
            while(j >= 0) {
                if(t[j] == '#') {
                    j--;
                    backSpace++;
                } else if(backSpace > 0) {
                    j--;
                    backSpace--;
                } else {
                    break;
                }
            }
            
            if(i < 0 && j < 0) {
                return true;
            }
            
            if(i < 0 || j < 0) {
                return false;
            }
            
            if(s[i] != t[j]) {
                return false;
            }
            
            i--;
            j--;
        }
        
        return true;
    }
};