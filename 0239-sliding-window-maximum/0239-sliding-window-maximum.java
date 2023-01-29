class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        Deque<Integer> dq = new ArrayDeque<>();
        
        for(int i = 0 ; i < nums.length; i++) {
            if (dq.size() > 0 && dq.peek() == i - k) {
                dq.removeFirst();
            }
            
            while(dq.size() > 0 && nums[dq.getLast()] <= nums[i]){
               dq.removeLast();
            } 
            
            dq.addLast(i); 
            
            if (i >= k - 1) {
                ans[i - k + 1] = nums[dq.peek()];    
            }
        }
        
        return ans;
    }
}