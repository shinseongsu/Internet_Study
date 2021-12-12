// var global = "전역";

// if (global == "전역") {
//   var global = "지역 변수";

//   console.log(global);
// }

// console.log(global);

// var 는 함수단위 스코프 입니다.

let global = "전역";

// if (global == "전역") {
//   let global = "지역 변수";

//   console.log(global);
// }

{
  let global = "지역 변수";

  console.log(global);
}

console.log(global);

// let 보다는 const를 지향합니다.

const person = {
  name: "jang",
  age: "30",
};

person.name = "seongsu";
