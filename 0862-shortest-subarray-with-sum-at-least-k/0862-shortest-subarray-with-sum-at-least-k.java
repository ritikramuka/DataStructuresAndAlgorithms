class Solution {
    class Pair {
        long sum;
        int idx;

        Pair (long sum, int idx) {
            this.sum = sum;
            this.idx = idx;
        }
    }

    public int shortestSubarray(int[] nums, int k) {
        Deque<Pair> dq = new ArrayDeque<>();
        
        long currSum = 0;
        int minLen = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            currSum += nums[i];

            if (currSum >= k) {
                minLen = Math.min(minLen, i + 1);
            }

            while (dq.size() > 0 && currSum - dq.getFirst().sum >= k) {
                minLen = Math.min(minLen, i - dq.getFirst().idx);
                dq.removeFirst();
            }

            while (dq.size() > 0 && dq.getLast().sum > currSum) {
                dq.removeLast();
            }

            dq.add(new Pair(currSum, i));
        }

        return minLen == Integer.MAX_VALUE ? -1 : minLen;
    }
}