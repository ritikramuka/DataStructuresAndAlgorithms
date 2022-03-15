class Solution {
    public String minRemoveToMakeValid(String s) {
        StringBuilder str = new StringBuilder(s);
        int n = str.length();
        Stack<Integer> st = new Stack();
        
        for(int i = 0; i < n; i++) {
            char ch = str.charAt(i);
            if(ch == '(')
                st.add(i);
            else if(ch == ')') {
                if(st.size() > 0 && str.charAt(st.peek()) == '(') {
                    st.pop();
                } else {
                    str.setCharAt(i, '*');
                }
            }
        }
        
        while(st.size() != 0) {
            str.setCharAt(st.peek(), '*');
            st.pop();
        }
        
        String ans = "";
        for(int i = 0; i< n; i++) {
            if(str.charAt(i) == '*') {
                continue;
            } else {
                ans += str.charAt(i);
            }
        }
        
        return ans;
    }
}