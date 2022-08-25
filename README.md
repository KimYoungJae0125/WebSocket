# 채팅 모듈 만들기

## Sass(Scss)
### node.js가 없을 경우 node.js를 먼저 설치해야한다.
[Mac에서 Node 설치](https://github.com/KimYoungJae0125/Computer-Setting/blob/main/Mac-Setting/Node.js-Setting/Node.js-Setting.md)

### Sass(Scss) 설치

<details>
<summary>Sass가 설치 안 되어 있을경우</summary>

```shell
$ npm install sass
```

</details>

<details>
<summary>Package.json에 dependency가 있을 경우</summary>

```shell
$ npm install
```
- ```package.json```에 있는 ```dependencies```에 정보를 가지고 해당 폴더에 설치

</details>


### Sass(Scss) 사용
#### Scss 컴파일
```$ npm run sass```
#### Scss 파일이 변동이 있을 시 바로 컴파일
```$ npm run sass:watch```
- ```package.json```에 ```scripts```에 써있는 스크립트 실행


## Cypress
### node.js가 없을 경우 node.js를 먼저 설치해야한다.
[Mac에서 Node 설치](https://github.com/KimYoungJae0125/Computer-Setting/blob/main/Mac-Setting/Node.js-Setting/Node.js-Setting.md)

### Cypress 설치

<details>
<summary>Cypress가 설치 안 되어 있을경우</summary>

```shell
$ npm install cypress --save-dev
```

</details>

<details>
<summary>Package.json에 dependency가 있을 경우</summary>

```shell
$ npm install
```
- ```package.json```에 있는 ```dependencies```에 정보를 가지고 해당 폴더에 설치

</details>


### Cypress 실행
```shell
npm run test:cy
```