class Solution {
public:
    int memo(int day, unordered_set<int>& set, vector<int>& costs, vector<int>& dp) {
        if(day >= 366) {
            return 0;
        }
        
        if(dp[day] != 0) {
            return dp[day];
        } 
        
        if(set.find(day) != set.end()) {
            return dp[day] = min({memo(day + 1, set, costs, dp) + costs[0], memo(day + 7, set, costs, dp) + costs[1], memo(day + 30, set, costs, dp) + costs[2]});
        } else {
            return dp[day] = memo(day + 1, set, costs, dp);
        }
    }
    
    int mincostTickets(vector<int>& days, vector<int>& costs) {
        unordered_set<int> set (days.begin(), days.end());
        vector<int> dp(366, 0);
        return memo(1, set, costs, dp);
    }
};
auto SpeedUp = []() {
    std::ios::sync_with_stdio(false);
    std::cin.tie(nullptr);
    std::cout.tie(nullptr);
    return nullptr;
}();