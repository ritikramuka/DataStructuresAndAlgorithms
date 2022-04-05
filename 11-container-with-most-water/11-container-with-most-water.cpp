class Solution {
public:
    int maxArea(vector<int>& height) {
        int i=0,j=height.size()-1;
        int area=0;
        while(i<j)
        {
            area=max(area,((j-i)*min(height[i],height[j])));
            if(height[i]>height[j])
                j--;
            else
                i++;
        }
        return area;
    }
};
auto SpeedUp = []() {
    std::ios::sync_with_stdio(false);
    std::cin.tie(nullptr);
    std::cout.tie(nullptr);
    return nullptr;
}();