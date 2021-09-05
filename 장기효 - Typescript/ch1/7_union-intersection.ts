function logMessage1(value: string) {
  console.log(value);
}
function logMessage2(value: number) {
  console.log(value);
}
function logMessage3(value: any) {
  console.log(value);
}

// Union 문법

function logMessage4(value: string | number) {
  console.log(value);
}

function logMessage(value: string | number) {
  if (typeof value === 'string') {
    value.toLocaleUpperCase();
  }
  if (typeof value === 'number') {
    value.toLocaleString();
  }
  throw new TypeError('value must be string or number');
}

// # Intersection 타입 문법
interface Developer {
  name: string;
  skill: string;
}

interface Person {
  name: string;
  age: number;
}

function askSomeone(someone: Developer | Person) {
  someone.name; // O
  someone.age; // X
}
