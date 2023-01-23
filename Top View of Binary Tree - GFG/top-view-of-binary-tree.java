//{ Driver Code Starts
//Initial Template for JAVA

import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;
import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

public class Tree {
    
    static Node buildTree(String str){
        
        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }
        
        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue
        
        Queue<Node> queue = new LinkedList<>(); 
        
        queue.add(root);
        // Starting from the second element
        
        int i = 1;
        while(queue.size()>0 && i < ip.length) {
            
            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();
                
            // Get the current node's value from the string
            String currVal = ip[i];
                
            // If the left child is not null
            if(!currVal.equals("N")) {
                    
                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }
                
            // For the right child
            i++;
            if(i >= ip.length)
                break;
                
            currVal = ip[i];
                
            // If the right child is not null
            if(!currVal.equals("N")) {
                    
                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));
                    
                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }
        
        return root;
    }
    static void printInorder(Node root)
    {
        if(root == null)
            return;
            
        printInorder(root.left);
        System.out.print(root.data+" ");
        
        printInorder(root.right);
    }
    
	public static void main (String[] args) throws IOException{
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	        int t=Integer.parseInt(br.readLine());
    
	        while(t > 0){
	            String s = br.readLine();
    	    	Node root = buildTree(s);
    	    	
                Solution ob = new Solution();

                ArrayList<Integer> vec = ob.topView(root);
                for(int x : vec)
                    System.out.print(x + " ");
                System.out.println();
        	
                t--;   
        }
    }
}
// } Driver Code Ends


//User function Template for Java

/*
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}
*/

class Solution
{
    static int minLevel;
    static int maxLevel;
    
    public static void verticalLevels (Node root, int level) {
        if (root == null) {
            return;
        }
        
        verticalLevels(root.left, level - 1);
        verticalLevels(root.right, level + 1);
        
        minLevel = Math.min(level, minLevel);
        maxLevel = Math.max(level, maxLevel);
    }
    
    static class Pair implements Comparable<Pair> {
        Node node;
        int vLevel;
        
        Pair (Node node, int vLevel) {
            this.node = node;
            this.vLevel = vLevel;
        }
        
        @Override
        public int compareTo(Pair o) {
            if (this.vLevel == o.vLevel) {
                return this.node.data - o.node.data;
            }
            
            return this.vLevel - o.vLevel;
        }
    }
    
    
    //Function to return a list of nodes visible from the top view 
    //from left to right in Binary Tree.
    static ArrayList<Integer> topView(Node root)
    {
        // add your code
        minLevel = 0;
        maxLevel = 0;
        verticalLevels (root, 0);
        int width = maxLevel - minLevel;
        int numberOfLevels = width + 1;
        
        ArrayList<Integer> tv = new ArrayList<>();
        for (int i = 0; i < numberOfLevels; i++) {
            tv.add(Integer.MIN_VALUE);
        }
        
        PriorityQueue<Pair> Ppq = new PriorityQueue<>();
        Ppq.add(new Pair(root, -minLevel));
        
        while (Ppq.size() > 0) {
            int size = Ppq.size();
            
            PriorityQueue<Pair> Cpq = new PriorityQueue<>();
            while (size > 0) {
                Pair rpair = Ppq.remove();
                
                if (tv.get(rpair.vLevel) == Integer.MIN_VALUE) {
                    tv.set(rpair.vLevel, rpair.node.data);
                }
                
                if (rpair.node.left != null) {
                    Cpq.add(new Pair(rpair.node.left, rpair.vLevel - 1));
                }
                
                if (rpair.node.right != null) {
                    Cpq.add(new Pair(rpair.node.right, rpair.vLevel + 1));
                }
                
                size--;
            }
            
            Ppq = Cpq;
        }
        
        return tv;
        
    }
}