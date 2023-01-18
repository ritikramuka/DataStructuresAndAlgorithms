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
    public static boolean possibleToPlace(int[] A, int B, long cap) {
        int stud = 1;
        int currPagesCount = 0;
        for (int i = 0; i < A.length; i++) {
            if (currPagesCount + A[i] <= cap) {
                currPagesCount += A[i];
            } else {
                currPagesCount = A[i];
                stud++;
            }
        }

        return stud <= B;
    }
    
    //Function to find minimum number of pages.
    public static int findPages(int[]A,int N,int B)
    {
        //Your code here
        if (A.length < B) {
            return -1;
        }
        
        // first define sample space for capacity of max pages to a student
        // lo -> max element in the array, as if we divide all books to n students then
        // max pages in a permuation to a student will me max element of the array
        // hi -> sum of all elements in the array, as if we divide all books to a single
        // then, maximum pages will be sum of the pages
        int lo = A[0];
        int hi = A[0];
        for (int i = 1; i < A.length; i++) {
            lo = Math.max(lo, A[i]);
            hi += A[i];
        }

        int potentialAns = -1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            // if I'm able to distribute these books to B or less than B students then,
            // these books are distributable inside this capacity, hence this is my
            // potential ans
            if (possibleToPlace(A, B, mid) == true) {
                potentialAns = mid;

                // move towards smaller capacity to get new answers
                hi = mid - 1;
            } else {

                // move towards as capacity was less, so increase capacity
                lo = mid + 1;
            }
        }

        return potentialAns;
    }
};