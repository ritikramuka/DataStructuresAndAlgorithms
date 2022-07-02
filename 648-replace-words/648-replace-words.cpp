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
    Trie *root;
    
    void insert(Trie* root, string& word) {
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
    
    string find(Trie *node, string& word, int idx) {
        if(node == nullptr) {
            return "";
        }
        
        if(node->eow == true) {
            return node->word;
        }
        
        if(idx == word.size()) {
            return "";
        }
        
        return find(node->childs[word[idx] - 'a'], word, idx + 1);
    }
    
    string replaceWords(vector<string>& dictionary, string sentence) {
        root = new Trie();
        for(auto& word : dictionary) {
            insert(root, word);
        }
        
        stringstream stream(sentence);
        string word;
        string ans = "";
        while(stream >> word) {
            string nw = find(root->childs[word[0] - 'a'], word, 1);
            ans += (nw == "") ? word : nw;
            ans += " ";
        }
        
        return ans.substr(0, ans.size() - 1);
    }
};