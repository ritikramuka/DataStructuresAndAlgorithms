class Solution {
public:
    int maxEnvelopes(vector<vector<int>>& envelopes) {
        int n = envelopes.size();
        
        sort(envelopes.begin(), envelopes.end(), [](auto& a, auto& b) {
            if (a[0] == b[0]) {
                return a[1] > b[1];
            } 
            return a[0] < b[0];
        });
        
        vector<int> temp;
        for (int i = 0; i < n; i++) {
            int idx = lower_bound(temp.begin(), temp.end(), envelopes[i][1]) - temp.begin();
            if (idx == temp.size()) {
                temp.push_back(envelopes[i][1]);
            } else {
                temp[idx] = envelopes[i][1];
            }
        }
        
        return temp.size();
    }
};