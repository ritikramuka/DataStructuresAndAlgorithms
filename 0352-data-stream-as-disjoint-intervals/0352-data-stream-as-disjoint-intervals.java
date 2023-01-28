class SummaryRanges {
    
    TreeMap<Integer, Integer> map;

    public SummaryRanges() {
        map = new TreeMap<>();
    }
    
    public void addNum(int value) {
        Integer lb = map.floorKey(value);
        Integer ub = map.ceilingKey(value);
        
        if (lb != null && ub != null && value - 1 == map.get(lb) && value + 1 == ub) {
            map.put(lb, map.get(ub));
            map.remove(ub);
        } else if (lb != null && value <= map.get(lb) + 1) {
            map.put(lb, Math.max(map.get(lb), value));
        } else if (ub != null && value + 1 == ub) {
            map.put(value, map.get(ub));
            map.remove(ub);
        } else {
            map.put(value, value);
        }
    }
    
    public int[][] getIntervals() {
        int[][] intervals = new int[map.size()][2];
        int i = 0;
        for (int key : map.keySet()) {
            intervals[i][0] = key;
            intervals[i][1] = map.get(key);
            i++;
        }
        return intervals;
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(value);
 * int[][] param_2 = obj.getIntervals();
 */