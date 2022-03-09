class Solution {
public:
    string swapChar(string str, int i, int j) {
        char temp = str[i];
        str[i] = str[j];
        str[j] = temp;
        return str;
    }
    
    int slidingPuzzle(vector<vector<int>>& board) {
        vector<vector<int>> swaps = {{1, 3}, {0, 2, 4}, {1, 5}, {0, 4}, {3, 1, 5}, {4, 2}};
        string initial = "";
        for(auto& a : board) {
            for(auto& b : a) {
                initial += to_string(b);
            }
        }
        
        string finalStr = "123450";
        
        unordered_set<string> set; 
        queue<string> que;
        que.push(initial);
        set.insert(initial);
        int level = 0;
        while(que.size() != 0) {
            int size = que.size();
            while(size-->0) {
                string rstring = que.front();
                que.pop();
                if(rstring == finalStr) {
                    return level;
                }
                
                int zeroIdx;
                for(int i = 0; i < rstring.length(); i++) {
                    if(rstring[i] == '0') {
                        zeroIdx = i;
                        break;
                    }
                }
                
                vector<int> swapIdx = swaps[zeroIdx];
                for(int i = 0; i < swapIdx.size(); i++) {
                    string str = swapChar(rstring, zeroIdx, swapIdx[i]);
                    if(set.find(str) == set.end()) {
                        set.insert(str);
                        que.push(str);
                    }
                }
            }
            level++;
        }
        
        return -1;
    }
};