// { Driver Code Starts
#include <bits/stdc++.h>
using namespace std;

 // } Driver Code Ends
class Solution {
  public:
    // Function to detect cycle in an undirected graph.
    
    bool findCycle(int vtx, vector<bool>& vis, vector<int> adj[]) {
        queue<pair<int, int>> que;
        que.push({vtx, -1});
        vis[vtx] = true;
        
        while(que.size()) {
            int node = que.front().first;
            int parent = que.front().second;
            que.pop();
            
            for(int i : adj[node]) {
                if(vis[i] == true) {
                    if(i != parent) {
                        return true;
                    }
                }
                else {
                    vis[i] = true;
                    que.push({i, node});
                }
            }
        }
        
        return false;
    }
    
    bool isCycle(int V, vector<int> adj[]) {
        // Code here
        vector<bool> vis(V, false);
        
        for(int i = 0; i < V; i++) {
            if(vis[i] == false) {
                if(findCycle(i, vis, adj) == true)
                    return true;
            }
        }
        
        return false;
    }
};

// { Driver Code Starts.
int main() {
    int tc;
    cin >> tc;
    while (tc--) {
        int V, E;
        cin >> V >> E;
        vector<int> adj[V];
        for (int i = 0; i < E; i++) {
            int u, v;
            cin >> u >> v;
            adj[u].push_back(v);
            adj[v].push_back(u);
        }
        Solution obj;
        bool ans = obj.isCycle(V, adj);
        if (ans)
            cout << "1\n";
        else
            cout << "0\n";
    }
    return 0;
}  // } Driver Code Ends