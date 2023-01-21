class Solution {
    boolean isValid(String sec){
        if((sec.length() > 1 && sec.charAt(0) == '0') || Integer.parseInt(sec) > 255){
            return false;
        }
        
        return true;
    }
    
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        
        if(s.length() < 4 || s.length() > 12) {
            return res;
        }
        
        int len = s.length();
        for(int i = 1; i < 4 && i < len - 2; i++){
            for(int j = i + 1 ;j < i + 4 && j < len - 1; j++){
                for(int k = j + 1; k < j + 4 && k < len; k++){
                    String sec1 = s.substring(0, i);
                    String sec2 = s.substring(i, j);
                    String sec3 = s.substring(j, k);
                    String sec4 = s.substring(k);
                    
                    if(isValid(sec1) && isValid(sec2) && isValid(sec3) && isValid(sec4)){
                        res.add(sec1 + "." + sec2 + "." + sec3 + "." + sec4);
                    }
                }
            }
            
        }
        return res;
    }
}