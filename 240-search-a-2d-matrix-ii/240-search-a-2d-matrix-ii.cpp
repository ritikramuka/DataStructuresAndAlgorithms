class Solution {
public:
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        int n = matrix.size();
        int m = matrix[0].size();
        int i = 0, j = m - 1;
        while(i < n && j >= 0) {
            int ele = matrix[i][j];
            if(target > ele) {
                i++;
            } else if (ele == target) {
                return true;
            } else {
                j--;
            }
        }
        
        return false;
    }
};