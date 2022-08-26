class Solution
{
    public:
        int n;

        void dfs(int src, vector<vector < int>> &isConnected, vector< bool > &vis)
        {
            vis[src] = true;
            for (int i = 0; i < n; i++)
            {
                if (isConnected[src - 1][i] == 1)
                {
                    if (vis[i + 1] == false)
                    {
                        dfs(i + 1, isConnected, vis);
                    }
                }
            }
        }

        int findCircleNum(vector<vector < int>> &isConnected)
        {
            n = isConnected.size();
            int numOfProvinces = 0;
            vector<bool> vis(n + 1, false);
            for (int i = 1; i <= n; i++)
            {
                if (vis[i] == false)
                {
                    dfs(i, isConnected, vis);
                    numOfProvinces++;
                }
            }

            return numOfProvinces;
        }
};