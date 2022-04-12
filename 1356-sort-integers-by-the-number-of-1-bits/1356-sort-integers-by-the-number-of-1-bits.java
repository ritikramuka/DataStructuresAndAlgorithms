class Solution {
    public int count(int n) {
        int count = 0;
        while(n > 0) {
            count += (n & 1);
            n >>= 1;
        }
        return count;
    }
    
    class Comp implements Comparator<Integer> {
        public int compare(Integer a, Integer b) {
            int c1 = count(a);
            int c2 = count(b);
            if(c1 == c2) {
                return a - b;
            }
            return c1 - c2;
        }
    }
    
    public int[] sortByBits(int[] arr) {
        PriorityQueue<Integer> pq = new PriorityQueue(new Comp());
        for(int i : arr) {
            pq.add(i);
        }
        int[] ans = new int[arr.length];
        for(int i = 0; i < arr.length; i++) {
            ans[i] = pq.peek();
            pq.remove();
        }
        return ans;
    }
}