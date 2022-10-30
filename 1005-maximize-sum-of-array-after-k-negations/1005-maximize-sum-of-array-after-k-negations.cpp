class Solution {
public:
    int largestSumAfterKNegations(vector<int>& nums, int k) {
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }
        
        priority_queue<int, vector<int>, greater<int>> minHeap (nums.begin(), nums.end());
        while (k-- > 0) {
            int topEle = minHeap.top();
            minHeap.pop();
            sum -= topEle;
            minHeap.push(-topEle);
            sum += (-topEle);
        }
        
        return sum;
    }
};