//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            String str = br.readLine();
            
            Solution obj = new Solution();
            System.out.println(obj.findSubString(str));
            
        }
	}
}


// } Driver Code Ends


//User function Template for Java

class Solution {
    public int findSubString( String s ) {
        // Your code goes here
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            set.add(ch);
        }

        int len = Integer.MAX_VALUE;
        HashMap<Character, Integer> map = new HashMap<>();
        int i = -1;
        int j = -1;
        while (true) {
            boolean f1 = false;
            boolean f2 = false;

            // acquire
            while (i < s.length() - 1 && map.size() < set.size()) {
                i++;
                char ch = s.charAt(i);
                map.put(ch, map.getOrDefault(ch, 0) + 1);
                
                f1 = true;
            }

            // release and ans
            while (j < i && map.size() == set.size()) {
                int currLen = i - j;
                if(currLen < len) {
                    len = currLen;
                }

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

        return len;
    }
}