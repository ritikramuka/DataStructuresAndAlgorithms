/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */

func addOneRow(root *TreeNode, val int, depth int) *TreeNode {
    if depth == 1 {
        return &TreeNode{val, root, nil}
    }
    
    if depth == 2 {
        root.Left  = &TreeNode{val, root.Left, nil}
        root.Right = &TreeNode{val, nil, root.Right}
    }
    
    if root.Left != nil {
        addOneRow(root.Left, val, depth - 1)
    }
    
    if root.Right != nil {
        addOneRow(root.Right, val, depth - 1)
    }
    
    return root
}