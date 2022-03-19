// { Driver Code Starts
//Initial template for C++

#include<bits/stdc++.h>
using namespace std;



 // } Driver Code Ends
//User function template 

class Solution{
  public:
    // s : given string
    // return the expected answer
    #define MOD 1000000007
    #define ll long long
    int fun(string &s) {
        //code here
        ll a = 0;
        ll ab = 0;
        ll abc = 0;
        
        for(char ch : s) {
            if(ch == 'a') {
                a = (2 * a + 1) % MOD;
            } else if(ch == 'b') {
                ab = (2 * ab + a) % MOD;
            } else {
                abc = (2 * abc + ab) % MOD;
            }
        }
        
        return abc;
    }
};

// { Driver Code Starts.
 
int main()
 {
    int t;
    cin>>t;
    while(t--) {
        string s;
        cin>>s;
        Solution obj;
        cout<<obj.fun(s)<<endl;
    }
	return 0;
}  // } Driver Code Ends