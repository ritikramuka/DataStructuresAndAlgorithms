class Solution {
public:
    string decodeMessage(string key, string message) {
        vector<char> code(26, '$');
        char ch = 'a';
        for (int i = 0; i < key.size(); i++) {
            char tempChar = key[i];
            
            if (tempChar == ' ') {
                continue;
            }
            
            if (code[tempChar - 'a'] == '$') {
                code[tempChar - 'a'] = ch;
                ch += 1;
            } else {
                continue;
            }
        }
        
        string ans = "";
        for (int i = 0; i < message.size(); i++) {
            char tempChar = message[i];
            if (tempChar == ' ') {
                ans += tempChar;
            }
            else {
               ans += code[tempChar - 'a']; 
            }
        }
        
        return ans;
    }
};