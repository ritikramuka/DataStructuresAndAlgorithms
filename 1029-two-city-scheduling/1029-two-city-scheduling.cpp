class Solution {
public:
    int twoCitySchedCost(vector<vector<int>>& costs) {
        sort(costs.begin(),costs.end(), [](vector<int>&a,vector<int>&b){
            return a[0]-a[1]<b[0]-b[1];
        });
        int cost=0;
        int n=costs.size()/2;
        for(int i=0;i<n;i++)
            cost+=costs[i][0]+costs[n+i][1];
        return cost;
    }
};