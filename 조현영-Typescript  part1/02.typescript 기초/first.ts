const a: string = "5";
const b: number = 5;
const c: boolean = true;
const d: undefined = undefined;
const e: null = null;

function add(x: number, y: number): number {
  return x + y;
}

type Add = (x: number, y: number) => number;
const add2: Add = (x, y) => x + y;

interface Add2 {
  (x: number, y: number): number;
}
const add3: Add2 = (x, y) => x + y;

const f: true = true;

const arr: string[] = ["123", "456"];
const arr2: Array<number> = [123, 456];
const arr3: [number, number, string] = [123, 456, "hello"];
// const obj = ({ lat: number, lon: number } = { lat: 37.5, lon: 127.5 });
