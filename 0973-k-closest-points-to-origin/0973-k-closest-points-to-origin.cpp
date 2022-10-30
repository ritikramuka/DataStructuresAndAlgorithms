class Solution {
public:
    float dist(int x, int y) {
        return sqrt(x*x + y*y);
    }
    
    vector<vector<int>> kClosest(vector<vector<int>>& points, int k) {
        int n = points.size();
        priority_queue<pair<float, pair<int, int>>> pq;
        for (int i = 0; i < k; i++) {
            float d = dist(points[i][0], points[i][1]);
            pq.push({d, {points[i][0], points[i][1]}});
        }
        
        for (int i = k; i < n; i++) {
            float d = pq.top().first;
            float myDist = dist(points[i][0], points[i][1]);
            if (myDist < d) {
                pq.pop();
                pq.push({myDist, {points[i][0], points[i][1]}});
            }
        }
        
        vector<vector<int>> ans;
        while (pq.size() != 0) {
            ans.push_back({pq.top().second.first, pq.top().second.second});
            pq.pop();
        }
        
        return ans;
    }
};