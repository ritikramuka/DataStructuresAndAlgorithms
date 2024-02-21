function minDays(bloomDay: number[], m: number, k: number): number {
    if (m * k > bloomDay.length) {
        return -1;
    }

    let lo: number = Math.min(...bloomDay);
    let hi: number = Math.max(...bloomDay);
    let pans: number = -1;
    
    const isPossible = (maxDays: number): boolean => {
        let numberOfBouquets: number = 0;
        let numbeOfFlowers: number = 0;

        bloomDay.forEach((bloom) => {
            if (bloom > maxDays) {
                numbeOfFlowers = 0;
            } else {
                numbeOfFlowers += 1;
            }

            if (numbeOfFlowers == k) {
                numberOfBouquets += 1;
                numbeOfFlowers = 0;
            }
        });

        return numberOfBouquets >= m;
    }
    
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