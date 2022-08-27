class Solution {
public:
    int ladderLength(string beginWord, string endWord, vector<string>& wordList) {
        wordList.push_back(beginWord);
        unordered_set<string> dict(wordList.begin(), wordList.end());
        unordered_map<string, unordered_set<string>> gp;
        for(string word : wordList) {
            for(int i = 0; i < word.size(); i++) {
                string w = word;
                char ch = word[i];
                for(int j = 0; j < 26; j++) {
                    word[i] = (char)(j + 'a');
                    if(word[i] != ch and dict.find(word) != dict.end()) {
                        gp[w].insert(word);
                    }
                }
                word = w;
            }
        }
        
        queue<string> que;
        que.push(beginWord);
        dict.erase(beginWord);
        int trans = 1;
        while(que.size() != 0) {
            int size = que.size();
            while(size--> 0) {
                string rs = que.front();
                que.pop();
                
                for(string str : gp[rs]) {
                    if(str == endWord) {
                        return trans + 1;
                    }
                    
                    if(dict.find(str) != dict.end()) {
                        dict.erase(str);
                        que.push(str);
                    }
                }
            }
            trans++;
        }
        
        return 0;
    }
};