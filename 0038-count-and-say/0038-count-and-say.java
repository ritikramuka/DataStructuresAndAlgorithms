class Solution {

    public String countAndSay(int n) {
        if (n == 1) return "1";
        
        String str = "1";
        for (int i = 2; i <= n; i++) {
            String nextString = "";
            int cnt = 1;
            char ch = str.charAt(0);
            
            for (int j = 1; j < str.length(); j++) {
                if (ch == str.charAt(j)) {
                    cnt++;
                } else {
//                      cnt = 1, ch = '2' -> cnt + ch = '3' or '12'
//                      nextString += cnt + '' + ch;
                    nextString += cnt + "" + ch;
                    ch = str.charAt(j);
                    cnt = 1;
                }
            }
            nextString += cnt + "" + ch;
            str = nextString;
        }
        
        return str;
    }
}
