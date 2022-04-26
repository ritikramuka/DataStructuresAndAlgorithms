class Solution {
public:
    int minCostConnectPoints(vector<vector<int>>& points) {
        int n = points.size();
        
        vector<int>parents;
        vector<pair<int, pair<int, int>>> graph;
        
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++) {
                int manhattan = abs(points[i][0] - points[j][0]) + abs(points[i][1] - points[j][1]);      
                graph.push_back({manhattan, {i, j}});
            }
        }
        
        sort(graph.begin(), graph.end());
        vector<int>parent(n, -1);
        int ans=0;
        
        for(int i = 0; i < graph.size(); i++) { 
            int a = findParent(graph[i].second.first,parent);
            int b = findParent(graph[i].second.second,parent);
            
            if(a != b) {
                ans += graph[i].first;
                uni(a, b, parent);
            }
        }
        
        return ans;
    }
    
    int findParent(int i, vector<int>& parent) {
        if(parent[i] < 0) return i;
        return parent[i] = findParent(parent[i], parent);
    }
    
    void uni(int i, int j, vector<int>& parent){
        parent[i] = j;
    }
};