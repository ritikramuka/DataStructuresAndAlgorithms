class Solution {
    public boolean validPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while(i < j && s.charAt(i) == s.charAt(j)) {
            i++;
            j--;
        }
        
        if(i >= j) return true;
        
        if(isPalindrome(s, i + 1, j) || isPalindrome(s, i, j - 1)) {
            return true;
        }
        
        return false;
    }
    
    public boolean isPalindrome(String s, int i, int j) {
        while(i < j && s.charAt(i) == s.charAt(j)) {
            i++;
            j--;
        }
        
        return i >= j;
    }
}