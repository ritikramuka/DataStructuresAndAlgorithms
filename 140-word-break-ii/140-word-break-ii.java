class Solution {
    public class Trie {
        Trie[] childs;
        boolean eow;
        
        public Trie() {
            childs = new Trie[26];
            eow = false;
        }
        
        public void insert(String word) {
            Trie root = this;
            for(int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if(root.childs[ch - 'a'] == null) {
                    root.childs[ch - 'a'] = new Trie();
                }
                root = root.childs[ch - 'a'];
            }
            root.eow = true;
        }
        
        public boolean search(String word) {
            Trie root = this;
            for(int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if(root.childs[ch - 'a'] == null) {
                    return false;
                }
                root = root.childs[ch - 'a'];
            }
            return root.eow;
        }
    }
    
    public void construct(Trie root, List<String> words) {
        for(String word : words) {
            root.insert(word);
        }
    }
    
    public void dfs(Trie root, String s, int idx, String str, List<String> ans) {
        if(idx == s.length()) {
            ans.add(str.substring(0, str.length() - 1));
            return;
        }
        
        String currStr = "";
        for(int i = idx; i < s.length(); i++) {
            currStr += s.charAt(i);
            if(root.search(currStr) == true) {
                dfs(root, s, i + 1, str + currStr + " ", ans);
            }
        }
    }
    
    public List<String> wordBreak(String s, List<String> wordDict) {
        Trie root = new Trie();
        construct(root, wordDict);
        
        List<String> ans = new ArrayList<>();
        dfs(root, s, 0, "", ans);
        return ans;
    }
}