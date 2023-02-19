//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Node  
{ 
    int data; 
    Node left, right; 
   
    public Node(int d)  
    { 
        data = d; 
        left = right = null; 
    } 
}

class GFG
{
    static Node buildTree(String str)
    {
        // Corner Case
        if(str.length() == 0 || str.equals('N'))
            return null;
        String[] s = str.split(" ");
        
        Node root = new Node(Integer.parseInt(s[0]));
        Queue <Node> q = new LinkedList<Node>();
        q.add(root);
        
        // Starting from the second element
        int i = 1;
        while(!q.isEmpty() && i < s.length)
        {
              // Get and remove the front of the queue
              Node currNode = q.remove();
        
              // Get the current node's value from the string
              String currVal = s[i];
        
              // If the left child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the left child for the current node
                  currNode.left = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.left);
              }
        
              // For the right child
              i++;
              if(i >= s.length)
                  break;
              currVal = s[i];
        
              // If the right child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the right child for the current node
                  currNode.right = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.right);
              }
              
              i++;
        }
    
        return root;
    }
    
    public static void main(String args[]) throws IOException {
    
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t>0)
        {
            String s = br.readLine();
            Node root = buildTree(s);
            
            Solution T = new Solution();
            
            ArrayList <Integer> res = T.boundary(root);
            for (Integer num : res) System.out.print (num + " ");
            System.out.println();
            t--;
        }
    }
}

// } Driver Code Ends


//User function Template for Java

// class Node  
// { 
//     int data; 
//     Node left, right; 
   
//     public Node(int d)  
//     { 
//         data = d; 
//         left = right = null; 
//     } 
// }

class Solution
{
    ArrayList <Integer> treeBoundry;
    
    void leftBoundry (Node node) {
        if (node == null) {
            return;
        }
        
        if (node.left == null && node.right == null) {
            return;
        } else {
            treeBoundry.add(node.data);   
        }
        
        if (node.left != null) {
            leftBoundry (node.left);
        } else {
            leftBoundry (node.right);
        }
    }
    
    void leafNodes (Node node) {
        if (node == null) {
            return;
        }
        
        if (node.left == null && node.right == null) {
            treeBoundry.add(node.data);
        }
        
        leafNodes (node.left);
        leafNodes (node.right);
    }
    
    void rightBoundry (Node node) {
        if (node == null) {
            return;
        }
        
        if (node.right != null) {
            rightBoundry (node.right);
        } else {
            rightBoundry (node.left);
        }
        
        if (node.left == null && node.right == null) {
            return;
        } else {
            treeBoundry.add(node.data);   
        }
    }
    
	ArrayList <Integer> boundary (Node node) {
	    treeBoundry = new ArrayList<>();
	    
	    // step 1: add root
	    treeBoundry.add(node.data);
	    if (node.left == null && node.right == null) {
	        return treeBoundry;
	    }
	    
	    // step 2: add left boundry from left sub-tree
	    leftBoundry (node.left);
	    
	    // step 3: add leaf nodes
	    leafNodes (node);
	    
	    // step 4: add right boundry from bottom to top from right sub-tree
        rightBoundry (node.right);
        
        return treeBoundry;
	}
}
