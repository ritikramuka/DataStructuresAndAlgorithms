func abs(a int) int {
    if a < 0 {
        return -a
    } else {
        return a
    }
}

func threeSumClosest(nums []int, target int) int {
    n := len(nums)
    sort.Ints(nums)
    
    si := 0
    ans := (1<<32) - 1
    for si < n - 2 {
        ei := n - 1
        i := si + 1
        for i < ei {
            sum := nums[si] + nums[ei] + nums[i]
            if abs(target - sum) < abs(target - ans) {
                ans = sum
            }
            if sum > target {
                ei--;
            } else if sum < target {
                i++;
            } else {
                return target
            }
        }
        si++
    }
    
    return ans
}