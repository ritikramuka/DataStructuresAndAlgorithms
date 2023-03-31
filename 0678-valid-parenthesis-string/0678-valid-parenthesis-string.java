class Solution {
    public boolean checkValidString(String s) {
        int n = s.length();
        
        int left = 0;
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == '*') {
                left++;
            } else {
                left--;
            }
            
            if (left < 0) {
                return false;
            }
        }
        
        if (left == 0) {
            return true;
        }
        
        int right = 0;
        for (int i = n - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            if (ch == ')' || ch == '*') {
                right++;
            } else {
                right--;
            }
            
            if (right < 0) {
                return false;
            }
        }
        
        return true;
    }
}