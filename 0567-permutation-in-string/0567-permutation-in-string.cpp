class Solution {
public:
    bool checkInclusion(string s1, string s2) {
        int n = s1.size();
        int m = s2.size();
        
        if (m < n) {
            return false;
        }
        
        vector<int> freq1 (26, 0);
        for (int i = 0; i < n; i++) {
            char ch = s1[i];
            freq1[ch - 'a'] += 1;
        }
        
        int dmcnt = n;
        int mcnt = 0;
        vector<int> freq2 (26, 0);
        for (int i = 0; i < n; i++) {
            char ch = s2[i];
            freq2[ch - 'a'] += 1;
            if (freq2[ch - 'a'] <= freq1[ch - 'a']) {
                mcnt++;
            }
        }
        
        if (dmcnt == mcnt) {
            return true;
        }
        
        for (int i = n; i < m; i++) {
            char exc = s2[i - n];
            freq2[exc - 'a'] -= 1;
            if (freq2[exc - 'a'] < freq1[exc - 'a']) {
                mcnt--;
            }
            
            char inc = s2[i];
            freq2[inc - 'a'] += 1;
            if (freq2[inc - 'a'] <= freq1[inc - 'a']) {
                mcnt++;
            }
            
            if (mcnt == dmcnt) {
                return true;
            }
        }
        
        return false;
    }
};