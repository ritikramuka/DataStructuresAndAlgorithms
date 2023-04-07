class Solution {
    int[] getLeftMax(int[] arr) {
        int n = arr.length;
        int leftMax = Integer.MIN_VALUE;
        int[] lmax = new int[n];

        for (int i = 0; i < n; i++) {
            lmax[i] = leftMax;
            leftMax = Math.max(arr[i], leftMax);
        }

        return lmax;
    }

    int[] getRightMax(int[] arr) {
        int n = arr.length; 
        int rightMax = Integer.MIN_VALUE;
        int[] rmax = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            rmax[i] = rightMax;
            rightMax = Math.max(rightMax, arr[i]);
        }

        return rmax;
    }
    
    public int trap(int[] height) {
        int[] lmax = getLeftMax(height);
        int[] rmax = getRightMax(height);
        
        int totalAmtOfWater = 0;
        for (int i = 0; i < height.length; i++) {
            int heightOfBuilding = height[i];
            int heightOfWaterCanGo = Math.min(lmax[i], rmax[i]);
            
            if (heightOfWaterCanGo > heightOfBuilding) {
                int heightOfWater = heightOfWaterCanGo - heightOfBuilding;
                int amtOfWater = heightOfWater * 1;
                totalAmtOfWater += amtOfWater;
            }
        }
        
        return totalAmtOfWater;
    }
}