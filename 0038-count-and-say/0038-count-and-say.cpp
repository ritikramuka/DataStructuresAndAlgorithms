class Solution {
public:
    string countAndSay(int n) {
        if (n == 1) return "1";
        
        string str = "1";
        for (int i = 2; i <= n; i++) {
            string nextString = "";
            int cnt = 1;
            char ch = str[0];
            
            for (int j = 1; j < str.size(); j++) {
                if (ch == str[j]) {
                    cnt++;
                } else {
//                      cnt = 1, ch = '2' -> cnt + ch = '3' or '12'
//                      nextString += cnt + '' + ch;
                    nextString += to_string(cnt) + ch;
                    ch = str[j];
                    cnt = 1;
                }
            }
            nextString += to_string(cnt) + ch;
            str = nextString;
        }
        
        return str;
    }
};