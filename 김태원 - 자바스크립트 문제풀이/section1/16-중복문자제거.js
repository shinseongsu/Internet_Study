function solution(str) {

    // 배열 내장 메서드
    // return str
    //     .split('')
    //     .reduce((result, s) => {
    //         if (!result.includes(s)) result.push(s);
    //         return result;
    //     }, [])
    //     .join('');

    // Set 사용
    // const set = new Set();
    // str.split('').forEach((str) => set.add(str));
    // const result = [];
    // for (const value of set) {
    //     result.push(value);
    // }
    // return result.join('');

    let answer = '';
    for(let i = 0 ; i < str.length; i++) {
        if(str.indexOf(str[i] === i)) answer += str[i];
    }
    return answer;

}

console.log(solution('ksekkset'));