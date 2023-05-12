class Solution {
    
    void getCombinations(String digits, int pos, String asf, String[] letter, List<String> ans) {
        if (pos == digits.length()) {
            if (asf.length() > 0) {
                ans.add(asf);
            }
            return;
        } 
        
        char digit = digits.charAt(pos);
        for (int i = 0; i < letter[digit - '0'].length(); i++) {
            getCombinations(digits, pos + 1, asf + letter[digit - '0'].charAt(i), letter, ans);
        }
    }
    
    public List<String> letterCombinations(String digits) {
        String[] letter = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> ans = new ArrayList<>();
        
        getCombinations(digits, 0, "",letter, ans);
        
        return ans;
    }
}