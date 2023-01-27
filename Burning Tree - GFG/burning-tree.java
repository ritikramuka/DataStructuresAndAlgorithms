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
    
    public static void getParent(Node root, HashMap<Node, Node> parent) {
        if(root == null) {
            return;
        }
        
        if(root.left != null) {
            parent.put (root.left, root);
        }
        
        if(root.right != null) {
            parent.put (root.right, root);
        }
        
        getParent(root.left, parent);
        getParent(root.right, parent);
    }
    
    public static Node findNode(Node root, int target) {
        if (root == null) {
            return null;
        }
        
        if (root.data == target) {
            return root;
        }
        
        Node ls = findNode(root.left, target);
        if(ls != null) {
            return ls;
        }
        
        Node rs = findNode(root.right, target);
        if(rs != null) {
            return rs;
        }
        
        return null;
    }
    
    public static int minTime(Node root, int target) {
        // Your code goes here
        HashMap<Node, Node> parent = new HashMap<>();
        getParent(root, parent);
        
        Queue<Node> que = new ArrayDeque<>();
        Node t = findNode(root, target);
        que.add(t);
        int time = 0;
        
        HashSet<Node> vis = new HashSet<>();
        vis.add(t);
        
        while (que.size() != 0) {
            int size = que.size();
            while (size-- > 0) {
                Node rnode = que.remove();
                
                if (rnode.left != null && vis.contains(rnode.left) == false) {
                    que.add(rnode.left);
                    vis.add(rnode.left);
                }
                
                if (rnode.right != null && vis.contains(rnode.right) == false) {
                    que.add(rnode.right);
                    vis.add(rnode.right);
                }
                
                if (parent.get(rnode) != null && vis.contains(parent.get(rnode)) == false) {
                    que.add(parent.get(rnode));
                    vis.add(parent.get(rnode));
                }
            }
            time++;
        }
        
        return time - 1;
    }
}