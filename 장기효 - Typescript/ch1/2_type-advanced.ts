// Enum
enum Avengers {
  Capt,
  Ironman,
  Hulk,
}
const myHero = Avengers.Capt;

// any
let a: any = 'h1';
a = 20;
a = false;

// void
function sayHi(): void {
  //  return 'a';
}

let str = '이건 문자열 타입이 된다.';

let num: number;
num = 'str' as any;

const divElement = document.querySelector('#app');
divElement.innerHTML;
