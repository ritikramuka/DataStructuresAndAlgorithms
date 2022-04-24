class Solution {
public:
    int memo(vector<int>& stones, int sumLeft, int sumRight, int idx, int n) {
        if(idx == n) {
            return dp[idx][sumLeft] = abs(sumLeft - sumRight);
        }
        
        if(dp[idx][sumLeft]  != -1) {
            return dp[idx][sumLeft] ;
        }
        
        int addToLeft = memo(stones, sumLeft + stones[idx], sumRight, idx + 1, n);
        int addToRight = memo(stones, sumLeft, sumRight + stones[idx], idx + 1, n);
        return dp[idx][sumLeft] = min(addToLeft, addToRight);
    }
    
    int dp[31][3001];
    int lastStoneWeightII(vector<int>& stones) {
        int n = stones.size();
        memset(dp, -1, sizeof(dp));
        int ans = memo(stones, 0, 0, 0, n);
        return ans;
    }
};