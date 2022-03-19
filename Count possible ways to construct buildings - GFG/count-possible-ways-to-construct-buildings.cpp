// { Driver Code Starts
#include<bits/stdc++.h>
using namespace std;

 // } Driver Code Ends
class Solution{
	public:
	#define MOD 1000000007
	#define ll long long
	int TotalWays(int N)
	{
	    // Code here
	    if(N == 1) {
	        return 2*2;
	    }
	    
	    if(N == 2) {
	        return 3*3;
	    }
	    
	    ll prev1 = 3;
	    ll prev2 = 2;
	    
	    for(int i = 3; i <= N; i++) {
	        ll curr = (prev1 + prev2) % MOD;
	        prev2 = prev1;
	        prev1 = curr;
	    }
	    
	    return (prev1 * prev1) % MOD;
	}
};

// { Driver Code Starts.
int main(){
	int tc;
	cin >> tc;
	while(tc--){
		int N;
		cin >> N;
		Solution ob;
		int ans = ob.TotalWays(N);
		cout << ans <<"\n";
	}
	return 0;
}  // } Driver Code Ends