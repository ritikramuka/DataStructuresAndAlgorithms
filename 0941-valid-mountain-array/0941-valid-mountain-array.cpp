class Solution {
public:
    bool validMountainArray(vector<int>& arr) {
        int i = 0;
        while (i + 1 < arr.size() && arr[i] < arr[i + 1]) {
            i++;
        }
        int j = arr.size() - 1;
        while (j - 1 >= 0 && arr[j] < arr[j - 1]) {
            j--;
        }
        
        if(i == 0) return false;
        
        if(j == arr.size() - 1) return false;
        
        return i == j;
    }
};