//{ Driver Code Starts
#include<bits/stdc++.h>
using namespace std;

// } Driver Code Ends
class Solution {
	public:
		int LongestRepeatingSubsequence(string str){
		    // Code here
		    string text1 = str;
		    string text2 = str;
		    
		    int n = text1.size();
            int m = text2.size();
            
            vector<vector<int>> dp(n + 1, vector<int> (m + 1, 0));
            for (int i = n - 1; i >= 0; i--) {
                for (int j = m - 1; j >= 0; j--) {
                    if (text1[i] == text2[j] and i != j) {
                        dp[i][j] = dp[i + 1][j + 1] + 1;
                    } else {
                        dp[i][j] = max(dp[i + 1][j], dp[i][j + 1]);
                    }
                }
            }
            
            return dp[0][0];
		}

};

//{ Driver Code Starts.
int main(){
	int tc;
	cin >> tc;
	while(tc--){
		string str;
		cin >> str;
		Solution obj;
		int ans = obj.LongestRepeatingSubsequence(str);
		cout << ans << "\n";
	}
	return 0;
}
// } Driver Code Ends