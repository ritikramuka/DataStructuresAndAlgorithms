class Solution {
public:
    
    // {sum, nums1_idx, nums2_idx}
    vector<vector<int>> kSmallestPairs(vector<int>& nums1, vector<int>& nums2, int k) {
        auto comp = [](auto& a, auto& b) {
            return a[0] > b[0];    
        };
        
        priority_queue<vector<int>, vector<vector<int>>, decltype(comp)> minHeap(comp);
        for (int i = 0; i < k && i < nums1.size(); i++) {
            minHeap.push({nums1[i] + nums2[0], i, 0});
        }
        
        vector<vector<int>> ans;
        while (k-- > 0 && minHeap.size() != 0) {
            vector<int> temp = minHeap.top();
            minHeap.pop();
            ans.push_back({nums1[temp[1]], nums2[temp[2]]});
            if (temp[2] + 1 < nums2.size()) {
                minHeap.push({nums1[temp[1]] + nums2[temp[2] + 1], temp[1], temp[2] + 1});
            }
        }
        
        return ans;
    }
};