class Solution {
public:
    int ladderLength(string beginWord, string endWord, vector<string>& wordList) {
        int n = wordList.size();
        unordered_map<string, int> umap;
        bool hasStart = false, hasEnd = false;
        for(int i = 0; i < n; i++) {
            string word = wordList[i];
            if(word == beginWord) hasStart = true;
            umap[word] = i;
        }
        
        if(hasStart == false) {
            wordList.push_back(beginWord);
            umap[beginWord] = n;
            n++;
        }
        
        vector<vector<int>> gp(n);
        for(int i = 0; i < n; i++) {
            string word = wordList[i];
            for(int j = 0; j < word.size(); j++) {
                for(int k = 0; k < 26; k++) {
                    word[j] = (k + 'a');
                    if((umap.find(word) != umap.end())) {
                        gp[umap[word]].push_back(umap[wordList[i]]);
                        gp[umap[wordList[i]]].push_back(umap[word]);
                    }
                }
                word = wordList[i];
            }
        }
        
        int len = 1;
        int si = umap[beginWord];
        queue<int> que;
        que.push(si);
        vector<int> vis(n, false);
        while(que.size() != 0) {
            int size = que.size();
            while(size-->0) {
                int ridx = que.front();
                que.pop();
                if(vis[ridx] == false) {
                    vis[ridx] = true;
                    for(int i : gp[ridx]) {
                        if(wordList[i] == endWord) return len + 1;
                        if(vis[i] == false) {
                            que.push(i);
                        }
                    }
                }
            }
            len++;
        }
        
        return 0;
    }
};