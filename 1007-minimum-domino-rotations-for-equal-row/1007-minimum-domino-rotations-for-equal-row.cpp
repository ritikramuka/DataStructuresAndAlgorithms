class Solution {
public:
    int minDominoRotations(vector<int>& tops, vector<int>& bottoms) {
        int n = tops.size();
        int a = tops[0];
        int cnt1 = 0, cnt2 = 0, temp = 0;
        
        for(int i = 1; i < n; i++) {
            if(tops[i] == a and bottoms[i] == a) {
                temp++;
                continue;
            }
            if(tops[i] == a) {
                cnt1++;
            }
            if(bottoms[i] == a) {
                cnt2++;
            }
            
        }
        
        if(cnt1 + cnt2 + temp == n - 1) {
            if(tops[0] == bottoms[0]) {
                return min(cnt1, cnt2);
            }
            return min(cnt1 + 1, cnt2);
        }
        
        a = bottoms[0];
        cnt1 = 0, cnt2 = 0, temp = 0;
        
        for(int i = 1; i < n; i++) {
            if(tops[i] == a and bottoms[i] == a) {
                temp++;
                continue;
            }
            if(tops[i] == a) {
                cnt1++;
            }
            if(bottoms[i] == a) {
                cnt2++;
            }
            
        }
        
        if(cnt1 + cnt2 + temp == n - 1) {
            if(tops[0] == bottoms[0]) {
                return min(cnt1, cnt2);
            }
            return min(cnt1, cnt2 + 1);
        }
        
        return -1;
    }
};