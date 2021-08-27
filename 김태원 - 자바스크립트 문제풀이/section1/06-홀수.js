function solution(arr) {
    let oddSum = 0;
    let oddMin = Number.MAX_SAFE_INTEGER;

    for(let n of arr) {
        if(n % 2 == 1) {
            oddSum += n;
            if(oddMin > n) oddMin = n;
        }
    }
    console.log(oddSum);
    console.log(oddMin);
}

solution([12, 77, 38, 41, 53, 92, 85]);

// 실행 결과
// 256
// 41
