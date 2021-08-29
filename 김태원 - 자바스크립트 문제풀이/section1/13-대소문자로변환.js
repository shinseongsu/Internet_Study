function solution(arg) {
    let answer = '';
    for (let x of arg) {
        if (x === x.toUpperCase()) answer += x.toLowerCase();
        else answer += x.toUpperCase();
    }
    return answer;
}

console.log(solution('StuDY'));