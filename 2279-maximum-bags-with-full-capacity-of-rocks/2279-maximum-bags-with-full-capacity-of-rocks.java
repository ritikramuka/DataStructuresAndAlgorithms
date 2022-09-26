class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int[] vacancy = new int[capacity.length];
        for (int i = 0; i < capacity.length; i++) {
            vacancy[i] = capacity[i] - rocks[i];
        }
        Arrays.sort (vacancy);
        int fullBagsCnt = 0;
        for (int i = 0; i < capacity.length; i++) {
            if (vacancy[i] == 0) {
                fullBagsCnt++; 
            } else {
                if (vacancy[i] <= additionalRocks) {
                    additionalRocks -= vacancy[i];
                    fullBagsCnt++;
                } else {
                    break;
                }
            }
        }
        
        return fullBagsCnt;
    }
}