class Solution {
    public int find(int[] arr, int val) {
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == val)
                return i;
        }
        return -1;
    }
    public boolean canFormArray(int[] arr, int[][] pieces) {
        HashSet<Integer> set = new HashSet();
        for(var a : pieces) {
            for(int e : a) {
                set.add(e);
            }
        }
        for(int e : arr) {
            if(!set.contains(e)) return false;
        }
        
        for(int[] i : pieces) {
            int idx = find(arr, i[0]);
            int t = 1;
            for(int j = idx + 1; t < i.length && j < arr.length; j++, t++) {
                if(arr[j] != i[t]) return false;
            }
            if(t < i.length)
                return false;
        }
        
        return true;
    }
}