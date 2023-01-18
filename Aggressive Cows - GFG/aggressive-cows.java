//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t;
        t = sc.nextInt();
        while (t-- > 0) {

            int n;
            n = sc.nextInt();

            int k;
            k = sc.nextInt();

            int[] v = new int[n];
            for (int i = 0; i < n; i++) v[i] = sc.nextInt();

            Solution obj = new Solution();
            int res = obj.solve(n, k, v);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    static boolean isPossible (int[] stalls, int n, int k, int dist) {
        int cnt = 1;
        int lastPlacedAt = stalls[0];
        for (int i = 1; i < n; i++) {
            if (stalls[i] - lastPlacedAt >= dist) {
                lastPlacedAt = stalls[i];
                cnt++;
            }
        }
        
        return cnt >= k;
    }
    
    public static int solve(int n, int k, int[] stalls) {
        Arrays.sort (stalls);
        
        int lo = 1;
        int hi = stalls[n - 1] - stalls[0];
        
        int ans = -1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (isPossible (stalls, n, k, mid) == true) {
                ans = mid;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        
        return ans;
    }
}