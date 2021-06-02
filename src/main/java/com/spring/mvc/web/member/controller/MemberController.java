package com.spring.mvc.web.member.controller;

import com.spring.mvc.web.member.domain.Member;
import com.spring.mvc.web.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Log4j2
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    // 화원가입 페이지 요청
    @GetMapping("/member/sign-up")
    public String signUp() {
        return "member/join";
    }

    // 회원가입 요청
    @PostMapping("/member/sign-up")
    public String signUp(Member member) {
        log.info("/member/sign-up POST - " + member);
        memberService.signUp(member);
        return "redirect:/board/list";
    }

    // 아이디, 이메일 중복체크 비동기 요청 처리
    @GetMapping("/check")
    @ResponseBody
    public ResponseEntity<Boolean> check(String type, String keyword) {
        log.info("/check GET 비동기 요청!" + type + "|" + keyword );
        boolean flag = memberService.inDuplicate(type, keyword);
        return new ResponseEntity<>(flag, HttpStatus.OK);
    }

}
