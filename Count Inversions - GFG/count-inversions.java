//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Sorting
{
    public static void main (String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        long t = sc.nextLong();
        
        while(t-- > 0)
        {
            long n = sc.nextLong();
            long arr[] = new long[(int)n];
            
            for(long i = 0; i < n; i++)
             arr[(int)i] = sc.nextLong();
             
            System.out.println(new Solution().inversionCount(arr, n));
            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    static long count = 0;
    
    static long[] merge2SortedArray(long[] left, long[] right) 
    {
        int i = 0;
        int j = 0;
        int k = 0;
        long[] mergedArray = new long[left.length + right.length];
        
        while (i < left.length && j < right.length) 
        {
            if (left[i] <= right[j]) 
            {
                mergedArray[k] = left[i];
                i++;
                k++;
            } 
            else 
            {
                count += left.length - i;
                mergedArray[k] = right[j];
                j++;
                k++;
            }
        }
        
        while (i < left.length) 
        {
            mergedArray[k] = left[i];
            i++;
            k++;
        }
        
        while (j < right.length) 
        {
            mergedArray[k] = right[j];
            j++;
            k++;
        }
        
        return mergedArray;
    }
    
    static long[] mergeSort (long[] arr, int si, int ei)
    {
        if (si == ei)
        {
            long[] ba = new long[1];
            ba[0] = arr[si];
            return ba;
        }
        
        int mid = si + (ei - si) / 2;
        
        long[] left = mergeSort (arr, si, mid);
        long[] right = mergeSort (arr, mid + 1, ei);
        long[] mergedArray = merge2SortedArray (left, right);
        
        return mergedArray;
    }
    
    static long inversionCount(long arr[], long N)
    {
        // Your Code Here
        count = 0;
        long[] sortedArray = mergeSort (arr, 0, (int) (N - 1));
        return count;
    }
}