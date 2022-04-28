class Solution {
public:
    int minimumEffortPath(vector<vector<int>>& heights) {
        priority_queue<vector<int>,vector<vector<int>>,greater<vector<int>>> parq;
        int ans=0;
        vector<vector<int>> move={{0,1},{1,0},{-1,0},{0,-1}};
        int n=heights.size();
        int m=heights[0].size();
        parq.push({0,0,0});
        while(parq.size()){
            vector<int> p=parq.top();
            parq.pop();
            ans=max(ans,p[0]);
            int i=p[1];
            int j=p[2];
            if(heights[i][j]==-1)
                continue;
            if(i==n-1 && j==m-1)
                break;
            for(int c=0;c<move.size();c++){
                int ni=i+move[c][0];
                int nj=j+move[c][1];
                if(ni<0||nj<0 || nj==m||ni==n || heights[ni][nj]==-1){
                    continue;
                }
                parq.push({abs(heights[i][j]-heights[ni][nj]),ni,nj});
            }
            heights[i][j]=-1;
        }
        return ans;
        
    }
};