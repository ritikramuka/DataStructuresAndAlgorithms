class Solution {
public:
    string decodeStringToNumString(string& code) {
        string numStr = "";
        unordered_map<int, int> umap;
        int i = 1;
        for(char ch : code) {
            if(umap[ch - 'a'] == 0) {
                umap[ch - 'a'] = i;
            }
            numStr += to_string(umap[ch - 'a']) + " ";
            i++;
        }
        return numStr;
    }
    
    vector<string> findAndReplacePattern(vector<string>& words, string pattern) {
        string decodedPatternString = decodeStringToNumString(pattern);
        vector<string> ans;
        for(string& word : words) {
            string decoded_word = decodeStringToNumString(word);
            if(decoded_word == decodedPatternString) {
                ans.push_back(word);
            }
        }
        return ans;
    }
};