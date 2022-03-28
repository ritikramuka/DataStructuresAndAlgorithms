// { Driver Code Starts
// Initial Template for C++

#include <bits/stdc++.h>
using namespace std;

 // } Driver Code Ends
// User function Template for C++

class Solution{
public:
    #define ll long long
    #define MOD 1000000007
    int nCr(int n, int r){
        // code here
        if(r > n)
            return 0;
        vector<ll> ans(n + 1, 0);
        ans[0] = 1;
        for(int i = 1; i <= n; i++) {
            for(int j = i; j > 0; j--) {
                ans[j] = (ans[j] + ans[j - 1]) % MOD;
            }
        }
        return ans[r];
    }
};

// { Driver Code Starts.

int main(){
    int t;
    cin>>t;
    while(t--){
        int n, r;
        cin>>n>>r;
        
        Solution ob;
        cout<<ob.nCr(n, r)<<endl;
    }
    return 0;
}  // } Driver Code Ends