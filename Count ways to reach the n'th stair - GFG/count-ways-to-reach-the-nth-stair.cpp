//{ Driver Code Starts
#include<bits/stdc++.h>
using namespace std;

// } Driver Code Ends
class Solution
{
    public:
    //Function to count number of ways to reach the nth stair.
    int countWays(int n)
    {
        // your code here
        // vector<int> memo(n + 1, -1);
        
        int memo[n + 1];
        memset(memo, -1, sizeof(memo));
        
        return rec(n, memo);
    }
    
    int mod = 1000000007;
    int rec(int n, int *memo) 
    {
        if (n <= 1) 
        {
            return memo[n] = 1;
        }
        
        if (memo[n] != -1) 
        {
            return memo[n];
        }
        
        return memo[n] = (int) (((long)rec(n - 1, memo) + (long)rec(n - 2, memo)) % mod);
    }
};



//{ Driver Code Starts.
int main()
{
    //taking total testcases
    int t;
    cin >> t;
    while(t--)
    {
        //taking stair count
        int m;
        cin>>m;
        Solution ob;
        cout<<ob.countWays(m)<<endl; // Print the output from our pre computed array
    }
    return 0;
}

// } Driver Code Ends