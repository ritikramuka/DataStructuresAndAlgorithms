// { Driver Code Starts


import java.io.*;
import java.util.*;

class RodCutting {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

            Solution ob = new Solution();
            System.out.println(ob.cutRod(arr, n));
        }
    }
}
// } Driver Code Ends


class Solution{
    public int memo(int n, int[] price, int[] dp) 
    {
        if(n == 0) 
        {
            return dp[n] = 0;
        }
        
        if(n == 1) 
        {
            return dp[n] = price[n - 1];
        }
        
        if(dp[n] != 0) 
        {
            return dp[n];
        }
        
        int ans = 0;
        for(int i = 1; i <= n; i++) {
            ans = Math.max(ans, price[i - 1] + memo(n - i, price, dp));
        }
        
        return dp[n] = ans;
    }
    
    public int cutRod(int price[], int n) 
    {
        //code here
        int[] dp = new int[n + 1];
        int ans = memo(n, price, dp);
        return ans;
    }
}