class Solution {
public:
    int numJewelsInStones(string jewels, string stones) {
        unordered_set<char> set;
        for(char ch : jewels)
            set.insert(ch);
        
        int ans = 0;
        for(char ch : stones) {
            if(set.find(ch) != set.end())
                ans++;
        }
        
        return ans;
    }
};