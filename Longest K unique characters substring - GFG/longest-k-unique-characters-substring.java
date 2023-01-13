//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            int k = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.longestkSubstr(s, k));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int longestkSubstr(String s, int k) {
        // code here
        HashMap<Character, Integer> map = new HashMap<>();
		
		int i = -1;
		int j = -1;
		int ans = -1;
		while (true) {
			boolean f1 = false;
			boolean f2 = false;
			
			// acquire
			while (i < s.length() - 1 && map.size() <= k) {
				i++;
				char ch = s.charAt(i);
				map.put(ch, map.getOrDefault(ch, 0) + 1);

				if (map.size() == k) {
					int len = i - j;
					ans = Math.max(len, ans);
				}

				f1 = true;
			}

			// release
			while (j < i && map.size() > k) {
				j++;
				char ch = s.charAt(j);
				map.put(ch, map.getOrDefault(ch, 0) - 1);

				if (map.get(ch) == 0) {
					map.remove(ch);
				}

				f2 = true;
			}

			if (f1 == false && f2 == false) {
				break;
			}
		}

		return ans;
    }
}