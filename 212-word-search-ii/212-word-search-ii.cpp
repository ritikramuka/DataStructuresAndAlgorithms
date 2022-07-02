class Solution {
public:
    class Trie {
        public:
            Trie *childs[26];
            bool eow;
            string word;
            Trie() {
                for(int i = 0; i < 26; i++) childs[i] = nullptr;
                eow = false;
                word = "";
            }
    };
    
    void insert(Trie *root, string& word) {
        Trie *curr = root;
        for(char ch : word) {
            if(curr->childs[ch - 'a'] == nullptr) {
                curr->childs[ch - 'a'] = new Trie();
            }
            curr = curr->childs[ch - 'a'];
        }
        curr->eow = true;
        curr->word = word;
    }
    
    int dir[4][2] = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    void find(vector<vector<char>>& board, int sr, int sc, Trie *node, vector<string>& ans) {
        if(node->eow == true) {
            ans.push_back(node->word);
            node->eow = false;
        }
        
        char ch = board[sr][sc];
        board[sr][sc] = '.';
        for(int d = 0; d < 4; d++) {
            int nr = sr + dir[d][0];
            int nc = sc + dir[d][1];
            
            if(nr >= 0 && nr < board.size() && nc >= 0 && nc < board[0].size() && board[nr][nc] != '.' && node->childs[board[nr][nc] - 'a']) {
                find(board, nr, nc, node->childs[board[nr][nc] - 'a'], ans);
            }
        }
        board[sr][sc] = ch;
    }
    
    vector<string> findWords(vector<vector<char>>& board, vector<string>& words) {
        Trie *root = new Trie();
        for(string& word : words) {
            insert(root, word);
        }
        
        vector<string> ans;
        int n = board.size();
        int m = board[0].size();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(root->childs[board[i][j] - 'a'] != nullptr) {
                    find(board, i, j, root->childs[board[i][j] - 'a'], ans);
                }
            }
        }
        
        return ans;
    }
};