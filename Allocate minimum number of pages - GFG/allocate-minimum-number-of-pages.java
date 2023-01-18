//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int t=sc.nextInt();
		
		while(t-->0)
		{
		    int n=sc.nextInt();
		    int a[]=new int[n];
		    
		    for(int i=0;i<n;i++)
		    {
		        a[i]=sc.nextInt();
		    }
		    int m=sc.nextInt();
		    Solution ob = new Solution();
		    System.out.println(ob.findPages(a,n,m));
		}
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution 
{
    public static boolean canAllocate (int cap, int[] A, int N, int M) {
        int stud = 1;
        int curr = 0;
        for (int i = 0; i < N; i++) {
            if (curr + A[i] <= cap) {
                curr += A[i];
            } else {
                curr = A[i];
                
                if (A[i] > cap) {
                    return false;
                }
                
                stud++;
            }
        }
        
        return stud <= M;
    }
    
    //Function to find minimum number of pages.
    public static int findPages(int[]A,int N,int M)
    {
        //Your code here
        if (A.length < M) {
            return -1;
        }
        
        int lo = A[0];
        int hi = A[0];
        
        for (int i = 1; i < N; i++) {
            hi += A[i];
            lo = Math.min(lo, A[i]);
        }
        
        int res = -1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (canAllocate(mid, A, N, M) == true) {
                res = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        
        return res;
    }
};