class Solution {
public:
    int maxArea(int h, int w, vector<int>& horizontalCuts, vector<int>& verticalCuts) {
        sort(horizontalCuts.begin(), horizontalCuts.end());
        sort(verticalCuts.begin(), verticalCuts.end());
        
        horizontalCuts.push_back(h);
        verticalCuts.push_back(w);
        
        int max_width = 0;
        for(int i = 0; i < horizontalCuts.size(); i++) {
            if(i == 0) {
                max_width = max(max_width, horizontalCuts[i]);
            } else { 
                max_width = max(max_width, horizontalCuts[i] - horizontalCuts[i - 1]);
            }
        } 
        
        int max_height = 0;
        for(int i = 0; i < verticalCuts.size(); i++) {
            if(i == 0) {
                max_height = max(max_height, verticalCuts[i]);
            } else { 
                max_height = max(max_height, verticalCuts[i] - verticalCuts[i - 1]);
            }
        } 
        
        return (long)max_width * max_height % 1000000007;
    }
};

static auto _ = [] () {ios_base::sync_with_stdio(0);cin.tie(0);cout.tie(0);return 0;}();