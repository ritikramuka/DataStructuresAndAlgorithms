class StreamChecker {
public:
    class Trie {
    public:
        Trie* childs[26];
        bool eorw;
        Trie() {
            for(int i = 0; i < 26; i++) {
                childs[i] = nullptr;
            }
            eorw = false;
        }
    };
    Trie *root;
    string waitingList;
    
    void insert(string& word) {
        Trie* curr = root;
        for(int i = word.size() - 1; i >= 0; --i) {
            char ch = word[i];
            if(curr->childs[ch - 'a'] == nullptr) {
                curr->childs[ch - 'a'] = new Trie();
            }
            curr = curr->childs[ch - 'a'];
        }
        curr->eorw = true;
    }
    
    void constructTrie(vector<string>& words) {
        for(string& word : words) {
            insert(word);
        }
    }
    
    StreamChecker(vector<string>& words) {
        root = new Trie;
        constructTrie(words);
        waitingList = "";
    }
    
    bool find() {
        Trie *curr = root;
        for(int i = waitingList.size() - 1; i >= 0 && curr != nullptr; i--) {
            char ch = waitingList[i];
            curr = curr->childs[ch - 'a'];
            if(curr != nullptr && curr->eorw == true) {
                return true;
            }
        }
        return false;
    }
    
    bool query(char letter) {
        waitingList += letter;
        return find();
    }
};

/**
 * Your StreamChecker object will be instantiated and called as such:
 * StreamChecker* obj = new StreamChecker(words);
 * bool param_1 = obj->query(letter);
 */