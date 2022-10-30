class Solution {
public:
    int lastStoneWeight(vector<int>& stones) {
        priority_queue<int> maxHeap (stones.begin(), stones.end());
        while (maxHeap.size() >= 2) {
            int stone1 = maxHeap.top();
            maxHeap.pop();
            int stone2 = maxHeap.top();
            maxHeap.pop();
            
            int remain = stone1 - stone2;
            if (remain != 0) {
                maxHeap.push(remain);
            }
        }
        return maxHeap.size() == 0 ? 0 : maxHeap.top();
    }
};