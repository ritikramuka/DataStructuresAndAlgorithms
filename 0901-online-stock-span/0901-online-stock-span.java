class StockSpanner {
    class Pair {
        int price;
        int idx;
        
        Pair (int price, int idx) {
            this.price = price;
            this.idx = idx;
        }
    }
    
    // Stack: potential ngeli
    Stack<Pair> st;
    int idx;
    
    public StockSpanner() {
        st = new Stack<>();
        idx = 0;
    }
    
    public int next(int price) {
        int span = 0;
        while (st.size() != 0 && st.peek().price <= price) {
            st.pop();
        }
            
        if (st.size() == 0) {
            span = idx - (-1);
        } else {
            span = idx - st.peek().idx;
        }
        
        st.push(new Pair(price, idx));
        idx++;
        
        return span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */