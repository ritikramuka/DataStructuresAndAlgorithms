class Solution {
    public int minAddToMakeValid(String s) {
        if (s.length() == 0) {
            return 0;
        }
        
        int open = 0;
        int extra = 0;
        for (char ch: s.toCharArray()) {
            if (ch == '(') {
                open++;
            } else {
                if (open > 0) {
                    open--;    
                } else {
                    extra++;   
                }
            }
        }
        
        return Math.abs(open) + extra;
    }
}