class Solution {
    public String restoreString(String s, int[] indices) {
        int n = indices.length;
        char[] chArr = new char[n];
        for(int i = 0; i < n; i++) {
            chArr[indices[i]] = s.charAt(i);
        }
        String ans = new String(chArr);
        return ans;
    }
}