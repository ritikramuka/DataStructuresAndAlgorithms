class Solution
{
    public:
        void dfs(int src, vector<vector < int>> &gp, vector< bool > &vis)
        {
            vis[src] = true;
            for (int desti: gp[src])
            {
                if (vis[desti] == false)
                {
                    dfs(desti, gp, vis);
                }
            }
        }

        int findCircleNum(vector<vector < int>> &isConnected)
        {
            int n = isConnected.size();
            vector<vector < int>> gp(n);
            for (int i = 0; i < n; i++)
            {
                for (int j = 0; j < n; j++)
                {
                    if (isConnected[i][j] == 1)
                    {
                        gp[i].push_back(j);
                        gp[j].push_back(i);
                    }
                }
            }

            int numOfProvinces = 0;
            vector<bool> vis(n, false);
            for (int i = 0; i < n; i++)
            {
                if (vis[i] == false)
                {
                    dfs(i, gp, vis);
                    numOfProvinces++;
                }
            }

            return numOfProvinces;
        }
};