class Solution {
    public int longestCycle(int[] edges) {
        int n = edges.length;
        
        int[] vis = new int[n];
        Arrays.fill(vis, -1);
        
        int len = 0;
        
        for (int i = 0; i < n; i++) {
            if (vis[i] == -1) {
                boolean[] pass = new boolean[n];
                Queue<Integer> que = new ArrayDeque<>();
                que.add(i);
                vis[i] = 0;
                pass[i] = true;
                int cnt = 0;
                while (que.size() != 0) {
                    int size = que.size();
                    while (size-->0) {
                        int node = que.remove();
                        int next = edges[node];
                        if (next == -1) {
                            break;   
                        }
                        if (vis[next] == -1) {
                            pass[next] = true;
                            vis[next] = ++cnt;
                            que.add(next);
                        } else {
                            if (pass[next] == true) {
                                len = Math.max(len, cnt - vis[next] + 1);   
                            }
                        }
                    }
                }
            }
        }
        
        return len == 0 ? -1 : len;
    }
}