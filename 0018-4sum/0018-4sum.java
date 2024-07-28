class Solution {
    public int getNextUnique(int[] arr, int idx) {
        int nexIdx = idx + 1;
        while (nexIdx < arr.length && arr[nexIdx] == arr[idx]) {
            nexIdx++;
        }
        
        return nexIdx;
    }
    
    public int getPrevUnique(int[] arr, int idx) {
        int prevIdx = idx - 1;
        while (prevIdx >= 0 && arr[prevIdx] == arr[idx]) {
            prevIdx--;
        }
        
        return prevIdx;
    }
    
    public List<List<Integer>> fourSum(int[] arr, int target) {
        int n = arr.length;
        Arrays.sort(arr);
        List<List<Integer>> ans = new ArrayList<>();
        int i = 0;
        while (i < n - 3) {
            int j = i + 1;
            while (j < n - 2) {
                int k = j + 1;
                int l = n - 1;
                while (k < l) {
                    if ((long)((long)arr[i] + (long)arr[j] + (long)arr[k] + (long)arr[l]) == (long)target) {
                        List<Integer> list = new ArrayList<>(Arrays.asList(arr[i], arr[j], arr[k], arr[l]));
                        ans.add(list);
                        int idx = getNextUnique(arr, k);
                        k = idx;
                        idx = getPrevUnique(arr, l);
                        l = idx;
                    } else if ((long)((long)arr[i] + (long)arr[j] + (long)arr[k] + (long)arr[l]) > (long)target) {
                        int idx = getPrevUnique(arr, l);
                        l = idx;
                    } else {
                        int idx = getNextUnique(arr, k);
                        k = idx;
                    }
                }
                int idx = getNextUnique(arr, j);
                j = idx;
            }
            int idx = getNextUnique(arr, i);
            i = idx;
        }
        return ans;
    }
}