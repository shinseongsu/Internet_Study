function solution(arr) {
    // #1. 배열 메서드
    //   return arr.reduce((result, str) => {
    //     if (!result.includes(str)) {
    //       result.push(str);
    //     }
    //     return result;
    //   }, []);

    // #2. Set
    // let set = new Set();
    // arr.forEach((str) => {
    //     set.add(str);
    // });
    // const result = [];
    // set.forEach((s) => result.push(s));
    // return result;

    let answer;
    answer = arr.filter((v, i) => {
        // console.log(v, i);
        if (arr.indexOf(v) === i) return v;
    });
    return answer;
}

console.log(solution(['good', 'time', 'good', 'time', 'student']));