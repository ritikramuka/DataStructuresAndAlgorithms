class Solution {
    // alphanumeric -> 'a' - 'z', '0' - '9', 'A' - 'Z'
    // non-alphanumeric -> rest of char    
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int i = 0;
        int j = s.length() - 1;
        
        while (i < j) {
            while ((s.charAt(i) < 'a' || s.charAt(i) > 'z') && (s.charAt(i) < '0' || s.charAt(i) > '9') && i < j) {
                i++;
            }
            while ((s.charAt(j) < 'a' || s.charAt(j) > 'z') && (s.charAt(j) < '0' || s.charAt(j) > '9') && i < j) {
                j--;
            }
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        
        return true;
    }
}