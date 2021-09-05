// 자바스크립트 함수 선언
function sum(a, b) {
  return a + b;
}

// 타입스크립트 함수 - 선언
function add(a: number, b: number) {
  return a + b;
}

// 타입스크립트 함수 선언 - 함수의 반환 타입
function add2(a: number, b: number) {
  return a + b;
}

function log(a: string) {
  console.log(a);
}

function printText(text: string, type?: string) {
  console.log(text);
}
printText('hi');
