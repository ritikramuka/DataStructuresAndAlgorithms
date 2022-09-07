/**
 *Definition for a binary tree node.
 *struct TreeNode {
 *    int val;
 *    TreeNode * left;
 *    TreeNode * right;
 *    TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *    TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 *};
 */
class Solution {
public:
    string ans = "";
    string tree2str(TreeNode *t) {
        if (!t)
            return "";

        ans += to_string(t->val);

        if (t->left) {
            ans += '(';
            ans = tree2str(t->left);
            ans += ')';
        }
        else if (t->right) {
            ans += '(';
            ans += ')';
        }

        if (t->right) {
            ans += '(';
            ans = tree2str(t->right);
            ans += ')';
        }

        return ans;
    }
};