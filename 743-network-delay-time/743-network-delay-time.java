class Solution {
    
    class Pair implements Comparable<Pair> {
        int v;
        int wsf;
        Pair() {}
        Pair(int v, int wsf) {
            this.v = v;
            this.wsf = wsf;
        }
        public int compareTo(Pair o) {
            return this.wsf - o.wsf;
        }
    }
    
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<Pair>[] adj = new ArrayList[n + 1];
        for(int i = 0; i < n + 1; i++) {
            adj[i] = new ArrayList<Pair>();
        }
        for(var time : times) {
            adj[time[0]].add(new Pair(time[1], time[2]));
        }
        
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>();
        pq.add(new Pair(k, 0));
        int[] durations = new int[n + 1];
        Arrays.fill(durations, -1);
        while(pq.size() != 0) {
            Pair rp = pq.remove();
            if(durations[rp.v] != -1) {
                continue;
            }
            durations[rp.v] = rp.wsf;
            for(var nbr : adj[rp.v]) {
                if(durations[nbr.v] == -1) {
                    pq.add(new Pair(nbr.v, rp.wsf + nbr.wsf));
                }
            }
        }
        
        int maxDuration = -1;
        for(int i = 1; i < n + 1; i++) {
            int duration = durations[i];
            if(duration == -1) {
                return -1;
            }
            maxDuration = Math.max(maxDuration, duration);
        }
        
        return maxDuration;
    }
}