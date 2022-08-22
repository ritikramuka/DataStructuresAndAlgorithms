class Solution {
public:
    bool isPowerOfFour(int n) {
        return n > 0 and ((n - 1) % 3) == 0 and (n & (n - 1)) == 0;
    }
};