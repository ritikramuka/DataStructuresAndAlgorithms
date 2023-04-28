class Solution {
    public int balancedStringSplit(String s) {
        int cntR = 0;
        int cntL = 0;
        int numOfStrings = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == 'R') {
                cntR++;
            } else if (ch == 'L') {
                cntL++;
            }
            
            if (cntR > 0 && cntL > 0 && cntL == cntR) {
                numOfStrings++;
                cntR = 0;
                cntL = 0;
            }
        }
        
        return numOfStrings;
    }
}