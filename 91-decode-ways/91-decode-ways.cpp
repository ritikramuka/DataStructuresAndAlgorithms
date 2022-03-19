class Solution {
public:
    int numDecodings(string s) {
        // prev1 -> i + 1 dp, prev2 -> i + 2 dp
        int prev1 = 1, prev2 = 0;
        for(int i = s.length() - 1; i >= 0; --i) {
            int curr = 0;
            if(s[i] != '0') {
                curr += prev1;
            }
            if(i + 1 < s.length() && (s[i] == '1' || s[i] == '2' && s[i+1] <= '6')) {
                curr += prev2;
            }
            prev2 = prev1;
            prev1 = curr;
        }
        
        return prev1;
    }
};