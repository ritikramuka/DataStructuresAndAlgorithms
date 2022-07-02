class MapSum {
public:
    class Trie {
        public:
            Trie* childs[26];
            int val;
            unordered_map<string, int> valMap;
            Trie() {
                memset(childs, NULL, sizeof(childs));
                val = 0;
            }
    };
    Trie *root;
    
    MapSum() {
        root = new Trie();
    }
    
    void insert(string key, int val) {
        Trie *curr = root;
        for(char ch : key) {
            if(curr->childs[ch - 'a'] == NULL) {
                curr->childs[ch - 'a'] = new Trie();
            }
            if(curr->childs[ch - 'a']->valMap.find(key) != curr->childs[ch - 'a']->valMap.end()) {
                curr->childs[ch - 'a']->val -= curr->childs[ch - 'a']->valMap[key];
            }
            curr->childs[ch - 'a']->val += val;
            curr->childs[ch - 'a']->valMap[key] = val;
            curr = curr->childs[ch - 'a'];
        }
    }
    
    int sum(string prefix) {
        Trie* curr = root;
        for(char ch : prefix) {
            if(curr->childs[ch - 'a'] == NULL) {
                return 0;
            } else {
                curr = curr->childs[ch - 'a'];
            }
        }
        return curr->val;
    }
};

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum* obj = new MapSum();
 * obj->insert(key,val);
 * int param_2 = obj->sum(prefix);
 */