class Solution {
    boolean isPossibleToPlace (int[] position, int m, int dist) {
        int balls = 1;
        int lastPlacedAt = position[0];
        for (int i = 1; i < position.length; i++) {
            if (position[i] - lastPlacedAt >= dist) {
                balls++;
                lastPlacedAt = position[i];
            }
        }

        return balls >= m;
    }

    public int maxDistance(int[] position, int m) {
        Arrays.sort (position);

        int lo = 1;
        int hi = position[position.length - 1] - position[0];

        int res = -1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (isPossibleToPlace(position, m, mid) == true) {
                res = mid;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return res;
    }
}