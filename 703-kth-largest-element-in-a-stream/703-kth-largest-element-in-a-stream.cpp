class KthLargest {
private:
    int m;
    priority_queue<int,vector<int>,greater<int>>pq;
    
public:
    KthLargest(int k, vector<int>& nums) {
        for(int e : nums) {
            pq.push(e);
            if(pq.size()>k)
                pq.pop();
        }
        m=k;
    }
    
    int add(int val) {
        pq.push(val);
        while(m<pq.size()) 
            pq.pop();
        return pq.top();
    }
};

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest* obj = new KthLargest(k, nums);
 * int param_1 = obj->add(val);
 */