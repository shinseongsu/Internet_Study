function solution(a, b, c) {
    let min;
    min = a < b ? a : b;
    min = min < c ? min : c;
    return min;
}

console.log(solution(6, 5, 11));

// 결과 : 5