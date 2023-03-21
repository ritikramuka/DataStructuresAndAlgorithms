class MyHashMap
{
    private:
    int mod;
    vector<vector<pair<int, int>>> hmap;
    bool contains(int key)
    {
        int k = key % mod;
        for (auto &a: hmap[k])
            if (a.first == key)
                return true;
        return false;
    }
    public:
        /**Initialize your data structure here. */
        MyHashMap()
        {
            mod = 1000;
            hmap = vector<vector<pair<int, int>>> (mod);
        }

    /**value will always be non-negative. */
    void put(int key, int value)
    {
        int k = key % mod;
        if (contains(key))
        {
            for (auto &a: hmap[k])
                if (a.first == key)
                    a.second = value;
            return;
        }
        hmap[k].push_back(pair
        {
            key,
            value });
    }

    /**Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    int get(int key)
    {
        int k = key % mod;
        for (auto &a: hmap[k])
            if (a.first == key)
                return a.second;
        return -1;
    }

    /**Removes the mapping of the specified value key if this map contains a mapping for the key */
    void remove(int key)
    {
        int k = key % mod;
        vector<pair<int, int>> v;
        for (auto &a: hmap[k])
            if (a.first != key)
                v.push_back(a);
        hmap[k] = v;
    }
};
static
const auto __ =[]()
{
    std::ios::sync_with_stdio(false);
    std::cin.tie(nullptr);
    std::cout.tie(nullptr);
    return nullptr;
}();
/**
 *Your MyHashMap object will be instantiated and called as such:
 *MyHashMap* obj = new MyHashMap();
 *obj->put(key,value);
 *int param_2 = obj->get(key);
 *obj->remove(key);
 */