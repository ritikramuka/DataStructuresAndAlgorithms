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
    void leftBoundry(Node node, ArrayList<Integer> lb) {
        if (node == null) {
            return;
        }
        
        if (node.left == null && node.right == null) {
            
        } else {
            lb.add(node.data);   
        }
        
        if (node.left != null) {
            leftBoundry(node.left, lb);
        } else {
            leftBoundry(node.right, lb);
        }
        
        return;
    }
    
    void leafNodes(Node node, ArrayList<Integer> ln) {
        if (node == null) {
            return;
        }
        
        if (node.left == null && node.right == null) {
            ln.add(node.data);
        }
        
        leafNodes(node.left, ln);
        leafNodes(node.right, ln);
        
        return;
    }
    
    void rightBoundry(Node node, ArrayList<Integer> rb) {
        if (node == null) {
            return;
        }
        
        if (node.right != null) {
            rightBoundry(node.right, rb);
        } else {
            rightBoundry(node.left, rb);
        }
        
        if (node.left == null && node.right == null) {
            
        } else {
            rb.add(node.data);   
        }
        
        return;
    }
    
	ArrayList <Integer> boundary(Node node)
	{
	    ArrayList<Integer> treeBoundry = new ArrayList<>();
	    
	    if (node == null) {
	        return treeBoundry;
	    }
	    
	    treeBoundry.add(node.data);
	    
	    if (node.left == null && node.right == null) {
	        return treeBoundry;
	    }
	    
	    leftBoundry(node.left, treeBoundry);
	    
	    leafNodes(node, treeBoundry);
	    
	    rightBoundry(node.right, treeBoundry);
	    
	    return treeBoundry;
	}
}
