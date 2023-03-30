class Solution {
    public int[] avoidFlood(int[] rains) {
        int n = rains.length;
		int[] ans = new int[n];

		// {lake -> last time rained}
		HashMap<Integer, Integer> lastRain = new HashMap<>();

		TreeSet<Integer> dry = new TreeSet<>();

		for (int i = 0; i < n; i++) {
			int lake = rains[i];

			if (lake == 0) {
				// this is drying day
				dry.add(i);

				// by default value, when you don't use this dry day
				ans[i] = 1;
			} else {
				if (lastRain.containsKey(lake) == false) {
					// never rained here
					lastRain.put(lake, i);
				} else {
					Integer dryOnThisDay = dry.higher(lastRain.get(lake));
					if (dryOnThisDay == null) {
						// flooding
						return new int[0];
					} else {
						ans[dryOnThisDay] = lake;
						lastRain.put(lake, i);
						dry.remove(dryOnThisDay);
					}
				}
				ans[i] = -1;
			}
		}

		return ans;
    }
}