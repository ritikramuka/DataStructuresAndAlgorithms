//{ Driver Code Starts
//Initial Template for C++

#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends
//User function Template for C++

class Solution {
  public:
    int maxValue(int arr[], int N) {
        // code here
        int temp1, temp2;
        int max1 = INT_MIN, max2 = INT_MIN;
        int min1 = INT_MAX, min2 = INT_MAX;
        for (int i = 0; i < N; i++) {
            temp1 = arr[i] + i;
            temp2 = arr[i] - i;
            max1 = max(max1, temp1);
            min1 = min(min1, temp1);
            max2 = max(max2, temp2);
            min2 = min(min2, temp2);
        }
        
        return max((max1 - min1), (max2 - min2));
    }
};

//{ Driver Code Starts.
int main() {
    int t;
    cin >> t;
    while (t--) {
        int N;
        cin>>N;
        
        int arr[N];
        
        for(int i=0; i<N; i++)
            cin>>arr[i];

        Solution ob;
        cout << ob.maxValue(arr,N) << endl;
    }
    return 0;
}
// } Driver Code Ends