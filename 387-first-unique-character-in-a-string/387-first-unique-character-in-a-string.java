class Solution {
    public int firstUniqChar(String s) {
        int n = s.length();
        HashMap<Character, Integer> countOfChar = new HashMap<>();
        
        for(int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if(countOfChar.containsKey(ch) == true) {
                int currCount = countOfChar.get(ch);
                countOfChar.put(ch, currCount + 1);
            } else {
                countOfChar.put(ch, 1);
            }
        }
        
        for(int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if(countOfChar.get(ch) == 1) {
                return i;
            }
        }
        
        return -1;
    }
}