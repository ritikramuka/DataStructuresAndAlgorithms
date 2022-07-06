class Solution {
public:
    int makeConnected(int n, vector<vector<int>>& connections) {
        if(connections.size() < n - 1) return -1;
        vector<int> parent(n);
        vector<int> rank(n);
        for(int i = 0; i < n; i++) parent[i] = i;
        for(vector<int>& connection : connections) {
            int u = connection[0];
            int v = connection[1];
            int pu = find(parent, u);
            int pv = find(parent, v);
            if(pu == pv) continue;
            if(rank[pu] > rank[pv]) parent[pv] = pu;
            else if(rank[pv] < rank[pu]) parent[pu] = pv;
            else { parent[pv] = pu; rank[pu]++; }
        }
        int numOfComp = 0;
        for(int i = 0; i < n; i++) {
            if(find(parent, i) == i) numOfComp++;
        }
        return numOfComp - 1;
    }
    
    int find(vector<int>& parent, int x) {
        if(parent[x] == x) return x;
        return parent[x] = find(parent, parent[x]);
    }
};