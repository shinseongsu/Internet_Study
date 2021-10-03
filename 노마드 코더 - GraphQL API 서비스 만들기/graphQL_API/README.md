## GraphQL 간단한 API 만들기

![graphQL](./resources/graphQL.png)

```
query {
  movies(rating: 8.5, limit: 3) {
    rating,
    title
  }
}
```
