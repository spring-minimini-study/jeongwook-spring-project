package com.board.demo.controller;

import com.board.demo.domain.Member;
import com.board.demo.service.MemberService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/members")
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/join")
    public String join(@RequestBody JoinRequest request) {
        memberService.join(request.getLoginId(), request.getPassword(), request.getName());
        return "회원가입 완료!";
    }

    @GetMapping("/test-insert")
    public String testInsert() {
        // 브라우저 접속 시 강제로 데이터를 DB에 밀어넣습니다. 테스트
        memberService.join("testId", "testPassword", "정욱");
        return "브라우저를 통한 DB 저장 성공! H2 메모리에 데이터가 들어갔습니다!";
    }

    @GetMapping("/list")
    public List<Member> list() {
        return memberService.findMembers(); // 서비스에게 조회를 시키고 그 결과를 브라우저로 바로 던집니다.
    }

    // 데이터를 받기 위한 내부 DTO 클래스
    @Data
    static class JoinRequest {
        private String loginId;
        private String password;
        private String name;
    }
}