# Foody 쇼핑몰
> Foody 쇼핑몰

식품 쇼핑몰을 만들었다. 기본적으로 회원가입, 로그인, 검색, 게시판 기능을 구현했다. 

<img width='80%' src="https://user-images.githubusercontent.com/95485737/226220475-20763920-9608-4da5-8205-80e53de26144.png"/>

## 설치 방법

윈도우:
H2 Database 설치 후 H2 console로 접속
https://www.h2database.com/html/main.html

H2DB TCP 모드로 서버 접속
저장한 설정 : Generic H2 (Server)
JDBC URL : jdbc:h2:tcp://localhost/~/test_foody

## 사용 예제

회원가입을 하고 로그인을 할 수 있다. 
<img width='90%' src="https://user-images.githubusercontent.com/95485737/226224593-3d8b6680-cce6-46e9-918d-5e715974c398.png"/>
<img width='90%' src="https://user-images.githubusercontent.com/95485737/226224614-8d3ca50b-1c03-4208-a14a-cd089feaf62b.png"/>

식품의 품목 별로 분류하고 검색할 수 있다.
<img width='90%' src="https://user-images.githubusercontent.com/95485737/226224629-2d6b3f3b-205a-4b5a-a35c-432c015aa59d.png"/>
<img width='90%' src="(https://user-images.githubusercontent.com/95485737/226224650-ba54cee8-a5c2-4b1f-8e32-0488aeff28de.png"/>

관리자 권한의 사용자만 공지사항을 작성할 수 있고, 일반 사용자는 문의글을 작성할 수 있다.
<img width='90%' src="https://user-images.githubusercontent.com/95485737/226224701-913c013d-60fe-488b-bd5d-51c9d347f870.png"/>
<img width='90%' src="https://user-images.githubusercontent.com/95485737/226224787-f2b1af8c-9054-4b32-aed8-9bef31e4c7e9.png"/>

## 개발 환경 설정

프론트: 
백엔드: Spring boot

```sh
make install
npm test
```

<!-- Markdown link & img dfn's -->
[npm-image]: https://img.shields.io/npm/v/datadog-metrics.svg?style=flat-square
[npm-url]: https://npmjs.org/package/datadog-metrics
[npm-downloads]: https://img.shields.io/npm/dm/datadog-metrics.svg?style=flat-square
[travis-image]: https://img.shields.io/travis/dbader/node-datadog-metrics/master.svg?style=flat-square
[travis-url]: https://travis-ci.org/dbader/node-datadog-metrics
[wiki]: https://github.com/yourname/yourproject/wiki
