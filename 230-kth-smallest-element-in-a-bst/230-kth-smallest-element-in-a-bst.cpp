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
    int kthSmallest(TreeNode* root, int k) {
        int ans = 0;
        inrec(root, k, ans);
        return ans;
    }
    
    void inrec(TreeNode* root, int& k, int& ans) {
        if(!root)
            return;
        
        inrec(root->left, k, ans);
        k--;
        if(k == 0) {
            ans = root->val;
            return;
        }
        inrec(root->right, k, ans);
        return;
    }
};