class Solution {
    public boolean helper(String s, String t) {
        HashMap<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i)) == true) {
                if (map.get(s.charAt(i)) != t.charAt(i)) {
                    return false;
                }
            } else {
                map.put(s.charAt(i), t.charAt(i));
            }
        }
        return true;
    }
    
    public boolean isIsomorphic(String s, String t) {
        boolean check1 = helper(s, t);
        boolean check2 = helper(t, s);
        
        if (check1 == false || check2 == false) {
            return false;
        }
        
        return true;
    }
}