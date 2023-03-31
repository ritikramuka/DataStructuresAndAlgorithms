class Solution {
    public int[][] merge(int[][] intervals) {
        // sort all intervals basis of starting point of each interval
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            if (ans.size() == 0) {
                ArrayList<Integer> interval = new ArrayList<>();
                interval.add(intervals[i][0]);
                interval.add(intervals[i][1]);
                ans.add(interval);
            } else {
                ArrayList<Integer> prevInterval = ans.remove(ans.size() - 1);
                if (prevInterval.get(1) >= intervals[i][0]) {
                    // merged
                    ArrayList<Integer> interval = new ArrayList<>();
                    interval.add(prevInterval.get(0));
                    interval.add(Math.max(prevInterval.get(1), intervals[i][1]));
                    ans.add(interval);
                } else {
                    ans.add(prevInterval);
                    ArrayList<Integer> interval = new ArrayList<>();
                    interval.add(intervals[i][0]);
                    interval.add(intervals[i][1]);
                    ans.add(interval);
                }
            }
        }
        
        int[][] sol = new int[ans.size()][2];
        for (int i = 0; i < sol.length; i++) {
            sol[i][0] = ans.get(i).get(0);
            sol[i][1] = ans.get(i).get(1);
        }
        
        return sol;
    }
}