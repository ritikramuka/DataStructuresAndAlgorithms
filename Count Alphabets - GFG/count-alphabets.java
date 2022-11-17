//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            
            String S = read.readLine();
            

            Solution ob = new Solution();
            

            
            System.out.println(ob.Count(S));
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int Count(String str)
    {
        // code here
        int cnt = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            // if (Character.isAlphabetic(ch) == true)
            if (ch >= 'a' && ch <= 'z') {
                cnt++;
            } 
            else if (ch >= 'A' && ch <= 'Z') {
                cnt++;
            }        
        }
        
        return cnt;
    }
}