class Solution {
public:
    void BFS(string &ans, string &s, map<int, vector<int>> &graph, int currNode, bool isVisited[]){
        
        queue<int> q;
        set<int> indexes;
        string temp = "";
        q.push(currNode);
        isVisited[currNode] = true;
        
        while(q.empty() == false){
            
            auto node = q.front();
            indexes.insert(node);
            temp += s[node];
            q.pop();
            
            for(auto &cn : graph[node]){
                if( !isVisited[cn] ){
                    q.push(cn);
                    isVisited[cn] = true;
                }
            }
        }
        sort(temp.begin(), temp.end());
        int tIndex = 0;
        for(auto &index : indexes){
            ans[index] = temp[tIndex];
            tIndex += 1;
        }
    }
    
    
    string smallestStringWithSwaps(string s, vector<vector<int>>& pairs) {
       
        int len = s.length();
        map<int, vector<int>> graph;
        bool isVisited[len];
        string ans = s;
        memset(isVisited, 0, sizeof(isVisited));
        
        for(auto &p : pairs){
            graph[p[0]].push_back(p[1]);
            graph[p[1]].push_back(p[0]);
        }
        
        for(auto &p : graph){
            if( !isVisited[p.first] ){
                BFS(ans, s, graph, p.first, isVisited);
            }
        }
        return ans;
    }
};