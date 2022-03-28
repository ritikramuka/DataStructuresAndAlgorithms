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
    class Node {
        int data;
        Node left;
        Node right;
        
        Node() {}
        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    
    public Node construct(int[] arr, int lo, int hi) {
        if(lo > hi) 
            return null;
        
        int mid = lo + (hi - lo) / 2;
        Node node = new Node(arr[mid]);
        
        node.left = construct(arr, lo, mid - 1);
        node.right = construct(arr, mid + 1, hi);
        
        return node;
    }
    
    int idx = 0;
    public void preorder(Node root, int[] pre) {
        if(root == null) {
            return;
        }
        
        pre[idx] = root.data;
        idx++;
        preorder(root.left, pre);
        preorder(root.right, pre);
    }
    
    public int[] sortedArrayToBST(int[] nums)
    {
        // Code here 
        Node root = construct(nums, 0, nums.length - 1);
        int[] pre = new int[nums.length];
        preorder(root, pre);
        return pre;
    }
}