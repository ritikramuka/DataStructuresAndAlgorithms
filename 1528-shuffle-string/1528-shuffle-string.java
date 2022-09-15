class Solution {
    public String restoreString(String s, int[] indices) {
        char[] arr = new char[s.length()];
        for(int i = 0; i < indices.length; i++) {
            int idx = indices[i];
            arr[idx] = s.charAt(i);
        }
        String ans = new String(arr);
        return ans;
    }
}