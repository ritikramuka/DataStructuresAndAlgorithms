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
    bool HasOne(TreeNode* root) {
        if(!root)
            return false;
        bool lst = HasOne(root->left);    //leftSubTree
        bool rst = HasOne(root->right);   //rightSubTree
        if(!lst) root->left = nullptr;
        if(!rst) root->right = nullptr;
        return root->val == 1 || lst || rst;
    }
public:
    TreeNode* pruneTree(TreeNode* root) {
        return HasOne(root) ? root : nullptr;
    }
};