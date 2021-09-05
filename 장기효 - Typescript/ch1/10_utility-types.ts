interface Product {
  id: number;
  name: string;
  price: number;
  brand: string;
  stock: number;
}

let products: Product[] = [
  { id: 1, name: '참치김밥', price: 3000, brand: '김가네', stock: 3 },
];

function displayProduct(productInfo: { id: 1; name: '참치김밥'; price: 3000 }) {
  // ...
}

// #1 - Partial
type Subset<T> = {
  [K in keyof T]?: T[K];
};

// #2 - Pick
type PickFewThings<T, K extends keyof T> = {
  [P in K]: T[P];
};
