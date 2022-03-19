// { Driver Code Starts
#include <bits/stdc++.h> 
using namespace std; 

 // } Driver Code Ends
class Solution
{
public:
    #define ll long long
    #define MOD 1000000007
    int countFriendsPairings(int n) 
    { 
        // code here
        if(n == 1 || n == 2) {
            return n;
        }
        
        ll prev1 = 2, prev2 = 1;
        for(int i = 3; i <= n; i++) {
            ll curr = (prev1 + (i - 1) * prev2) % MOD;
            prev2 = prev1;
            prev1 = curr;
        }
        
        return prev1;
    }
};    
 

// { Driver Code Starts.
int main() 
{
    int t;
    cin>>t;
    while(t--)
    {
    	int n;
    	cin>>n;
    	Solution ob;
    	cout <<ob.countFriendsPairings(n); 
    	cout<<endl;
    }
} 
  // } Driver Code Ends