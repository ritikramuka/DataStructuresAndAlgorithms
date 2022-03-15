class Solution {
public:
    int trap(vector<int>& height) {
        int n = height.size();
        
        vector<int> leftMax(n, 0);
        int lm = 0;
        for(int i = 0; i < n; i++) {
            leftMax[i] = lm;
            lm = max(lm, height[i]);
        }
        
        vector<int> rightMax(n, 0);
        int rm = 0;
        for(int i = n - 1; i >= 0; i--) {
            rightMax[i] = rm;
            rm = max(rm, height[i]);
        }
        
        int ans = 0;
        for(int i = 0; i < n; i++) {
            int minHt = min(leftMax[i], rightMax[i]);
            if(minHt > height[i]) {
                ans += minHt - height[i];
            }
        }
        
        return ans;
    }
};