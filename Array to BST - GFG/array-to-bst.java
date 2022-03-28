// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int[] nums = new int[n];
            String[] S = br.readLine().trim().split(" ");
            for(int i = 0; i < n; i++){
                nums[i] = Integer.parseInt(S[i]);
            }
            Solution obj = new Solution();
            int[] ans = obj.sortedArrayToBST(nums);
            for(int i = 0; i < ans.length; i++)
                System.out.print(ans[i] + " ");
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    
    public void construct(int[] arr, int lo, int hi, int[] pre) {
        if(lo > hi) 
            return;
        
        int mid = lo + (hi - lo) / 2;
        pre[idx] = arr[mid];
        idx++;
        construct(arr, lo, mid - 1, pre);
        construct(arr, mid + 1, hi, pre);
    }
    
    int idx = 0;
    
    public int[] sortedArrayToBST(int[] nums)
    {
        // Code here 
        int[] pre = new int[nums.length];
        construct(nums, 0, nums.length - 1, pre);
        return pre;
    }
}