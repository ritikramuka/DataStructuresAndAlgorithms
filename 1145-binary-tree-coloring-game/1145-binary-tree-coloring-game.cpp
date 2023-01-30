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
private:
    int num_of_nodes(TreeNode* root) {
        if(!root)
            return 0;
        
        return num_of_nodes(root->left) + num_of_nodes(root->right) + 1;
    }
    
    void help(TreeNode* root, int x, int& l, int& r) {
        if(!root)
            return;
        
        if(root->val == x) {
            l = num_of_nodes(root->left);
            r = num_of_nodes(root->right);
            return;
        }
        
        help(root->left, x, l, r);
        help(root->right, x, l, r);
    }
    
public:
    bool btreeGameWinningMove(TreeNode* root, int n, int x) {
        int l = 0, r = 0, p = 0;
        help(root, x, l, r);
        p = n - 1 - l - r;
        return max(p, max(l, r)) > n / 2;
    }
};