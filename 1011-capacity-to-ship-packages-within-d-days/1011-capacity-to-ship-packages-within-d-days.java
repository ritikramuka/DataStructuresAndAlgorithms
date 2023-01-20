class Solution {
    public boolean isPossibleToLoad(int[] weights, int cap, int days) {
        int currDays = 1;
        int currCap = 0;
        for (int i = 0; i < weights.length; i++) {
            if (currCap + weights[i] <= cap) {
                currCap += weights[i];
            } else {
                currCap = weights[i];
                currDays++;

                if (currCap > cap) {
                    return false;
                }
            }
        }

        return currDays <= days;
    }

    public int shipWithinDays(int[] weights, int days) {
        int lo = 0;
        int hi = 0;
        for (int i = 0; i < weights.length; i++) {
            lo = Math.max(lo, weights[i]);
            hi += weights[i];
        }

        int res = -1;
        while (lo <= hi) {
            int mid = (lo + hi) >> 1;
            if (isPossibleToLoad(weights, mid, days) == true) {
                res = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        return res;
    }
}