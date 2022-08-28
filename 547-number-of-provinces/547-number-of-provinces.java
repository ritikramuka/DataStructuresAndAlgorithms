class Solution {
    private void dfs(int x, int[][] isConnected, boolean[] vis) {
        vis[x] = true;
        for(int col = 0; col < isConnected[x].length; col++) {
            if(isConnected[x][col] == 1 && vis[col] == false) {
                dfs(col, isConnected, vis);
            }
        }
    }
    
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        
        int numOfProvinces = 0;
        
        boolean[] vis = new boolean[n];
        for(int i = 0; i < n; i++) {
            if(vis[i] == false) {
                numOfProvinces += 1;
                dfs(i, isConnected, vis);
            }
        }
        
        return numOfProvinces;
    }
}