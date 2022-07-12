class Solution {
public:
    int rec(vector<int>& matchsticks, int idx, int n, int a, int b, int c, int d) {
        if(idx == n) {
            if(a == 0 && b == 0 && c == 0 && d == 0) return true;
            else return false;
        }
        
        if(matchsticks[idx] <= a) if(rec(matchsticks, idx + 1, n, a - matchsticks[idx], b, c, d)) return true;
        if(matchsticks[idx] <= b) if(rec(matchsticks, idx + 1, n, a, b - matchsticks[idx], c, d)) return true;
        if(matchsticks[idx] <= c) if(rec(matchsticks, idx + 1, n, a, b, c - matchsticks[idx], d)) return true;
        if(matchsticks[idx] <= d) if(rec(matchsticks, idx + 1, n, a, b, c, d - matchsticks[idx])) return true;
        
        return false;
    }
    
    bool makesquare(vector<int>& matchsticks) {
        int n = matchsticks.size();
        int length = 0;
        for(int matchstick : matchsticks) length += matchstick;
        if(length % 4 != 0) return false;
        int side = length / 4;
        int a = side, b = side, c = side, d = side;
        sort(matchsticks.rbegin(), matchsticks.rend());
        return rec(matchsticks, 0, n, a, b, c, d);
    }
};