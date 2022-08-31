class Solution {
    public int rec(int n, int[] memory) {
        if(n == 0) return memory[n] = 1;
        if(n == 1) return memory[n] = 1;
        
        if(memory[n] != 0) return memory[n];
        
        int oneStep = rec(n - 1, memory);
        int twoStep = rec(n - 2, memory);
        
        return memory[n] = (oneStep + twoStep);
    }
    
    public int climbStairs(int n) {
        int[] memory = new int[n + 1];
        int ans = rec(n, memory);
        return ans;
    }
}