class Solution {
    
    private int upperBound(List<Integer> lis, int val) {
        int lb = 0;
        int ub = lis.size();
        while(lb < ub) {
            int mid = lb + (ub - lb) / 2;
            if (val >= lis.get(mid)) {
                lb = mid + 1;
            } else {
                ub = mid;
            }
        }
        return ub;
    }
    
    public int[] longestObstacleCourseAtEachPosition(int[] obstacles) {
        int n = obstacles.length;
        int[] ans = new int[n];
        List<Integer> lis = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            int idx = upperBound(lis, obstacles[i]);
            if (idx == lis.size()) {
                lis.add(obstacles[i]);
                ans[i] = lis.size();
            } else {
                lis.set(idx, obstacles[i]);
                ans[i] = idx + 1;
            }
        }
        
        return ans;
    }
}