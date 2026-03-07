package com.board.demo.repository;

import com.board.demo.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    // 로그인 ID로 회원을 찾는 기능
    Optional<Member> findByLoginId(String loginId);
}