class Solution {
    public int firstUniqChar(String s) {
        int n = s.length();
        int[][] memory = new int[26][2];
        for(int i = 0; i < 26; i++) {
            Arrays.fill(memory[i], -1);
        }
        for(int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            memory[ch - 'a'][0] = i;
            memory[ch - 'a'][1]++;
        }
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < 26; i++) {
            if(memory[i][0] != -1 && memory[i][1] == 0 && ans > memory[i][0]) {
                ans = memory[i][0];
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}