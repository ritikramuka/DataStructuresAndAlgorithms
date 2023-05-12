class Solution {
    void getAllCombinations(String digits, String asf, int pos, String[] letters, ArrayList<String> ans) {
        if (pos == digits.length()) {
            if (asf.length() > 0) {
                ans.add(asf);
            }
            
            return;
        } 
        
        
        char digit = digits.charAt(pos);
        
        String letter = letters[digit - '0'];
        
        for (int i = 0; i < letter.length(); i++) {
            char ch = letter.charAt(i);
            getAllCombinations(digits, asf + ch, pos + 1, letters, ans);
        }
    }
    
    public List<String> letterCombinations(String digits) {
        String[] letters = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        ArrayList<String> ans = new ArrayList<>();
        getAllCombinations(digits, "", 0, letters, ans);
        return ans;
    }
}