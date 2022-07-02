class Solution {
public:
    class Trie {
    public:
        Trie* childs[26];
        bool eow;
        string word;
        
        Trie() {
            for(int i = 0; i < 26; i++) childs[i] = nullptr;
            eow = false;
            word = "";
        }
    };
    Trie* root;
    
    void insert(string word) {
        Trie* curr = root;
        for(char ch : word) {
            if(curr->childs[ch - 'a'] == nullptr) {
                curr->childs[ch - 'a'] = new Trie();
            }
            curr = curr->childs[ch - 'a'];
        }
        curr->eow = true;
        curr->word = word;
    }
    
    void constructTrie(vector<string>& words) {
        root = new Trie();
        for(string word : words) {
            insert(word);
        }
    }
    
    vector<vector<string>> ans;
    
    void dfs(Trie* curr, vector<string>& sugg) {
        if(sugg.size() == 3) {
            return;
        }
        
        if(curr->eow == true) {
            sugg.push_back(curr->word);
        }
        
        for(int i = 0; i < 26; i++) {
            if(curr->childs[i] != nullptr) {
                dfs(curr->childs[i], sugg);
            }
        }
    }
    
    void find(string word, int si, int ei, vector<string>& sugg) {
        Trie* curr = root;
        for(int i = si; i <= ei; i++) {
            char ch = word[i];
            if(curr->childs[ch - 'a'] == nullptr) {
                return;
            }
            curr = curr->childs[ch - 'a'];
        }
        dfs(curr, sugg);
    }
    
    vector<vector<string>> suggestedProducts(vector<string>& products, string searchWord) {
        constructTrie(products);
        for(int i = 0; i < searchWord.size(); i++) {
            vector<string> sugg;
            find(searchWord, 0, i, sugg);
            ans.push_back(sugg);
        }
        return ans;
    }
};