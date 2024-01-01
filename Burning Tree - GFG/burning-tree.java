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
    
    public static void traverse(Node root, HashMap<Node, Node> map) 
    {
        if (root == null) 
        {
            return;
        }
        
        if (root.left != null) 
        {
            map.put(root.left, root);
        }
        
        if (root.right != null) 
        {
            map.put(root.right, root);
        }
        
        traverse(root.left, map);
        traverse(root.right, map);
    }
    
    public static Node find(Node root, int target) 
    {
        if (root == null) 
        {
            return null;    
        }    
        
        if (root.data == target) 
        {
            return root;    
        }
        
        Node filc = find(root.left, target);
        if (filc != null) 
        {
            return filc;
        }
        
        Node firc = find(root.right, target);
        if (firc != null)
        {
            return firc;
        }
        
        return null;
    }
    
    public static int minTime(Node root, int target) 
    {
        HashMap<Node, Node> map = new HashMap<>();
        traverse(root, map);
        
        Node src = find(root, target);
        
        Queue<Node> que = new ArrayDeque<>();
        que.add(src);
        
        HashSet<Node> set = new HashSet<>();
        set.add(src);
        
        int time = 0;
        while (que.size() != 0) 
        {
            int size = que.size();
            while (size-->0) 
            {
                Node rnode = que.remove();
                
                if (rnode.left != null && set.contains(rnode.left) == false) 
                {
                    set.add(rnode.left);
                    que.add(rnode.left);
                }
                
                if (rnode.right != null && set.contains(rnode.right) == false) 
                {
                    set.add(rnode.right);
                    que.add(rnode.right);
                }
                
                if (map.get(rnode) != null && set.contains(map.get(rnode)) == false) 
                {
                    set.add(map.get(rnode));
                    que.add(map.get(rnode));
                }
            }
            time++;
        }
        
        if (time == 0) 
        {
            return 0;
        }
        
        return time - 1;
    }
}