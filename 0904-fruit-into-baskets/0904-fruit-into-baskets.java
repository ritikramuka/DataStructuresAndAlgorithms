class Solution {
    public int totalFruit(int[] fruits) {
        int currFruitType = -1;
        int firstFruitType = -1;
        int secondFruitType = -1;
        
        int lastFruitTypeConsecutiveCount = 0;
        
        int maxFruits = 0;
        int currFruits = 0;
        
        for (int i = 0; i < fruits.length; i++) {
            currFruitType = fruits[i];
            
            if (currFruitType == secondFruitType) {
                lastFruitTypeConsecutiveCount += 1;
                currFruits += 1;
            } else if (currFruitType == firstFruitType) {
                firstFruitType = secondFruitType;
                secondFruitType = currFruitType;
                lastFruitTypeConsecutiveCount = 1;
                currFruits += 1;
            } else {
                currFruits = lastFruitTypeConsecutiveCount + 1;
                firstFruitType = secondFruitType;
                secondFruitType = currFruitType;
                lastFruitTypeConsecutiveCount = 1;
            }
            
            maxFruits = Math.max(maxFruits, currFruits);
        }
        
        return maxFruits;
    }
}