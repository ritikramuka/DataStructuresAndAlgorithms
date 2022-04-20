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
    TreeNode* a=nullptr;
    TreeNode* b=nullptr;
    TreeNode* c=nullptr; //c->prev
    bool recoverTree_(TreeNode* root) {
        if(!root)
            return false;
        if(recoverTree_(root->left))
            return true;
        if(c!=nullptr && c->val>root->val) {
            b=root; //to get post of second changed val
            if(a==nullptr)
                a=c;
            else
                return true;
        }
        c=root;
        if(recoverTree_(root->right))
            return true;
        return false;
    }
    void recoverTree(TreeNode* root) {
        recoverTree_(root);
        if (a != nullptr)
        {
            int temp = a->val;
            a->val = b->val;
            b->val = temp;
        }
    }
};
auto SpeedUp = []() {
    std::ios::sync_with_stdio(false);
    std::cin.tie(nullptr);
    std::cout.tie(nullptr);
    return nullptr;
}();