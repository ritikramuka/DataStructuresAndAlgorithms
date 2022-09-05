class Solution {
    public List<Integer> findAnagrams(String p, String s) {
        int n = p.length();
        int m = s.length();
        
        if(n < m) return new ArrayList();
        
        HashMap<Character, Integer> smap = new HashMap<>();
        for (int i = 0; i < m; i++) {
            smap.put(s.charAt(i), smap.getOrDefault(s.charAt(i), 0) + 1);
        }

        HashMap<Character, Integer> pmap = new HashMap<>();
        for (int i = 0; i < m; i++) {
            pmap.put(p.charAt(i), pmap.getOrDefault(p.charAt(i), 0) + 1);
        }

        List<Integer> ans = new ArrayList<>();
        int acquire = m;
        int release = 0;
        while (acquire < n) {
            if (smap.equals(pmap) == true) {
                ans.add(release);
            }

            char acquireChar = p.charAt(acquire);
            pmap.put(acquireChar, pmap.getOrDefault(acquireChar, 0) + 1);

            char releaseChar = p.charAt(release);
            if (pmap.get(releaseChar) == 1) {
                pmap.remove(releaseChar);
            } else {
                pmap.put(releaseChar, pmap.get(releaseChar) - 1);
            }

            release++;
            acquire++;
        }

        if (smap.equals(pmap) == true) {
            ans.add(release);
        }

        return ans;
    }
}
