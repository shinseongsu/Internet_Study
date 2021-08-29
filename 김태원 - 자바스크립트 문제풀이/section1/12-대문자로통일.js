function solution(arg) {

    let answer = '';
    for (let x of arg) {
        let num = x.charCodeAt();
        if(num >= 97 && num <= 122) {
            answer += String.fromCharCode(num - 32);
        } else {
            answer += x;
        }
    }
    return answer;
}

console.log(solution('ItisTimeToStudy'));