/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */

func dfs(root *TreeNode, arr *[]int) {
    if root == nil {
        return
    }
    
    dfs(root.Left, arr)
    *arr = append(*arr, root.Val)
    dfs(root.Right, arr)
}

func findTarget(root *TreeNode, k int) bool {
    arr := []int{}
    dfs(root, &arr)
    
    si, ei := 0, len(arr) - 1
    for si < ei {
        sum := arr[si] + arr[ei]
        switch {
            case sum == k: return true
            case sum < k: si++
            case sum > k: ei--
        } 
    }
    
    return false
}