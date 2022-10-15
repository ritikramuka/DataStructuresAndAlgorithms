class Solution {
    public boolean validMountainArray(int[] arr) {
        int i = 0;
        while (i + 1 < arr.length && arr[i] < arr[i + 1]) {
            i++;
        }
        int j = arr.length - 1;
        while (j - 1 >= 0 && arr[j] < arr[j - 1]) {
            j--;
        }
        
        if(i == 0) return false;
        
        if(j == arr.length - 1) return false;
        
        return i == j;
    }
}