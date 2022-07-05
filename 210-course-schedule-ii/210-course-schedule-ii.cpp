class Solution {
public:
    vector<int> findOrder(int n, vector<vector<int>>& pre) {
        vector<vector<int>> gp(n);
        vector<int> indgree(n, 0);
        for(int i = 0; i < pre.size(); i++) {
            gp[pre[i][1]].push_back(pre[i][0]);
            indgree[pre[i][0]]++;
        }
        
        vector<int> topsort(n);
        int idx = 0;
        queue<int> que;
        for(int i = 0; i < n; i++) {
            if(indgree[i] == 0) que.push(i);
        }
        
        vector<bool> vis(n, false);
        while(que.size() != 0) {
            int rvtx = que.front();
            que.pop();
            topsort[idx] = rvtx;
            idx++;
            
            for(int vtx : gp[rvtx]) {
                indgree[vtx]--;
                if(indgree[vtx] == 0) {
                    que.push(vtx);
                }
            }
        }
        
        if(idx == n) {
            return topsort;
        }
        
        return {};
    }
};