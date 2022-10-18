class Solution {
public:
    int maxEnvelopes(vector<vector<int>>& envelopes) {
        int n = envelopes.size();
        
        sort(envelopes.begin(), envelopes.end(), [](auto& a, auto& b) {
            if(a[0] == b[0]) {
                return a[1] > b[1];
            }
            return a[0] < b[0];
        });
        
        vector<int> dp;
        int maxRussianDoll = 0;
        
        for (int i = 0; i < n; i++) {
            int idx = lower_bound(dp.begin(), dp.end(), envelopes[i][1]) - dp.begin();
            if (idx == dp.size()) {
                dp.push_back(envelopes[i][1]);
                maxRussianDoll++;
            } else {
                dp[idx] = envelopes[i][1];
            }
        }
        
        return maxRussianDoll;
    }
};