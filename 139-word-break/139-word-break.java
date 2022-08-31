class Solution {
    public int rec(String s, List<String> wordDict, int idx, int[] cache) {
        if(idx == s.length()) return cache[idx] = 1;
        
        if(cache[idx] != 0) return cache[idx];
        
        int ans = -1;
        for(int i = idx + 1; i <= s.length(); i++) {
            String substr = s.substring(idx, i);
            if(wordDict.contains(substr) == true) {
                int myAns = rec(s, wordDict, i, cache);
                if(myAns == 1) ans = 1;
            }
        }
        
        return cache[idx] = ans;
    }
    
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        int[] cache = new int[n + 1];
        Arrays.fill(cache, 0);
        int ans = rec(s, wordDict, 0, cache);
        return (ans == 1);
    }
}