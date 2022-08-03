class Solution {
    
    public int[] mergeTwoSortedArray(int[] a, int[] b) {
        int n = a.length;
        int m = b.length;
        int[] arr = new int[n + m];
        int i = 0, j = 0, k = 0;
        while(i < n && j < m) {
            if(a[i] < b[j]) {
                arr[k] = a[i];
                i++;
            }
            else {
                arr[k] = b[j];
                j++;
            }
            k++;
        }
        while(i < n) {
            arr[k] = a[i];
            i++;
            k++;
        }
        while(j < m) {
            arr[k] = b[j];
            j++;
            k++;
        }
        return arr;
    }
    
    public int[] mergeSort(int[] nums, int l, int r) {
        if(l == r) {
            int[] ba = new int[1];
            ba[0] = nums[l];
            return ba;
        }
        
        int mid = (l + r) / 2;
        int[] fsa = mergeSort(nums, l, mid);
        int[] ssa = mergeSort(nums, mid + 1, r);
        
        return mergeTwoSortedArray(fsa, ssa);
    } 
    
    public int[] sortArray(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }
}