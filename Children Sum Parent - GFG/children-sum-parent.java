//{ Driver Code Starts
//Initial Template for Java




//Initial Template for Java

//Contributed by Sudarshan Sharma
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


class GfG {
    
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
    void inOrder(Node node) {
        if (node == null) {
            return;
        }
 
        inOrder(node.left);
        System.out.print(node.data + " ");
 
        inOrder(node.right);
    }
    
	public static void main (String[] args) throws IOException{
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	        int t=Integer.parseInt(br.readLine());
    
	        while(t-- > 0){
	            String s = br.readLine();
    	    	Node root = buildTree(s);
			    Tree g=new Tree();
                System.out.println(g.isSumProperty(root));
    	        
	        }
	}
}


// } Driver Code Ends


//User function Template for Java


/*Complete the function below
Node is as follows:
class Node{
	int data;
	Node left,right;
	
	Node(int key)
	{
	    data = key;
	    left = right = null;
	}
}

*/
class Tree
{
    //Function to check whether all nodes of a tree have the value 
    //equal to the sum of their child nodes.
    public static int isSumProperty(Node root)
    {
        // add your code here
        if (root == null) {
            return 1;
        }
        
        // if leaf node, then return true
        if (root.left == null && root.right == null) {
            return 1;
        }
        
        int isFollowedInLeftSubTree = isSumProperty(root.left);
        
        int isFollowedInRightSubTree = isSumProperty(root.right);
        
        int childrenSum = 0;
        if (root.left != null) {
            childrenSum += root.left.data;
        }
        if (root.right != null) {
            childrenSum += root.right.data;
        }
        
        int isFollowedAtRoot = 0;
        if (childrenSum == root.data) {
            isFollowedAtRoot = 1;
        }
        
        if (isFollowedInLeftSubTree == 1 && isFollowedInRightSubTree == 1 && isFollowedAtRoot == 1) {
            return 1;
        } else {
            return 0;
        }
    }
}