/*
// Definition for a Node.
class Node {
public:
    int val;
    vector<Node*> neighbors;
    Node() {
        val = 0;
        neighbors = vector<Node*>();
    }
    Node(int _val) {
        val = _val;
        neighbors = vector<Node*>();
    }
    Node(int _val, vector<Node*> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
};
*/

class Solution {
public:
    unordered_map<Node*, Node*> vis;
    Node* cloneGraph(Node* node) {
        if(node == NULL)
            return NULL;
        
        if(vis[node] != NULL)
            return vis[node];
        
        Node* clone = new Node(node->val);
        vis[node] = clone;
        for(Node* neighbor : node->neighbors) {
            Node* cloneNeighbor = cloneGraph(neighbor);
            clone->neighbors.push_back(cloneNeighbor);
        }
        
        return clone;
    }
};