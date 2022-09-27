class Solution {

    public String countAndSay(int n) {
        if (n == 1) {
            System.out.println("1");
        }

        String ans = "1";
        for (int i = 2; i <= n; i++) {
            String nextAns = "";
            int j = 1;
            char ch = ans.charAt(0);
            int cnt = 1;
            while (j < ans.length()) {
                if (ch == ans.charAt(j)) {
                    cnt++;
                } else {
                    nextAns += cnt + "" + ch;
                    ch = ans.charAt(j);
                    cnt = 1;
                }
                j++;
            }
            nextAns += cnt + "" + ch;
            ans = nextAns;
        }
        return ans;
    }
}
