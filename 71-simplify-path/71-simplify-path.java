class Solution {
    public String simplifyPath(String path) {
        Stack<String> st = new Stack();
        for(String str : path.split("/")) {
            if(str.equals(".") || str.equals(""))
                continue;
            else if(str.equals("..")) {
                if(st.size() > 0)
                    st.pop();
            } else
                st.add(str);
        }
        
        String ans = "";
        for(String str : st) {
            ans += "/" + str;
        }
        return ans == "" ? "/" : ans;
    }
}