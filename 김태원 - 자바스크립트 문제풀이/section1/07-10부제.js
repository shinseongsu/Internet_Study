function solution(n, arr) {
    const answer = [];
    for(const car of arr) {
        if (car % 10 === n) {
            answer.push(car);
        }
    }
    return answer.length;
}

console.log(`위반한 차량: ${solution(3, [25, 23, 11, 47, 53, 17, 33])}대`);
console.log(`위반한 차량: ${solution(0, [12, 20, 54, 30, 87, 91, 30])}대`);

/**
 * 실행결과
 *
 * 위반한 차량: 3대
 * 위반한 차량: 3대
 */