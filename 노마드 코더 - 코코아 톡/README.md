# 노마드 코더 코코아톡

## Status Bar CSS

### 가상 선택자

- `element:first-child` : 형제 요소 중 첫번째 요소
- `element:last-child` : 형제 요소 중 마지막 요소
- `element:nth-child` : 형제 사이에서의 순서에 따라 요소를 선택

### CSS hack

No Service 부분이 다른 요소들 보다 상대적으로 크기 때문에 요소의 전체적인 정렬이 흐트러져 있다.

```CSS
.status-bar {
  justify-content: center;
}

.status-bar__column {
  width: 33%;
}

.status-bar__column:nth-child(2) {
  display: flex;
  justify-content: center;
}

.status-bar__column:last-child {
  display: flex;
  justify-content: flex-end;
}
```

각각의 요소에 `width: 33%;` 를 주고 flex를 이용해서 텍스트를 정렬시킨다.(`justify-content`)

---

## Sign Up Screen

- 클래스 이름을 명확하게 지을 것 (부모 요소가 status-bar 라면 status-bar\_\_column 이런식)
- CSS 를 컴포넌트화 해서 쪼개고. style.css 파일에 `@import` 해준다.

### reset.css

기본적인 UserAgent CSS 스타일을 없애버린다.

---

## Log In Form

- `input:focus {outline: none;}` : input 요소가 포커싱 상태일 때 아웃라인 제거하기
- `element:not([type="submit])` : () 안의 요소가 아닌 곳에 속성 적용
- `autocomplete 속성` : input 요소 자동완성 해제

---

## Recap and Forms

조금 더 파일을 구성하고 싶다면 컴포넌트와 화면에 쓰이는 CSS 코드를 폴더로 분리(UI 요소도 마찬가지)

styles.css 에는 모든 화면에 적용될 수 있는 스타일을 써놓자 (font 같은거) (취향)

form method="GET" : 서버로 보내는 정보가 URL에 노출됨 (보안에 취약함)

form method="POST" : 백엔드 서버로 데이터를 보내는 방식 (정보가 노출되지 않음)

## Navigation Bar

네비게이션 바 하단 고정

```CSS
.nav {
  position: fixed;
  bottom: 0;
  width: 100%;
  box-sizing: border-box;
}
```

---

## Chats Screen

같은 디자인을 재사용하자 (코드의 재사용성을 높입시다.)

## Find Screen

- divider (vertical bar) 만들기

```CSS
.open-post__members .divider {
  width: 2px;
  height: 15px;
  margin: 0px 5px;
  background-color: rgba(0, 0, 0, 0.2);
}
```

## Settings Screen

flex 박스를 쓰지 않아도 margin auto 를 잘사용하면 잘 정렬할 수 있다.

```CSS
.alt-header__column:first-child {
  margin-right: auto;
}

.alt-header__column:last-child {
  margin-left: auto;
}
```

---

## Splash Screen

- 애니메이션 만들기

```CSS
@keyframes 애니메이션이름 {
  from {

  }
  to {

  }
}
```

- `animation` 속성 `forwards` 값: 애니메이션의 마지막 속성값을 유지

- `animation-delay` : `animation-delay` 속성의 값만큼 대기했다가 애니메이션을 실행한다.

---

## More Animations

- `will-change` 속성 : 그래픽 카드를 이용해서 애니메이션을 가속화한다. (애니메이션이 좀 더 부드럽게 동작할 수 있도록 브라우저에게 예고한다고 볼 수 있음)

```CSS
.btn {
  will-change : transform;
}
```

---

## No Mobile Media Query

미디어쿼리

```CSS
@media screen and (조건) {
  h1 {
    font-size: 15px;
  }
}
```
