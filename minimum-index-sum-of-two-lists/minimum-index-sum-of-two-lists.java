class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }
        
        int leastSum = Integer.MAX_VALUE;
        TreeMap<Integer, List<String>> treeMap = new TreeMap<>();
        for (int i = 0; i < list2.length; i++) {
            if (map.containsKey(list2[i]) == true) {
                if (treeMap.containsKey(i + map.get(list2[i])) == true) {
                    List<String> list = treeMap.get(i + map.get(list2[i]));
                    list.add(list2[i]);
                    treeMap.put(i + map.get(list2[i]), list);
                } else {
                    List<String> list = new ArrayList<>();
                    list.add(list2[i]);
                    treeMap.put(i + map.get(list2[i]), list);
                }
                leastSum = Math.min(leastSum, i + map.get(list2[i]));
            }
        }
        
        int i = 0;
        List<String> list = treeMap.get(leastSum);
        String[] ans = new String[list.size()];
        for (String str : list) {
            ans[i++] = str;
        }
        
        return ans;
    }
}