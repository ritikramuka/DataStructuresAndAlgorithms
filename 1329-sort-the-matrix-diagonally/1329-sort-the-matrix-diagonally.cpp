class Solution {
public:
    vector<vector<int>> diagonalSort(vector<vector<int>>& mat) {
        int n = mat.size();
        int m = mat[0].size();
        
        unordered_map<int, priority_queue<int>> umap;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                umap[i - j].push(mat[i][j]);
            }
        }
        
        for(int i = n - 1; i >= 0; i--) {
            for(int j = m - 1; j >= 0; j--) {
                mat[i][j] = umap[i - j].top();
                umap[i - j].pop();
            }
        }
        
        return mat;
    }
};