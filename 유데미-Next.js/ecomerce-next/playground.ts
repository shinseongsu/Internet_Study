// TS recommend to use Interface over Types when possible

//
interface Person {
  name: string;
  age: number;
}

// interface PersonLoggerFn {
//   logPersonInfo(name: string, age: number): string;
// }

type PersonLoggerFn = (name: string, age: number) => string;

// type Person = {
//   name: string;
//   age: number;
// };

type Data = string;

export default function play() {
  const name: Data = "Filip";
  const age: number = 30;

  const person: Person = {
    name: "John",
    age: 34,
  };

  const logPersonInfo: PersonLoggerFn = (
    personName: string,
    personAge: number
  ): string => {
    //const info = "Name: " + personName + ", age: " + personAge;
    const info = `Name: ${personName}, ${personAge}`;
    console.log(info);
    return info;
  };

  function logPersonInfo2(person: Person) {
    //const info = "Name: " + personName + ", age: " + personAge;
    const info = `Name: ${person.name}, ${person.age}`;
    console.log(info);
    return info;
  }

  const log = logPersonInfo(name, age);
  logPersonInfo2(person);
}
