# SAMPLE-BOARD
RESTful API를 이용하여 간단한 CRUD의 기능을 구현한 게시판입니다.



## 패키지 설명
- com.example.app.controller      Client의 요청을 받아 RequestMapping을 실행하여 Service를 호출하고 응답을 전달합니다.

- com.example.app.entity          DB에서 데이터를 얻어 게시판에 대한 Service와 Controller로 보낼 때 사용합니다.

- com.example.app.repository      DB에 접근할 수 있도록 게시판에 대한 Service와 DB의 연결고리 역할을 합니다.

- com.example.app.service         Client가 요청한 CRUD작업을 처리합니다.

## 개발환경
### 개발정보
- 1.0.11 RELEASE <br>
- java 1.8 버전
- Spring-boot 2.4.4
- Gradle 5.6.2
- Apache Tomcat v9.0 Server
- mysqlDB


