# Spring Board Security Enhancement

**Spring MVC 게시판 보안 강화 프로젝트**

[English](#english) | [한국어](#한국어)

## English

### Project overview

A Java web bulletin board coursework project that extends an existing Spring MVC board with security-related code. This repository preserves the source submitted in the project ZIP for portfolio review.

The application includes account registration, login/logout, post creation and viewing, editing/deletion, search, pagination, and view counting. It follows Controller → Service → DAO → MyBatis → MariaDB, with JSP pages for the interface.

### Technology

Java 8 source/target, Maven, Spring MVC 5.2.5, Spring Security 5.3.3, MyBatis 3.4.6, MariaDB JDBC 3.3.3, JSP/JSTL, and WAR packaging.

### Security work visible in the source

- BCrypt password encoding and password matching calls.
- Session-based user identification and author checks on selected board routes.
- Additional login-attempt and account-lock fields and service logic.
- A Java security configuration outlining CSRF protection, authenticated routes, and form login.
- CSRF token fields in the post creation and editing forms.

These describe code present in the submission. End-to-end protection has not been verified.

### Local setup and execution workflow

1. Prepare a JDK matching the Java 8 target, Maven, MariaDB, and a Tomcat 9 installation.
2. Create a local database. Review the MyBatis mapper files in `src/main/resources/mappers/` and prepare matching tables. The original schema notes are retained in [docs/README.original.md](docs/README.original.md); they need reconciliation with the current mapper column names and `board_views` queries.
3. Set local database details in `src/main/resources/database.properties`. The uploaded file contains placeholders only; replace `CHANGE_ME` locally. Keep credentials out of Git commits.
4. Address the integration gaps listed below, then build from the repository root:

   ```shell
   mvn clean package
   ```

5. After a successful build, deploy `target/sample.war` to Tomcat's `webapps` directory and start Tomcat. With the default port and WAR context name, open `http://localhost:8080/sample/`.
6. Check registration, login/logout, listing/search/pagination, and author-specific post operations.

### Current verification status

This upload is a coursework source snapshot. It has not been built or launched during upload. Source inspection identified unfinished integration: the login lookup does not reference a defined named mapper statement, and the `member.update` mapper statement is missing; password encoding appears in both confirmation and signup; and the security configuration is not connected to a security filter in `web.xml`. The database schema and login-failure counting also need review before describing the application as fully operational.

### Repository preparation

Source code is retained as submitted, except that database connection credentials were replaced with local placeholders. Generated files and IDE metadata are excluded. The original project notes remain available for context. No authorship or license is inferred for the existing board implementation.

## 한국어

### 프로젝트 소개

기존 Spring MVC 게시판에 보안 관련 코드를 추가한 Java 웹 게시판 학습 프로젝트입니다. 포트폴리오 검토를 위해 제출 ZIP에 포함된 소스 코드를 보존했습니다.

회원가입, 로그인/로그아웃, 게시글 작성·조회·수정·삭제, 검색, 페이징, 조회수 기능을 포함합니다. Controller → Service → DAO → MyBatis → MariaDB 구조를 사용하며, 화면은 JSP로 구성되어 있습니다.

### 사용 기술

Java 8 소스/타깃, Maven, Spring MVC 5.2.5, Spring Security 5.3.3, MyBatis 3.4.6, MariaDB JDBC 3.3.3, JSP/JSTL, WAR 패키징.

### 소스 코드에서 확인되는 보안 관련 작업

- BCrypt를 이용한 비밀번호 해시 생성 및 검증 호출.
- 세션 기반 사용자 식별 및 일부 게시판 경로의 작성자 확인.
- 로그인 시도 횟수와 계정 잠금 상태를 위한 필드 및 서비스 로직 추가.
- CSRF 보호, 인증이 필요한 경로, 폼 로그인을 설정하는 Java 보안 설정 코드.
- 게시글 작성·수정 폼의 CSRF 토큰 필드 추가.

위 항목은 제출 코드에 포함된 내용을 설명합니다. 실제 요청 흐름에서 보안 기능이 정상 작동하는지는 아직 검증하지 않았습니다.

### 로컬 환경 구성 및 실행 절차

1. Java 8 타깃에 맞는 JDK, Maven, MariaDB, Tomcat 9를 준비합니다.
2. 로컬 데이터베이스를 생성하고 `src/main/resources/mappers/`의 쿼리에 맞는 테이블을 구성합니다. 기존 스키마 설명은 [docs/README.original.md](docs/README.original.md)에 보존되어 있으며, 현재 매퍼의 컬럼명과 `board_views` 쿼리에 맞게 검토해야 합니다.
3. `src/main/resources/database.properties`에 로컬 DB 접속 정보를 설정합니다. 업로드된 파일에는 예시 값만 포함되어 있습니다. `CHANGE_ME`를 로컬 비밀번호로 변경하고 실제 접속 정보는 커밋하지 않습니다.
4. 아래의 연동 문제를 확인한 후 저장소 루트에서 빌드합니다.

   ```shell
   mvn clean package
   ```

5. 빌드에 성공하면 `target/sample.war`를 Tomcat의 `webapps` 폴더에 배포하고 Tomcat을 시작합니다. 기본 포트와 WAR 이름을 사용하면 `http://localhost:8080/sample/`에서 접속할 수 있습니다.
6. 회원가입, 로그인/로그아웃, 목록·검색·페이징, 작성자별 게시글 조작을 확인합니다.

### 현재 검증 상태

이 저장소는 학습 프로젝트의 제출 소스 스냅샷입니다. 업로드 과정에서는 빌드 및 실행을 수행하지 않았습니다. 소스 검토 결과, 로그인 조회가 정의된 매퍼 구문을 참조하지 않으며 `member.update` 매퍼 구문이 누락되어 있고, 비밀번호 해시 처리가 확인 단계와 회원가입 단계에 모두 존재하며, `web.xml`에 보안 필터 연결이 없습니다. 데이터베이스 스키마와 로그인 실패 횟수 처리도 실제 실행 전에 확인해야 합니다.

### 저장소 정리 내용

DB 접속 정보를 로컬 예시 값으로 변경한 것을 제외하고 제출 소스 코드를 유지했습니다. 빌드 결과물과 IDE 설정 파일은 제외했으며, 기존 프로젝트 설명도 보존했습니다. 기존 게시판 구현의 저작자나 라이선스는 임의로 추정하지 않았습니다.

