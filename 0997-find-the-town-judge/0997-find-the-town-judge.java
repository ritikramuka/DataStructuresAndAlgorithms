class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] trustee = new int[n + 1];
        int[] trusts = new int[n + 1];
        
        for(var t : trust) {
            trusts[t[1]]++;
            trustee[t[0]]++;
        }
        
        for(int i = 1; i < n + 1; i++) {
            if(trusts[i] == n - 1 && trustee[i] == 0) {
                return i;
            }
        }
        
        return -1;
    }
}