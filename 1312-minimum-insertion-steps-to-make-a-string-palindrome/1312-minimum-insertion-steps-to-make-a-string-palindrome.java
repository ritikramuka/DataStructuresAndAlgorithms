class Solution {
    public int memo (String s, int si, int ei, int[][] dp) {
        if (si > ei) {
            return 0;
        }
        
        if (dp[si][ei] != 0) {
            return dp[si][ei];
        }
        
        if (s.charAt(si) == s.charAt(ei)) {
            return dp[si][ei] = memo(s, si + 1, ei - 1, dp);
        } else {
            return dp[si][ei] = Math.min(memo(s, si + 1, ei, dp), memo(s, si, ei - 1, dp)) + 1;
        }
    }
    
    public int minInsertions(String s) {
        int[][] dp = new int[s.length()][s.length()];
        return memo(s, 0, s.length() - 1, dp);
    }
}