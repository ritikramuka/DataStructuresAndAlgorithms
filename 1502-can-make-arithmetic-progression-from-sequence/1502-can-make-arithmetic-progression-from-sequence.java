class Solution {
    public boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
        int diff = arr[1] - arr[0];
        for(int i = 1; i < arr.length - 1; i++) {
            int currDiff = arr[i + 1] - arr[i];
            if(currDiff != diff) {
                return false;
            }
        }
        return true;
    }
}