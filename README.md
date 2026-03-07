```text
0308 2주차 : h2DB 활용해 프로젝트 구조 잡고 간단하게 더미 데이터 insert 
src/main/java/com/board/demo
 ┣  controller  # HTTP 요청/응답을 처리하는 웹 계층 (API 엔드포인트)
 ┣  service     # 핵심 비즈니스 로직 및 트랜잭션 처리 계층
 ┣  repository  # 데이터베이스에 접근하여 CRUD 쿼리를 수행하는 영속성 계층
 ┣  domain      # DB 테이블과 1:1로 매핑되는 Entity 클래스 모음
 ┣  dto         # 계층 간 데이터 교환을 위한 택배 상자 (Data Transfer Object)
 ┗  BoardApplication.java # 스프링 부트 애플리케이션 실행의 시작점
데이터 흐름
클라이언트(브라우저) ➡️ Controller ➡️ DTO ➡️ Service ➡️ Domain(Entity) ➡️ Repository ➡️ DB
Controller: 밖에서 들어오는 API 요청을 받는다.
DTO: 그 요청의 데이터를 담는다.
Service: 데이터를 검사하고 가공하는 작업을 한다. (로직)
Domain: DB에 들어갈 진짜 모습(규격)이다.
Repository: 그걸 받아서 진짜 DB에 저장한다. (쿼리 실행)
```