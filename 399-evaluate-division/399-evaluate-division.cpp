class Solution {
public:
    vector<double> calcEquation(vector<vector<string>>& equations, vector<double>& values, vector<vector<string>>& queries) {        
        unordered_map<string, unordered_map<string, double> > m;
        for(int i = 0; i < equations.size(); i++){
            const string& A = equations[i][0];
            const string& B = equations[i][1];
            double k = values[i];
            m[A][B] = k;
            m[B][A] = 1.0 / k;
        }
        
        vector<double> ans;
        for(int i = 0; i < queries.size(); i++){
            const string A = queries[i][0];
            const string B = queries[i][1];   
            if(!m.count(A) || !m.count(B)){
                ans.push_back(-1.0);
                continue;
            }
            unordered_set<string> visited;
            double k = searchDivide(m, A, B, visited);
            ans.push_back(k);            
        }
        return ans;
    }
    
    // dfs: A/B = ?   =  A/C * C/B, where C is one of the neibors of A
    double searchDivide(const unordered_map<string, unordered_map<string, double> >& m, const string& A, const string& B, unordered_set<string>& visited){
        if(A == B) return 1.0;
        visited.insert(A);
        for(auto& pair: m.at(A)){
            const string C = pair.first;
            if(visited.count(C)) continue;
            auto d = searchDivide(m, C, B, visited);
            if(d > 0) return m.at(A).at(C) * d;
        }
        return -1;
    }
};