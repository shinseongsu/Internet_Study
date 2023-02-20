// const head: Element = document.querySelector('#head');
// console.log(head);

const head = document.querySelector("#head");
if (head) {
  head.innerHTML = "hello world";
  console.log(head);
}

// 절대 이렇게 쓰지말것
const body = document.querySelector("body")!;
body.innerHTML = "hello";
