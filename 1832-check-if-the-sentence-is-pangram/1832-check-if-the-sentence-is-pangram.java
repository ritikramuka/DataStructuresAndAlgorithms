class Solution {

    public boolean checkIfPangram(String str) {
        str = str.toLowerCase();
        for (int i = 0; i < 26; i++) {
            char ch = (char) ('a' + i);
            if (str.indexOf(ch) == -1) {
                return false;
            }
        }
        return true;
    }
}
