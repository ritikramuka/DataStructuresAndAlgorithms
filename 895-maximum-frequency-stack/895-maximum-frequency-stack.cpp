class FreqStack {
private:
    unordered_map<int,int> m;  /* {ele, freq} */
    unordered_map<int,stack<int>> st;
    int maxFreq=0;
    
public:
    FreqStack() {
        
    }
    
    void push(int x) {
        m[x]++;
        st[m[x]].push(x);
        if(m[x]>maxFreq)
            maxFreq=m[x];
    }
    
    int pop() {
        int x=st[maxFreq].top();
        st[maxFreq].pop();
        m[x]--;
        if(st[maxFreq].size()==0)
             maxFreq--;
        return x;
    }
};

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack* obj = new FreqStack();
 * obj->push(x);
 * int param_2 = obj->pop();
 */