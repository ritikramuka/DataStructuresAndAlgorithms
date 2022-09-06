class Trie {
private:    
    class TrieNode {
    public:
        bool eow = false;
        TrieNode* children[26] = {};
    };
    
    TrieNode* root;
    
    TrieNode* getNode(string str) {
        TrieNode* curr = root;
        
        for(char ch : str) {
            if(curr->children[ch - 'a'] == nullptr) {
                return nullptr;
            }
            curr = curr->children[ch - 'a'];
        }
        
        return curr;
    }
    
public:
    Trie() {
        root = new TrieNode();
    }
    
    void insert(string word) {
        TrieNode* curr = root;
        
        for(char ch : word) {
            if(curr->children[ch - 'a'] == nullptr) {
                curr->children[ch - 'a'] = new TrieNode();    
            }
            curr = curr->children[ch - 'a'];
        }
        
        curr->eow = true;
    }
    
    bool search(string word) {
        TrieNode* node = getNode(word);
        return node != nullptr && node->eow;
    }
    
    bool startsWith(string prefix) {
        TrieNode* node = getNode(prefix);
        return node != nullptr;
    }
};

/**
 * Your Trie object will be instantiated and called as such:
 * Trie* obj = new Trie();
 * obj->insert(word);
 * bool param_2 = obj->search(word);
 * bool param_3 = obj->startsWith(prefix);
 */