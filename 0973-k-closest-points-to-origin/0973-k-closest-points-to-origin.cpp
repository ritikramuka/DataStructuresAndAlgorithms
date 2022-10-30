class Solution {
public:
    // Euclidean distance
    float dist (int x, int y) {
        // distance from origin
        return sqrt (x * x + y * y);
    }
    
    // pq -> {dist, {x, y}}
    vector<vector<int>> kClosest(vector<vector<int>>& points, int k) {
        priority_queue<pair<float, pair<int, int>>> maxHeap;
        for (int i = 0; i < k && i < points.size(); i++) {
            vector<int> point = points[i];
            float myDist = dist(point[0], point[1]);
            maxHeap.push({myDist, {point[0], point[1]}});
        }
        
        for (int i = k; i < points.size(); i++) {
            vector<int> point = points[i];
            float myDist = dist(point[0], point[1]);
            if (myDist < maxHeap.top().first) {
                maxHeap.pop();
                maxHeap.push({myDist, {point[0], point[1]}});
            }
        }
        
        vector<vector<int>> ans;
        while (maxHeap.size() != 0) {
            ans.push_back({maxHeap.top().second.first, maxHeap.top().second.second});
            maxHeap.pop();
        }
        
        return ans;
    }
};