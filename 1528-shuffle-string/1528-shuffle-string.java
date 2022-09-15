class Solution {
    public String restoreString(String s, int[] indices) {
        char[] arr = new char[s.length()];
        for(int i = 0; i < indices.length; i++) {
            int idx = indices[i];
            char ch = s.charAt(i);
            arr[idx] = ch;
        }
        String ans = new String(arr);
        return ans;
    }
}