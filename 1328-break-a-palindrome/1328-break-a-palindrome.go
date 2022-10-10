func breakPalindrome(palindrome string) string {
    str := []rune(palindrome)
    
    if len(str) == 1 {
        return ""
    }
    
    firstIndexOfNonA := -1
    for index, ch := range(str) {
        if ch != 'a' {
            firstIndexOfNonA = index
            break;
        }
    }
    
    if (len(str) % 2 == 1 && firstIndexOfNonA == len(str) / 2) || firstIndexOfNonA == -1 {
        str[len(str) - 1] = 'b'
    } else {
        str[firstIndexOfNonA] = 'a'
    }
    
    return string(str)
}