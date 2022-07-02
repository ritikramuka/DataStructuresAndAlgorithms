class Solution {
public:
    class Trie {
        public:
            Trie *childs[26];
            bool eow;
        
            Trie() {
                for(int i = 0; i < 26; i++) childs[i] = NULL;
                eow = false;
            }
    };
    Trie* root;
    
    void insert(string& word) {
        Trie* curr = root;
        for(char ch : word) {
            if(curr->childs[ch - 'a'] == NULL) {
                curr->childs[ch - 'a'] = new Trie();
            }
            curr = curr->childs[ch - 'a'];
        }
        curr->eow = true;
    }
    
    void constructTrie(vector<string>& words) {
        for(string& word : words) {
            insert(word);
        }
    }
    
    bool isConcatenatedWord(string& word, int idx, int count) {
        if(idx == word.size()) {
            return count >= 2;
        }
        
        Trie* curr = root;
        for(int i = idx; i < word.size(); i++) {
            if(curr->childs[word[i] - 'a'] == NULL) {
                return false;
            }
            
            curr = curr->childs[word[i] - 'a'];
            
            if(curr->eow == true) {
                if(isConcatenatedWord(word, i + 1, count + 1) == true) {
                    return true;
                } 
            }
        }
        
        return false;
    }
    
    vector<string> findAllConcatenatedWordsInADict(vector<string>& words) {
        root = new Trie();
        constructTrie(words);
        
        vector<string> ans;
        for(string& word : words) {
            if(isConcatenatedWord(word, 0, 0) == true) {
                ans.push_back(word);
            }    
        }
        
        return ans;
    }
};