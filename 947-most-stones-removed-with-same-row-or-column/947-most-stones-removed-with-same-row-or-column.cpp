class Solution {
public:
    int removeStones(vector<vector<int>>& stones) {
        unordered_map<int, int> parent;
        vector<int> rank(20002);
        for(vector<int>& stone : stones) {
            int x = stone[0];
            int y = stone[1] + 10001;
            int px = find(parent, x);
            int py = find(parent, y);
            if(px == py) continue;
            if(rank[px] > rank[py]) parent[py] = px;
            else if(rank[px] < rank[py]) parent[px] = py;
            else { parent[py] = px; rank[px]++; }
        }
        int removed = 0;
        for(auto& x : parent) {
            if(find(parent, x.first) == x.first) removed++;
        }
        return stones.size() - removed;
    }
    
    int find(unordered_map<int, int>& parent, int x) {
        if(parent.find(x) == parent.end() || parent[x] == x) return parent[x] = x;
        return parent[x] = find(parent, parent[x]);
    }
};