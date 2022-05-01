class Solution {
    public boolean backspaceCompare(String s, String t) {
        int i = s.length() - 1, j = t.length() - 1;
        while(i >= 0 || j >= 0) {
            int backSpace = 0;
            while(i >= 0) {
                if(s.charAt(i) == '#') {
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
                if(t.charAt(j) == '#') {
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
            
            if(s.charAt(i) != t.charAt(j)) {
                return false;
            }
            
            i--;
            j--;
        }
        
        return true;
    }
}