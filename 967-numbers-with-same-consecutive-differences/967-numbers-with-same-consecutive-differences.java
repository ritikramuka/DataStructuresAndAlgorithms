class Solution {
    private HashSet<Integer> ans;
    
    private void dfs(ArrayList<Integer>[] numberMapping, int i, int n, int num) {
        if(n == 0) {
            ans.add(num);
            return;
        }
        
        for(int j = 0; j < numberMapping[i].size(); j++) {
            int a = numberMapping[i].get(j);
            dfs(numberMapping, a, n - 1, num * 10 + a);
        }
    }
    
    public int[] numsSameConsecDiff(int n, int k) {
        ArrayList<Integer>[] numberMapping = new ArrayList[10];
        for(int i = 0; i < 10; i++) {
            numberMapping[i] = new ArrayList();
            int prevCons = i - k;
            int nextCons = i + k;
            if(prevCons >= 0) numberMapping[i].add(prevCons);
            if(nextCons < 10) numberMapping[i].add(nextCons);
        }
        
        ans = new HashSet();
        for(int i = 1; i < 10; i++) {
            dfs(numberMapping, i, n - 1, i);
        }
        
        int[] sol = new int[ans.size()];
        int itr = 0;
        for(int i : ans) {
            sol[itr++] = i;
        }
        
        return sol;
    }
}