function minimumSize(nums: number[], maxOperations: number): number {
    let lo: number = 0;
    let hi: number = Math.max(...nums);
    let pans: number = -1;
    
    let isPossible = (pen: number): boolean => {
        let currOpt: number = 0;
        nums.forEach((num) => {
            let divide: number = Math.floor((num - 1) / pen);
            currOpt += divide; 
        });
        
        return currOpt <= maxOperations;  
    };
    
    while (lo <= hi) {
        let mid: number = Math.floor((lo + hi) / 2);
        if (isPossible(mid) == true) {
            pans = mid;
            hi = mid - 1;
        } else {
            lo = mid + 1;
        }
    }
    
    return pans;
};