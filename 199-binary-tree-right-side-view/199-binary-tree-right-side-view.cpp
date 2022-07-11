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
    vector<int> rightSideView(TreeNode* root) {
        if(root == nullptr) return {};
        vector<int> rv;
        queue<TreeNode*> que;
        que.push(root);
        while(que.size() != 0) {
            rv.push_back(que.front()->val);
            int size = que.size();
            while(size-->0) {
                TreeNode* rnode = que.front(); 
                que.pop();
                if(rnode->right != nullptr) {
                    que.push(rnode->right);
                }
                if(rnode->left != nullptr) {
                    que.push(rnode->left);
                }
            }
        }
        return rv;
    }
};