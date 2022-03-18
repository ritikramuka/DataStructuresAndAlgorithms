class Solution {
    public boolean canReach(int[] arr, int start) {
        int n = arr.length;
        Queue<Integer> que = new ArrayDeque();
        boolean[] vis = new boolean[n];
        Arrays.fill(vis, false);
        if(start >= 0 && start < n) {
            if(arr[start] == 0)
                return true;
            que.add(start);
            while(que.size() != 0) {
                int ridx = que.remove();
                if(vis[ridx] == true) {
                    continue;
                }
                vis[ridx] = true;
                if(ridx + arr[ridx] < n && ridx + arr[ridx] >= 0) {
                    if(arr[ridx + arr[ridx]] == 0)
                        return true;
                    else 
                        que.add(ridx + arr[ridx]);
                }
                if(ridx - arr[ridx] < n && ridx - arr[ridx] >= 0) {
                    if(arr[ridx - arr[ridx]] == 0)
                        return true;
                    else 
                        que.add(ridx - arr[ridx]);
                }
            }
        }
        
        return false;
    }
}