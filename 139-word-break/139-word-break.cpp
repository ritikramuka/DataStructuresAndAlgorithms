class Solution
{
    public:
        /*
        bool rec(string s, int itr, unordered_set<string> &uset)
        {
            if(itr == s.size())
            {
                return true;
            }

            bool ans = false;
            for (int i = itr + 1; i <= s.size(); i++)
            {
                string sstr = s.substr(itr, i - itr);
                if (uset.find(sstr) != uset.end())
                {
                    ans |= rec(s, i, uset);
                }
            }

            return ans;
        }
        **/

        int dp[301];
        int memo(string s, int itr, unordered_set<string> &uset)
        {
            if (itr == s.size())
            {
                return dp[itr] = 1;
            }

            if (dp[itr] != -1)
            {
                return dp[itr];
            }

            int ans = 0;
            for (int i = itr; i < s.size(); i++)
            {
                string sstr = s.substr(itr, i - itr + 1);
                if (uset.find(sstr) != uset.end())
                {
                    ans |= memo(s, i + 1, uset);
                }
            }

            return dp[itr] = ans;
        }

        bool wordBreak(string s, vector<string> &wordDict)
        {
            memset(dp, -1, sizeof(dp));
            unordered_set<string> uset(wordDict.begin(), wordDict.end());
            int ans = memo(s, 0, uset);
            return ans == 1;
        }
};