class Solution {
    public int maxProfit(int k, int[] arr) {
        int n = arr.length;
        int[][] prev = new int[2][k + 1];
        int[][] curr = new int[2][k + 1];
        for(int idx = n; idx >= 0; idx--) {
            for(int flag = 0; flag < 2; flag++) {
                for(int tr = 0; tr <= k; tr++) {
                    if(tr == 0) {
                        curr[flag][tr] = 0;
                        continue;
                    }

                    if(idx == arr.length) {
                        curr[flag][tr] = 0;
                        continue;
                    }

                    if(flag == 0) {
                        // buy
                        int ProfitWhenBuyHere = -arr[idx] + prev[1][tr];
                        int ProfitWhenNotBuyingHere = prev[0][tr];
                        curr[flag][tr] = Math.max(ProfitWhenBuyHere, ProfitWhenNotBuyingHere);
                    }
                    else {
                        // sell
                        int ProfitWhenSellHere = arr[idx] + prev[0][tr - 1];
                        int ProfitWhenNotSellingHere = prev[1][tr];
                        curr[flag][tr] = Math.max(ProfitWhenSellHere, ProfitWhenNotSellingHere);
                    }
                }
            }
            prev = curr;
        }
        return prev[0][k];
    }
}