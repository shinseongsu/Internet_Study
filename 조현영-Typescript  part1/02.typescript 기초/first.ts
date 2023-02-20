const a: string = "5";
const b: number = 5;
const c: boolean = true;
const d: undefined = undefined;
const e: null = null;

function add(x: number, y: number): number {
  return x + y;
}
const result = add(1, 2);

type Add = (x: number, y: number) => number;
const add2: Add = (x, y) => x + y;

interface Add2 {
  (x: number, y: number): number;
}
const add3: Add2 = (x, y) => x + y;

const f: true = true;

function add4(x: number, y: number): number;
function add4(x, y) {
  return x + y;
}

let aa = 123;
aa = "hello" as unknown as number;

const arr: string[] = ["123", "456"];
const arr2: Array<number> = [123, 456];
const arr3: [number, number, string] = [123, 456, "hello"];
// const obj = { lat: number, lon: number } = { lat: 37.5, lon: 127.5 };

// never
try {
  const array: string[] = [];
  array[0];
} catch (error) {
  error;
}
