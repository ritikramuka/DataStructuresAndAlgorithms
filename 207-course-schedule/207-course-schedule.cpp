class Solution {
public:
    bool canFinish(int numCourses, vector<vector<int>>& prerequisites) {
        vector<int> indgree(numCourses, 0);
        for(vector<int>& pair : prerequisites) {
            indgree[pair[0]]++;
        }
        
        vector<int> adj[numCourses];
        for(vector<int>& pair : prerequisites) {
            adj[pair[1]].push_back(pair[0]);
        }
        
        queue<int> que;
        for(int i = 0; i < numCourses; i++) {
            if(indgree[i] == 0) {
                que.push(i);
            }
        }
        
        int courseCanTaken = 0;
        while(que.size() != 0) {
            courseCanTaken++;
            int ridx = que.front();
            que.pop();
            
            for(int nbr : adj[ridx]) {
                indgree[nbr]--;
                if(indgree[nbr] == 0) {
                    que.push(nbr);
                }
            }
        }
        
        return courseCanTaken == numCourses;
    }
};