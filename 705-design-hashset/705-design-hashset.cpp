class MyHashSet {
private: 
    vector<vector<int>> hash_Set;
    int bucket_number;
public:
    /** Initialize your data structure here. */
    MyHashSet() {
        bucket_number = 1000;
        hash_Set = vector<vector<int>> (bucket_number);
    }
    
    void add(int key) {
        int bucket_key = key % bucket_number;
        if(contains(key))
            return;
        hash_Set[bucket_key].push_back(key);
        return;
    }
    
    void remove(int key) {
        int bucket_key = key % bucket_number;
        vector<int> temp;
        for(int e : hash_Set[bucket_key]) {
            if(e != key) {
                temp.push_back(e);
            }
        }
        hash_Set[bucket_key] = temp;
        return;
    }
    
    /** Returns true if this set contains the specified element */
    bool contains(int key) {
        int bucket_key = key % bucket_number;
        for(int e : hash_Set[bucket_key]) {
            if(e == key)
                return true;
        }
        return false;
    }
};

auto SpeedUp = []() {
    std::ios::sync_with_stdio(false);
    std::cin.tie(nullptr);
    std::cout.tie(nullptr);
    return nullptr;
}();

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet* obj = new MyHashSet();
 * obj->add(key);
 * obj->remove(key);
 * bool param_3 = obj->contains(key);
 */