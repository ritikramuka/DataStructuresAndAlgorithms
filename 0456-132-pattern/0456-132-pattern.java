class Solution {
    class Pair {
        int val;
        int prevMin;
        
        Pair (int val, int prevMin) {
            this.val = val;
            this.prevMin = prevMin;
        }
    }
    
    public boolean find132pattern(int[] nums) {
        Stack<Pair> st = new Stack<>();
        st.push(new Pair(nums[0], Integer.MAX_VALUE));
        
        int minVal = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            while (st.size() > 0 && st.peek().val <= nums[i]) {
                st.pop();
            } 
            
            if (st.size() > 0 && nums[i] > st.peek().prevMin) {
                return true;
            }
            
            st.push(new Pair(nums[i], minVal));
            minVal = Math.min(minVal, nums[i]);
        }
        
        return false;
    }
}