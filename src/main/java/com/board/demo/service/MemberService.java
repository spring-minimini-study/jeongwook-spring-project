package com.board.demo.service;

import com.board.demo.domain.Member;
import com.board.demo.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor

public class MemberService {

    private final MemberRepository memberRepository;

    public Long join(String loginId, String password, String name) {
        memberRepository.findByLoginId(loginId)
                .ifPresent(m -> { throw new IllegalStateException("이미 존재하는 아이디입니다."); });

        Member member = Member.builder()
                .loginId(loginId)
                .password(password) // 그냥 password 주입
                .name(name)
                .build();

        return memberRepository.save(member).getId();
    }

    //조회
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }
}
