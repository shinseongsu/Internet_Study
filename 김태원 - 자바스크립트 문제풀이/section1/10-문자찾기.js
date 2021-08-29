function solution(sentence, str) {

    // ES6
    // const strings = sentence.split('') || [];
    // return strings.filter((s) => s === str).length;

    answer = sentence.split(str).length - 1;
    return answer;
    
}

console.log(solution('COMPUTERPROGRAMMING', 'R'));