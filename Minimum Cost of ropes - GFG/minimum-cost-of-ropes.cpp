//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
class Solution
{
    public:
    //Function to return the minimum cost of connecting the ropes.
    long long minCost(long long arr[], long long n) {
        // Your code here
        priority_queue<long long, vector<long long>, greater<long long>> pq (arr, arr + n);
        long long wdsf = 0;
        while (pq.size() > 1) {
            long long rope1 = pq.top();
            pq.pop();
            long long rope2 = pq.top();
            pq.pop();
            wdsf += rope1 + rope2;
            pq.push(rope1 + rope2);
        }
        return wdsf;
    }
};


//{ Driver Code Starts.

int main() {
    long long t;
    cin >> t;
    while (t--) {
        long long n;
        cin >> n;
        long long i, a[n];
        for (i = 0; i < n; i++) {
            cin >> a[i];
        }
        Solution ob;
        cout << ob.minCost(a, n) << endl;
    }
    return 0;
}

// } Driver Code Ends