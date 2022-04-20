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
class BSTIterator {
public:
    stack<TreeNode*>st;
    BSTIterator(TreeNode* root) {
        all_left_of_right(root);
    }
    
    void all_left_of_right(TreeNode* root)
    {
        while(root)
        {
            st.push(root);
            root=root->left;
        }
    }
    
    /** @return the next smallest number */
    int next() {
        TreeNode* rn=st.top(); st.pop();
        all_left_of_right(rn->right);
        return rn->val;
    }
    
    /** @return whether we have a next smallest number */
    bool hasNext() {
        return st.size()!=0;
    }
};

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator* obj = new BSTIterator(root);
 * int param_1 = obj->next();
 * bool param_2 = obj->hasNext();
 */