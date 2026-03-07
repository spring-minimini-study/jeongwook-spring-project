package com.board.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BoardApplication {

	public static void main(String[] args) {
		SpringApplication.run(BoardApplication.class, args);
	}

}
/*
domain: DB 테이블과 매핑되는 Entity 클래스들 (Board, Member)
repository: DB에 접근하는 JpaRepository 인터페이스들
service: 핵심 비즈니스 로직 (트랜잭션 관리)
controller: HTTP 요청을 받는 컨트롤러들
dto: 계층 간 데이터 전송을 위한 Data Transfer Object (회원가입 요청 양식 등)
config: 보안(Security)이나 기타 설정 클래스


 */