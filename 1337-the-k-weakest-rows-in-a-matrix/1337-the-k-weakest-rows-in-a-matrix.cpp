class Solution {
public:
    class comp {
      public:
        bool operator() (pair<int, int>& a, pair<int, int>& b) {
            if(a.first == b.first) {
                return a.second > b.second;
            }
            
            return a.first > b.first;
        }
    };
    
    vector<int> kWeakestRows(vector<vector<int>>& mat, int k) {
        priority_queue<pair<int, int>, vector<pair<int, int>>, comp> pq;
        for(int i = 0; i < mat.size(); i++) {
            int sol = 0;
            for(int j = 0; j < mat[0].size(); j++) {
                if(mat[i][j] == 1)
                    sol++;
                else 
                    break;
            }
            pq.push({sol, i});
        }
        
        vector<int> ans;
        if(k > pq.size())
            k = k % pq.size();
        while(k-- > 0) {
            ans.push_back(pq.top().second);
            pq.pop();
        }
        
        return ans;
    }
};