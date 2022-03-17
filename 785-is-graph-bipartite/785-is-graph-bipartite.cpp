class Solution {
public:
    bool helper(int i, vector<vector<int>>& graph, vector<bool>& visited, vector<int>& color) {
        queue<int> que;
        que.push(i);
        int level = 1;
        while(que.size() != 0) {
            int size = que.size();
            while(size-->0) {
                int r = que.front();
                que.pop();
                if(visited[r] == true) {
                    if(color[r] != level % 2) {
                        return false;
                    }
                }
                visited[r] = true;
                color[r] = level % 2;
                for(auto& a : graph[r]) {
                    if(visited[a] == false) {
                        que.push(a);
                    }
                }
            }
            level++;
        }
        
        return true;
    }
    
    bool isBipartite(vector<vector<int>>& graph) {
        int n = graph.size();
        vector<bool> visited(n, false);
        vector<int> color(n, 0);
        
        for(int i = 0; i < n; i++) {
            if(visited[i] == false) {
                if(helper(i, graph, visited, color) == false) {
                    return false;
                }
            }
        }
        
        return true;
    }
};