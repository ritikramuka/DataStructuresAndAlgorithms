class Solution {
    public void rec(int[] nums, int idx, int prev, List<Integer> list, HashSet<List<Integer>> ans) {
        if (idx == nums.length) {
            if (list.size() > 1) {
                ans.add(new ArrayList(list));
            }
            return;
        }

        if (nums[idx] >= prev) {
            list.add(nums[idx]);
            rec (nums, idx + 1, nums[idx], list, ans);
            list.remove(list.size() - 1);
        }
        
        rec (nums, idx + 1, prev, list, ans);

        return;
    }
    
    public List<List<Integer>> findSubsequences(int[] nums) {
        HashSet<List<Integer>> ans = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        
        rec(nums, 0, Integer.MIN_VALUE, list, ans);

        List<List<Integer>> ansList = new ArrayList<>();
        for (var a : ans) {
            ansList.add(a);
        }
        return ansList;
    }
}