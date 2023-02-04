class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        
        if (m < n) {
            return false;
        }
        
        int[] freq1 = new int[26];
        for (int i = 0; i < n; i++) {
            char ch = s1.charAt(i);
            freq1[ch - 'a'] += 1;
        }
        
        int dmcnt = n;
        int mcnt = 0;
        int[] freq2 = new int[26];
        for (int i = 0; i < n; i++) {
            char ch = s2.charAt(i);
            freq2[ch - 'a'] += 1;
            if (freq2[ch - 'a'] <= freq1[ch - 'a']) {
                mcnt++;
            }
        }
        
        if (dmcnt == mcnt) {
            return true;
        }
        
        for (int i = n; i < m; i++) {
            char exc = s2.charAt(i - n);
            freq2[exc - 'a'] -= 1;
            if (freq2[exc - 'a'] < freq1[exc - 'a']) {
                mcnt--;
            }
            
            char inc = s2.charAt(i);
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
}