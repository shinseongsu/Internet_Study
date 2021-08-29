function solution(arg) {

    // ES 6
    // const arr = [];
    // arg.split('').reduce((result, str) => {
    //     const code = str.charCodeAt();
    //     arr.push(code >= 97 ? code - 32 : code + 32);
    // }, '');
    // return arr.map((num) => String.fromCharCode(num)).join('');

    let answer = '';
    for (let x of arg) {
        if (x === x.toUpperCase()) answer += x.toLowerCase();
        else answer += x.toUpperCase();
    }
    return answer;
}

console.log(solution('StuDY'));