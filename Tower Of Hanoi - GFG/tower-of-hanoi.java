//{ Driver Code Starts
// Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class Recursion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();//total testcases
        while (T-- > 0) {
            Hanoi obj = new Hanoi();
            int N;
            
            //taking input N
            N = sc.nextInt();

            //calling toh() method 
            System.out.println(obj.toh(N, 1, 3, 2));
        }
    }
}






// } Driver Code Ends


// User function Template for Java


// avoid space at the starting of the string in "move disk....."
class Hanoi {

    public long toh(int N, int A, int C, int B) {
        // Your code here
        if (N == 0) {
            return 0;
        }
        
        long a = toh (N - 1, A, B, C);
        
        // my work
        System.out.println ("move disk " + N + " from rod " + A + " to rod " + C);
        
        long b = toh (N - 1, B, C, A);
        
        return a + 1 + b;
    }
}
