//{ Driver Code Starts
//Initial Template for Java


import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.*;

class Node {
	int data;
	Node left;
	Node right;

	Node(int data) {
		this.data = data;
		left = null;
		right = null;
	}
}

class GfG {

	static Node buildTree(String str) {

		if (str.length() == 0 || str.charAt(0) == 'N') {
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
		while (queue.size() > 0 && i < ip.length) {

			// Get and remove the front of the queue
			Node currNode = queue.peek();
			queue.remove();

			// Get the current node's value from the string
			String currVal = ip[i];

			// If the left child is not null
			if (!currVal.equals("N")) {

				// Create the left child for the current node
				currNode.left = new Node(Integer.parseInt(currVal));
				// Push it to the queue
				queue.add(currNode.left);
			}

			// For the right child
			i++;
			if (i >= ip.length)
				break;

			currVal = ip[i];

			// If the right child is not null
			if (!currVal.equals("N")) {

				// Create the right child for the current node
				currNode.right = new Node(Integer.parseInt(currVal));

				// Push it to the queue
				queue.add(currNode.right);
			}
			i++;
		}

		return root;
	}

	static void printInorder(Node root) {
		if (root == null)
			return;

		printInorder(root.left);
		System.out.print(root.data + " ");

		printInorder(root.right);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		while (t > 0) {
			String s = br.readLine();
			int target = Integer.parseInt(br.readLine());
			Node root = buildTree(s);

			Solution g = new Solution();
			System.out.println(g.minTime(root, target));
			t--;

		}
	}
}



// } Driver Code Ends


//User function Template for Java

class Solution
{
    /*class Node {
    	int data;
    	Node left;
    	Node right;
    
    	Node(int data) {
    		this.data = data;
    		left = null;
    		right = null;
    	}
    }*/
    
    public static void getParent (Node root, HashMap<Node, Node> parent)
    {
        if (root == null) return;
        
        if (root.left != null) 
        {
            parent.put(root.left, root);
        }
        
        if (root.right != null) 
        {
            parent.put(root.right, root);
        }
        
        getParent(root.left, parent);
        getParent(root.right, parent);
    }
    
    public static Node findTarget (Node root, int target) 
    {
        if (root == null) 
        {
            return null;
        }
        
        if (root.data == target) 
        {
            return root;
        }
        
        Node filc = findTarget(root.left, target);
        if (filc != null) 
        {
            return filc;
        }
        
        Node firc = findTarget(root.right, target);
        if (firc != null) 
        {
            return firc;
        }
        
        return null;
    }
    
    public static int minTime(Node root, int target) 
    {
        // Your code goes here
        HashMap<Node, Node> parent = new HashMap<>();
        getParent(root, parent);
        
        Node targetNode = findTarget(root, target);
        
        Queue<Node> que = new ArrayDeque<>();
        que.add(targetNode);
        
        HashSet<Node> burned = new HashSet<>();
        burned.add(targetNode);
        
        int level = 0;
        while (que.size() != 0) 
        {
            int size = que.size();
            while (size > 0) 
            {
                Node rnode = que.remove();
                
                if (rnode.left != null && burned.contains(rnode.left) == false) 
                {
                    burned.add(rnode.left);
                    que.add(rnode.left);
                }
                
                if (rnode.right != null && burned.contains(rnode.right) == false) 
                {
                    burned.add(rnode.right);
                    que.add(rnode.right);
                }
                
                if (parent.getOrDefault(rnode, null) != null && burned.contains(parent.get(rnode)) == false) 
                {
                    burned.add(parent.get(rnode));
                    que.add(parent.get(rnode));
                }
                
                size--;    
            }
            level++;
        }
        
        return level - 1;
    }
}