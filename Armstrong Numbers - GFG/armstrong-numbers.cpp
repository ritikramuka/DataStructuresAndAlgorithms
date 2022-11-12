//{ Driver Code Starts
// Initial Template for C++
#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends
// User function Template for C++
class Solution {
  public:
    string armstrongNumber(int n) {
        // code here
        int orignalNumber = n;
        int armstrongSum = 0;
        while (n != 0) {
            int digit = n % 10;
            n = n / 10;
            armstrongSum += pow(digit, 3);
        }
        return armstrongSum == orignalNumber ? "Yes" : "No";
    }
};

//{ Driver Code Starts.
int main() {
    int t;
    cin >> t;
    while (t--) {
        int n;
        cin >> n;
        Solution ob;
        cout << ob.armstrongNumber(n) << endl;
    }
    return 0;
}

// } Driver Code Ends