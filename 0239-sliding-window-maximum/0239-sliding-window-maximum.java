class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        int itr = 0;
        
        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (dq.size() > 0 && dq.peek() == i - k) {
                dq.removeFirst();
            }
            
            while (dq.size() > 0 && nums[dq.getLast()] <= nums[i]) {
                dq.removeLast();
            }
            
            dq.addLast(i);
            
            if (i >= k - 1) {
                ans[itr] = nums[dq.peek()];
                itr++;
            }
        }
        
        return ans;
    }
}