class TreeAncestor {
    int[][] parentJumps;
    int maxJumps;
    public TreeAncestor(int n, int[] parent) {
        maxJumps = (int) (Math.log(n) / Math.log(2)) + 1;
        parentJumps = new int[maxJumps][n];
        
        parentJumps[0] = parent;
        for(int r = 1; r < maxJumps; r++) {
            for(int c = 0; c < n; c++) {
                int temp = parentJumps[r - 1][c];
                parentJumps[r][c] = temp == -1 ? -1 : parentJumps[r - 1][temp];
            }
        }
    }
    
    public int getKthAncestor(int node, int k) {
        int ans = -1;
        int i = maxJumps;
        while(k > 0 && node != -1) {
            if(k >= (1 << i)) {
                ans = parentJumps[i][node];
                node = parentJumps[i][node];
                k -= (1 << i);
            } else {
                i--;
            }
        }
        return ans;
    }
}

/**
 * Your TreeAncestor object will be instantiated and called as such:
 * TreeAncestor obj = new TreeAncestor(n, parent);
 * int param_1 = obj.getKthAncestor(node,k);
 */