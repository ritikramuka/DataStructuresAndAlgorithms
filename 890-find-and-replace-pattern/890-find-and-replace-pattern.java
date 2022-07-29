class Solution {
    public String decodeStringToNumString(String code) {
        String numStr = "";
        int[] umap = new int[26];
        int i = 1;
        for(int itr = 0; itr < code.length(); itr++) {
            char ch = code.charAt(itr);
            if(umap[ch - 'a'] == 0) {
                umap[ch - 'a'] = i;
            }
            numStr += (char)(umap[ch - 'a']) + " ";
            i++;
        }
        return numStr;
    }
    
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        String decodedPatternString = decodeStringToNumString(pattern);
        List<String> ans = new ArrayList();
        for(String word : words) {
            String decoded_word = decodeStringToNumString(word);
            if(decoded_word.equals(decodedPatternString)) {
                ans.add(word);
            }
        }
        return ans;
    }
}