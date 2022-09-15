class Solution {
    public boolean checkIfPangram(String sentence) {
        sentence = sentence.toLowerCase();
        boolean[] alpha = new boolean[26];
        for(int i = 0; i < sentence.length(); i++) {
            char ch = sentence.charAt(i);
            alpha[ch - 'a'] = true;
        }
        for(int i = 0; i < 26; i++) {
            if(alpha[i] == false) {
                return false;
            }
        }
        return true;
    }
}