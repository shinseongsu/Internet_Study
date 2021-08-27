function solution(a, b, c) {
    let tot = a + b + c;
    let max = a > b ? a : b;
    max = max > c ? max : c;
    let max_21lines = tot - max;
    return max_21lines > max ? 'YES' : 'NO';
}

console.log(solution(6, 7, 11));
console.log(solution(13, 33, 17));

// 실행 결과
// YES
// NO