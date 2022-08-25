class Solution {

    public boolean canConstruct(String ransomNote, String magazine) {
        int n = magazine.length();
        int[] freq = new int[26];
        for (int i = 0; i < n; i++) freq[magazine.charAt(i) - 'a']++;

        int m = ransomNote.length();
        for (int i = 0; i < m; i++) if (freq[ransomNote.charAt(i) - 'a'] > 0) freq[ransomNote.charAt(i) - 'a']--; else return false;

        return true;
    }
}
