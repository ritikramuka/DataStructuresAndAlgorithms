class Solution {
public:
    vector<vector<int>> kSmallestPairs(vector<int>& nums1, vector<int>& nums2, int k) {
        auto comp = [](auto& a, auto& b) {
            return a[0] + a[1] > b[0] + b[1];
        };
        priority_queue<vector<int>, vector<vector<int>>, decltype(comp)> maxHeap (comp);
        for (int i = 0; i < nums1.size() && i < k; i++) {
            maxHeap.push({nums1[i], nums2[0], 0});
        }
        
        vector<vector<int>> res;
        while(k-- > 0 && maxHeap.size() != 0){
            vector<int> cur = maxHeap.top();
            maxHeap.pop();
            res.push_back({cur[0], cur[1]});
            if(cur[2] == nums2.size() - 1) continue;
            maxHeap.push({cur[0], nums2[cur[2] + 1], cur[2] + 1});
        }
        return res;
    }
};