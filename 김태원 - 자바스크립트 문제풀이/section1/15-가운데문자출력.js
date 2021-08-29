function solution(str) {
    const length = str.length;
    let mid = Math.floor(length / 2); // Number.parseInt(...) 메서드를 사용해도 된다.

    if (str.length % 2 === 1) answer = str.substring(mid, mid + 1);
    else answer = str.substring(mid - 1, mid + 1);
    
    return answer;
}

console.log(solution('study'));
console.log(solution('good'));