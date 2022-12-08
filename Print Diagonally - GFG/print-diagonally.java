//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            
            int matrix[][] = new int[n][n];
            
            for(int i = 0; i < n; i++)
            {
                for(int j = 0; j < n; j++)
                 matrix[i][j] = sc.nextInt();
            }
            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.downwardDigonal(n, matrix);
            for (Integer val: ans) 
                System.out.print(val+" "); 
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static ArrayList<Integer> downwardDigonal(int N, int A[][]) {
        // code here 
        ArrayList<Integer> list = new ArrayList();
        
        // in zone 1 col is variable at start pos, but row starts from 0
        for (int k = 0; k < N; k++) {
            int row = 0;
            int col = k;
            while (col >= 0) {
                list.add(A[row][col]);
                row++;
                col--;
            }
        }
        
        // zone 2
        for (int k = 1; k < N; k++) {
            int row = k;
            int col = N - 1;
            while (row < N) {
                list.add(A[row][col]);
                row++;
                col--;
            }
        }
        
        return list;
    }
}
