class Solution {
    public String restoreString(String s, int[] indices) {
        char[] ans = new char[s.length()];
        for (int i = 0; i < indices.length; i++) {
            char ch = s.charAt(i);
            int idx = indices[i];
            ans[idx] = ch;
        }
        String str = new String(ans);
        return str;
    }
}