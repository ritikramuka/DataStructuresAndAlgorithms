class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        int n = satisfaction.length;
        
        Arrays.sort(satisfaction);
        
        int ans = 0;
        int pSum = 0;
        int timeCoff = 0;
        
        for (int i = n - 1; i >= 0; i--) {
            pSum += satisfaction[i];
            timeCoff += pSum;
            ans = Math.max(timeCoff, ans);
        }
        
        return ans;
    }
}