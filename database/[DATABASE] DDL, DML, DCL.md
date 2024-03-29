# DDL(Data definition Language) - 데이터 정의어

데이터 베이스를 정의하는 언어를 의미. 데이터를 생성하거나 수정, 삭제 등 데이터의 전체 골격을 결정 하는 언어

<br>

- CREATE
  - 데이터 베이스, 테이블 등을 생성
- ALTER
  - 테이블 수정
- DROP
  - 데이터베이스, 테이블 삭제
- TRUNCATE
  - 테이블 초기화

<br><br>

# DML(Data Manipulation Language) - 데이터 조작어

정의된 데이터베이스에 입력된 레코드 조회 혹은 수정, 삭제 하는 언어. 
테이블에 있는 행과 열을 조작하는 언어. 
사용자가 던지는 실질적인 질의 이다.

<br>

- SELECT
  - 데이터 조회
- INSERT
  - 데이터 삽입
- UPDATE
  - 데이터 수정
- DELETE
  - 데이터 삭제

<br><br>

# DCL(Data Control Language) - 데이터 제의어

데이터 베이스에 접근하거나 객체에 권한을 주는 등의 언어.
데이터 제어 언어.
데이터의 보안, 무결성, 회복 등을 정의하는데 사용.

<br>

- GRANT
  - 특정 데이터베이스 사용자에게 특정 작업 수행권한 부여
- REVOKE
  - 특정 데이터베이스 사용자에게 특정 작업 권한 박탈, 회수
- COMMIT
  - 트랜잭션의 작업이 정상적으로 완료되었음을 암시
- ROLLBACK
  - 트랜잭션 작업이 비정상적으로 종료 되었을때 트랜잭션 작업 전으로 복구

<br><br>

# 정리

- DDL: DB와 테이블 생성, 변경, 제거
- DML: 테이블 내에 있는 레코드 조회, 입력, 변경, 수정
- DCL: DB사용 권한 및 데이터 무결성 확인
