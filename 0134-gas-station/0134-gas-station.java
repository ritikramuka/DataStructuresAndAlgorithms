class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totol_gas = 0;
	    for (int g : gas) {
	        totol_gas += g;
	    }
	    
	    int total_cost = 0;
	    for (int c : cost) {
	        total_cost += c;
	    }
	    
	    if (totol_gas < total_cost) {
	        return -1;
	    }
	    
	    int remaining = 0;
	    int idx = 0;
	    for (int i = 0; i < gas.length; i++) {
	        remaining += gas[i] - cost[i];
	        if (remaining < 0) {
	            idx = i + 1;
	            remaining = 0;
	        }
	    }
	    
	    return idx;
    }
}