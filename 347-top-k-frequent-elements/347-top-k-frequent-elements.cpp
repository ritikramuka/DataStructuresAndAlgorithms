class Solution {
public:
    vector<int> topKFrequent(vector<int>& nums, int k) {
        unordered_map<int,int> umap;
        for(int e : nums)
            umap[e]++;
        
        priority_queue<pair<int,int>,vector<pair<int,int>>,greater<pair<int,int>>>pq;
        for(auto& a : umap) {
            pq.push({a.second,a.first});
            if(pq.size()>k)
                pq.pop();
        }
        
        vector<int>ans;
        while(pq.size()!=0) {
            ans.push_back(pq.top().second);
            pq.pop();
        }
        return ans;
    }
};