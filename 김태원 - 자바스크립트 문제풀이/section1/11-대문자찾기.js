function solution(arg) {
    let answer = 0;
    for(let x of arg) {
        if (x === x.toUpperCase()) answer++;
    }
    return answer;
}

console.log(solution('KoreaTimeGood'));