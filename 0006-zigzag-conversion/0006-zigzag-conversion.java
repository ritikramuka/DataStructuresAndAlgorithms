class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        
        StringBuilder sb = new StringBuilder("");
        int idx = 0;
        
        int jumps = (numRows - 1) * 2;
            
        for (int i = idx; i < s.length(); i += jumps) {
            sb.append(s.charAt(i));
        }
        idx++;
        
        int currJump = jumps;
        while (idx + 1 < numRows) {
            currJump -= 2;
            
            boolean comp = false;
            
            for (int i = idx; i < s.length(); ) {
                sb.append(s.charAt(i));
                if (comp == false) {
                    comp = true;
                    i += currJump;
                } else {
                    comp = false;
                    i += (jumps - currJump);
                }
            }
            
            idx++;
        }
        
        for (int i = idx; i < s.length(); i += jumps) {
            sb.append(s.charAt(i));
        }
        idx++;
        
        return sb.toString();
    }
}