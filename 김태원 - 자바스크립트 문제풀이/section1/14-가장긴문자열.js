function solution(arr) {

    // ES6
    // const result = arr
    //     .map((str) => ({ value: str, length: str.length }))
    //     .sort((a, b) => b.length - a.length);
    // return result[0].value;

    let answer,
        max = Number.MIN_SAFE_INTEGER;
    for (let x of arr) {
        if (x.length > max) {
            max = x.length;
            answer = x;
        }
    }
    return answer;
}

let str = ['teacher', 'time', 'student', 'beautiful', 'good'];
console.log(solution(str));