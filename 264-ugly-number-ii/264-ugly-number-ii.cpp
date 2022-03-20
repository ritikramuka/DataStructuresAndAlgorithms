class Solution {
public:
    int nthUglyNumber(int n) {
        vector<int> dp(n, 0);
        dp[0] = 1;
        int twoIdx = 0, threeIdx = 0, fiveIdx = 0;
        for(int i = 1; i < n; i++) {
            int next = min({2 * dp[twoIdx], 3 * dp[threeIdx], 5 * dp[fiveIdx]});
            dp[i] = next;
            if(next == 2 * dp[twoIdx]) {
                twoIdx++;
            }
            if(next == 3 * dp[threeIdx]) {
                threeIdx++;
            } 
            if(next == 5 * dp[fiveIdx]) {
                fiveIdx++;
            }
        }
        
        return dp[n - 1];
    }
};