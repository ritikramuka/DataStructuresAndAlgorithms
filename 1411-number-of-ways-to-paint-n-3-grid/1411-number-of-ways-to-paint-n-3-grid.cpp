class Solution {
public:
    #define MOD 1000000007
    int numOfWays(int n) {
        long long color2 = 6, color3 = 6;
        for (int i = 1; i < n; ++i) {
            long long t1 = color2 * 3 + color3 * 2;
            long long t2 = color2 * 2 + color3 * 2;
            color2 = t1 % MOD;
            color3 = t2 % MOD;
        }
        return (color2 + color3) % MOD;
    }
};