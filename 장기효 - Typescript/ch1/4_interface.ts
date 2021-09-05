// 인터페이스
interface User {
  name: string;
  age: number;
}

// 변수에 사용하는 경우
const seho: User = { name: 'hi', age: 100 };

// 함수의 매개변수에 사용하는 경우
function getUser(user: User) {
  console.log(user);
}
getUser(seho);

// 함수의 전체 타입에 사용하는 경우
interface SumFunction {
  (a: number, b: number): number;
}

// 인터페이스 확장
interface Person {
  name: string;
  age: number;
}

interface Developer extends Person {
  language: string;
}

const joo: Developer = { name: 'joo', age: 20, language: 'ts' };
