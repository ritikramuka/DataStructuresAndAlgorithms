class Solution {
public:
    int lastStoneWeight(vector<int>& stones) {
        priority_queue<int> pq(stones.begin(), stones.end());
        while(pq.size() > 1) {
            int t1 = pq.top();
            pq.pop();
            int t2 = pq.top();
            pq.pop();
            if(t1 != t2) {
                pq.push(t1 - t2);
            }
        }
        
        return pq.size() == 0 ? 0 : pq.top();
    }
};