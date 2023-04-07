//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            
            String S1[] = read.readLine().split(" ");
            
            int[] arr = new int[N];
            
            for(int i=0; i<N; i++)
            {
                arr[i] = Integer.parseInt(S1[i]);
            }

            Solution ob = new Solution();
            System.out.println(ob.maxValue(arr,N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int maxValue(int[] arr, int N) {
        // code here
        
        // arr[i] + i
        int max1 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE;
        
        for (int i = 0; i < N; i++) {
            int val = i + arr[i];
            
            max1 = Math.max(max1, val);
            min1 = Math.min(min1, val);
        }
        
        int ans1 = max1 - min1;
        
        
        // i - arr[i]
        int max2 = Integer.MIN_VALUE;
        int min2 = Integer.MAX_VALUE;
        
        for (int i = 0; i < N; i++) {
            int val = i - arr[i];
            
            max2 = Math.max(max2, val);
            min2 = Math.min(min2, val);
        }
        
        int ans2 = max2 - min2;
        
        return Math.max(ans1, ans2);
    }
};