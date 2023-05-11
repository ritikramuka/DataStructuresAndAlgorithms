class Solution {
public:
    int maxUncrossedLines(vector<int>& A, vector<int>& B) {
        vector<vector<int>> dp(A.size() + 1, vector<int> (B.size() + 1, 0));
        int ans = 0;
        for(int i = A.size(); i >= 0; i--)
            for(int j = B.size(); j>= 0; j--) {
                if(i == A.size() || j == B.size()) {
                    dp[i][j] = 0;
                    continue;
                }
                ans = (A[i] == B[j]) ? dp[i + 1][j + 1] + 1 : max(dp[i + 1][j], dp[i][j + 1]);
                dp[i][j] = ans; 
            }
        
        return ans;
    }
};


auto SpeedUp = []() {
    std::ios::sync_with_stdio(false);
    std::cin.tie(nullptr);
    std::cout.tie(nullptr);
    return nullptr;
}();