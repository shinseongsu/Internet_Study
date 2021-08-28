function solution(str) {
    let answer = '';
    for(const s of str) {
        answer += s === 'A' ? '#' : s;
    }
    return answer;
}

console.log(solution('BANANA'));

// 실행결과
// B#N#N#