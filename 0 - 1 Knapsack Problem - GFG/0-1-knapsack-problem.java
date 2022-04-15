// { Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class gfg
{
    public static void main(String args[])throws IOException
    {
        //reading input using BufferedReader class
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        
        //reading total testcases
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            //reading number of elements and weight
            int n = Integer.parseInt(read.readLine());
            int w = Integer.parseInt(read.readLine());
            
            int val[] = new int[n];
            int wt[] = new int[n];
            
            String st[] = read.readLine().trim().split("\\s+");
            
            //inserting the values
            for(int i = 0; i < n; i++)
              val[i] = Integer.parseInt(st[i]);
             
            String s[] = read.readLine().trim().split("\\s+"); 
            
            //inserting the weigths
            for(int i = 0; i < n; i++)
              wt[i] = Integer.parseInt(s[i]);
              
            //calling method knapSack() of class Knapsack
            System.out.println(new Solution().knapSack(w, wt, val, n));
        }
    }
}



// } Driver Code Ends


class Solution 
{ 
    static int memo(int[] wt, int[] val, int W, int n, int idx, int[][] dp) 
    {
        if(W == 0 || idx == n) 
        {
            return dp[idx][W] = 0;
        }
        
        if(dp[idx][W] != 0) 
        {
            return dp[idx][W];
        }
        
        int inc = 0, exc = 0;
        if(W - wt[idx] >= 0) 
        {
            inc = memo(wt, val, W - wt[idx], n, idx + 1, dp) + val[idx]; 
        }
        exc = memo(wt, val, W, n, idx + 1, dp);
        
        return dp[idx][W] = Math.max(inc, exc);
    }
    //Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int W, int wt[], int val[], int n) 
    { 
         // your code here 
         int[][] dp = new int[n + 1][W + 1];
         int ans = memo(wt, val, W, n, 0, dp);
         return ans;
    } 
}


