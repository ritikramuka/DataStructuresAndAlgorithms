class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int n = capacity.length;
        
        int[] vacancy = new int[n];
        for (int i = 0; i < n; i++) vacancy[i] = capacity[i] - rocks[i];
        Arrays.sort (vacancy);
        
        int fullBagCnt = 0;
        for (int i = 0; i < n; i++) {
            if (vacancy[i] <= additionalRocks) {
                additionalRocks -= vacancy[i];
                fullBagCnt++;
            } else {
                break;
            }
        }
        
        return fullBagCnt;
    }
}