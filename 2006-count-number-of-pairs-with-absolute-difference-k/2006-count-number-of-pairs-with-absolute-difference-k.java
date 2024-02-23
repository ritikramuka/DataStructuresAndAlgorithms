class Solution {
    public int countKDifference(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int num : nums) {
            int y1 = num + k;
            int y2 = num - k;
            
            if (map.containsKey(y1) == true) {
                count += map.get(y1);
            }
            if (map.containsKey(y2) == true) {
                count += map.get(y2);
            }
            
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        return count;
    }
}