let arrr: string[] = [];
let arrr2: Array<string> = [];
function rest(a, ...args: string[]) {
  console.log(a, args);
}

rest("1", "2", "3");

const tuple: [string, number] = ["1", 1];
// tuple[2] = 'hello'  에러

tuple.push("hello"); // 에러이지만 typescript에서 감지 못함
