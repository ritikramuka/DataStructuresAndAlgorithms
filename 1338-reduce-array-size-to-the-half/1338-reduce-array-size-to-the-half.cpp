class Solution {
public:
    int minSetSize(vector<int>& arr) {
        unordered_map<int, int> freq;
        for(int a : arr) freq[a]++;
        priority_queue<int> pq;
        for(auto& [_, cnt] : freq) pq.push(cnt);
        int ans = 0, n = arr.size() / 2, removed = 0;
        while(removed < n) {
            removed += pq.top();
            pq.pop();
            ans++;
        }
        return ans;
    }
};