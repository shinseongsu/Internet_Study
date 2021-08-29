function solution(arr) {
    // 배열 메서드
    // return arr.reduce((result, str) => {
    //     if(!result.includes(str)) {
    //         result.push(str);
    //     }
    //     return result;
    // }, []);

    // Set
    // let set = new Set();
    // const result = [];
    // arr.forEach((str) => {
    //     set.add(str);
    // });
    // set.forEach((s) => result.push(s));
    // return result;

    let answer;
    answer = arr.filter((v, i) => {
        if(arr.indexOf(v) === i) return v;
    });
    return answer;

}

console.log(solution(['good', 'time', 'good', 'time', 'student']));