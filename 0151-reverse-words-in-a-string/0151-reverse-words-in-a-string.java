class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        String[] strArray = s.split("\\s+");
        int i = 0;
        int j = strArray.length - 1;
        while (i < j) {
            String temp = strArray[i];
            strArray[i] = strArray[j];
            strArray[j] = temp;
            i++;
            j--;
        }
        
        StringBuilder ans = new StringBuilder("");
        for (int k = 0; k < strArray.length; k++) {
            ans.append(strArray[k]);
            if (k < strArray.length - 1) {
                ans.append(" ");
            }
        }
        
        return ans.toString();
    }
}