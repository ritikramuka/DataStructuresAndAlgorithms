class Solution {
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        vector<vector<string>> ans;
        unordered_map<string,vector<string>> umap;
        for(string& str : strs) {
            vector<int>freq (26, 0);
            for(char ch : str)
                freq[ch - 'a']++;
            
            string code = "";
            for(int i = 0; i < 26; i++)
                if(freq[i] != 0)
                    code += string(1, (char)(i + 'a')) + "" + to_string(freq[i]);
            
            umap[code].push_back(str);
        }
        
        for(auto& a : umap) 
            ans.push_back(a.second);
        
        return ans;
    }
};