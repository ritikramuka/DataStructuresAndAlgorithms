// { Driver Code Starts
//Initial Template for Java



import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            int n = Integer.parseInt(br.readLine().trim());
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().findMaxSum(arr, n);
            System.out.println(ans);
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution {
    int findMaxSum(int arr[], int n) {
        // code here
        int[] dp = new int[n + 2];
        for(int idx = n + 1; idx >= 0; idx--) {
            if(idx == n || idx == n + 1) {
                dp[idx] = 0;
                continue;
            }
            
            int inc = arr[idx] + dp[idx + 2]; 
            int exc = dp[idx + 1];
            
            dp[idx] = Math.max(inc, exc);
        }
        return dp[0];
    }
}