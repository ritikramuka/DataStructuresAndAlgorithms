class Solution {
public:
    #define ll long long
    #define MOD 1000000007
    int maxSum(vector<int>& nums1, vector<int>& nums2) {
        int n = nums1.size(), m = nums2.size();
        int i = 0, j = 0;
        ll sum1 = 0, sum2 = 0;
        ll ans = 0;
        while(i < n && j < m) {
            if(nums1[i] < nums2[j]) {
                sum1 += nums1[i++];
            } else if(nums1[i] > nums2[j]) {
                sum2 += nums2[j++];
            } else {
                ans += max(sum1, sum2) + nums1[i];
                i++;
                j++;
                sum1 = 0;
                sum2 = 0;
            }
        }
        
        while(i < n) {
            sum1 = (sum1 + nums1[i++]);
        }
        
        while(j < m) {
            sum2 = (sum2 + nums2[j++]);
        }
        
        return (max(sum1, sum2) + ans) % MOD;
    }
};