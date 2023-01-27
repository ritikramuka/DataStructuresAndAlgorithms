/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    void findParent(TreeNode* root, unordered_map<TreeNode*, TreeNode*>& parent) {
        if (root == nullptr) {
            return;
        }
        
        if (root->left != nullptr) {
            parent[root->left] = root;
        }
        
        if (root->right != nullptr) {
            parent[root->right] = root;
        }
        
        findParent(root->left, parent);
        findParent(root->right, parent);
    }
    
    TreeNode* find(TreeNode* root, int target) {
        if (root == nullptr) {
            return nullptr;
        }
        
        if (root->val == target) {
            return root;
        }
        
        TreeNode* filc = find(root->left, target);
        if (filc != nullptr) {
            return filc;
        }
        
        TreeNode* firc = find(root->right, target);
        if (firc != nullptr) {
            return firc;
        }
        
        return nullptr;
    }
    
    int amountOfTime(TreeNode* root, int start) {
        unordered_map<TreeNode*, TreeNode*> parent;
        findParent(root, parent);
        
        TreeNode* startNode = find(root, start);
        
        queue<TreeNode*> que;
        que.push(startNode);
        
        unordered_set<TreeNode*> infected;
        infected.insert(startNode);
        
        int time = -1;
        
        while (que.size() > 0) {
            int size = que.size();
            while (size-->0) {
                TreeNode* rnode = que.front();
                que.pop();
                
                if (rnode->left != nullptr && infected.find(rnode->left) == infected.end()) {
                    que.push(rnode->left);
                    infected.insert(rnode->left);
                }
                
                if (rnode->right != nullptr && infected.find(rnode->right) == infected.end()) {
                    que.push(rnode->right);
                    infected.insert(rnode->right);
                }
                
                if (parent.find(rnode) != parent.end() && infected.find(parent[rnode]) == infected.end()) {
                    que.push(parent[rnode]);
                    infected.insert(parent[rnode]);
                }
            }
            time++;
        }
        
        return time;
    }
};