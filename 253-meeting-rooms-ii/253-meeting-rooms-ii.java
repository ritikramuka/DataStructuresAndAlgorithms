class Solution {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> pq = new PriorityQueue();
        int maxCnt = 0;
        for(int[] interval : intervals) {
            while (!pq.isEmpty() && interval[0] >= pq.peek()) {
                pq.remove();
            }
            pq.add(interval[1]);
            maxCnt = Math.max(maxCnt, (int)pq.size());
        }
        return maxCnt;
    }
}