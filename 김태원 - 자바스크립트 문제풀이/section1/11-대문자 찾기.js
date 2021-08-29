function solution(arg) {
    // ES6
    // const sentence = arg.split('');
    // return sentence.filter((str) => str >= 'A' && str <= 'Z');

    let answer = 0;
    for (let x of arg) {
        if (x === x.toUpperCase()) answer++;
    }
    return answer;
}

console.log(solution('KoreaTimeGood'));