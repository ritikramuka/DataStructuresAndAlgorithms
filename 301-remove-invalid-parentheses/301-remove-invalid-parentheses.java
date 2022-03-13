class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack();
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(ch == '(') {
                st.push(ch);
            } else if(ch == ')') {
                if(st.size() == 0) {
                    return false;
                } else {
                    st.pop();
                }
            }
        }
        
        return st.size() == 0;
    }
    
    public int getNumberOfInvalidParentheses(String s) {
        Stack<Character> st = new Stack();
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(ch == '(') {
                st.push(ch);
            } else if(ch == ')') {
                if(st.size() == 0 || st.peek() == ')') {
                    st.push(ch);
                } else {
                    st.pop();
                }
            }
        }
        
        return st.size();
    }
    
    public void helper(String s, int invalidParentheses, HashSet<String> allState, List<String> ans) {
        if(allState.contains(s) == false) {
            allState.add(s);
        } else {
            return;
        }
        
        if(invalidParentheses == 0) {
            if(isValid(s) == true) {
                ans.add(s);
            }
            return;
        }
        
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(ch == '(' || ch == ')') {
                String left = s.substring(0, i);
                String right = s.substring(i + 1);
                helper(left + right, invalidParentheses - 1, allState, ans);
            }
        }
    }
    
    public List<String> removeInvalidParentheses(String s) {
        int invalidParentheses = getNumberOfInvalidParentheses(s);
        HashSet<String> allState = new HashSet();
        List<String> ans = new ArrayList();
        helper(s, invalidParentheses, allState, ans);
        return ans;
    }
}