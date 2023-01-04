//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            String s; 
            s = br.readLine();
            
            Solution obj = new Solution();
            int res = obj.checkRedundancy(s);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int checkRedundancy(String s) {
        // code here
        Stack<Character> st = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (ch == '*' || ch == '/' || ch == '+' || ch == '-' || ch == '(') {
                st.push(ch);
            } else if (ch == ')') {
                if (st.size() == 0 || st.peek() == '(') {
                    return 1;
                } else {
                    while (st.size() != 0 && st.peek() != '(') {
                        st.pop();
                    }
                    if(st.size() == 0) {
                        return 1;
                    } else {
                        st.pop();
                    }
                }
            }
        }
        return 0;
    }
}
        
