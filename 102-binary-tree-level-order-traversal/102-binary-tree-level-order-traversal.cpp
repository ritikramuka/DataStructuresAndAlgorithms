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
    vector<vector<int>> levelOrder(TreeNode* root) {
        if(root == nullptr) return {};
        vector<vector<int>> lo;
        queue<TreeNode*> que;
        que.push(root);
        while(que.size() != 0) {
            int size = que.size();
            vector<int> currLevel;
            while(size-->0) {
                TreeNode* rnode = que.front();
                que.pop();
                currLevel.push_back(rnode->val);
                if(rnode->left != nullptr) {
                    que.push(rnode->left);
                }
                if(rnode->right != nullptr) {
                    que.push(rnode->right);
                }
            }
            lo.push_back(currLevel);
        }
        return lo;
    }
};