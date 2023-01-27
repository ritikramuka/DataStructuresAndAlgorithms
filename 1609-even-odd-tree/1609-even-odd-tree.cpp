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
    bool isEvenOddTree(TreeNode* root) {
        queue<TreeNode*> que;
        que.push(root);
        
        int level = 0;
        while (que.size() != 0) {
            int size = que.size();
            
            int prevEle;
            if (level % 2 == 0) {
                prevEle = INT_MIN;
            } else {
                prevEle = INT_MAX;
            }
            
            while (size-->0) {
                TreeNode* rnode = que.front();
                que.pop();
                
                if (level % 2 == 0) {
                    if (rnode->val % 2 == 0) {
                        return false;
                    }
                    
                    if (rnode->val <= prevEle) {
                        return false;
                    }
                    
                    prevEle = rnode->val;
                } else {
                    if (rnode->val % 2 == 1) {
                        return false;
                    }
                    
                    if (rnode->val >= prevEle) {
                        return false;
                    }
                    
                    prevEle = rnode->val;
                }
                
                if (rnode->left != nullptr) {
                    que.push(rnode->left);
                }
                
                if (rnode->right != nullptr) {
                    que.push(rnode->right);
                }
            }
            
            level++;
        }
        
        return true;
    }
};