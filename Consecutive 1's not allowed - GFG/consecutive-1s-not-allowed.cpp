// { Driver Code Starts
#include <bits/stdc++.h>

using namespace std;
#define ll long long

 // } Driver Code Ends
//User function template for C++
class Solution{
public:
	// #define ll long long
	#define MOD 1000000007
	ll countStrings(int n) {
	    // code here
	    if(n == 1)
	        return 2;
	    
	    if(n == 2)
	        return 3;
	 
	    ll prev1 = 3;
	    ll prev2 = 2;
	    for(int i = 3; i <= n; i++) {
	        ll curr = (prev1 + prev2) % MOD;
	        prev2 = prev1;
	        prev1 = curr;
	    }
	    
	    return prev1;
	}
};

// { Driver Code Starts.

int main() {
    int t;
    cin >> t;
    while (t--) {
        int n;
        cin >> n;
        Solution ob;
        auto ans = ob.countStrings(n);
        cout << ans << "\n";
    }
    return 0;
}  // } Driver Code Ends