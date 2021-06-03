package com.spring.mvc.web.member.controller;

import com.spring.mvc.web.member.domain.LoginInfo;
import com.spring.mvc.web.member.domain.Member;
import com.spring.mvc.web.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

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
        log.info("/check GET 비동기 요청!" + type + "|" + keyword);
        boolean flag = memberService.inDuplicate(type, keyword);
        return new ResponseEntity<>(flag, HttpStatus.OK);
    }


    // 로그인 화면 열기 요청 처리
    @GetMapping("/member/sign-in")
    public String signIn() {
        return "member/login";
    }

    // 로그인 검증 요청 처리
    @PostMapping("/loginCheck")
    public String loginCheck(LoginInfo inputMember, Model model, HttpSession session) {
        log.info("/loginCheck POST : " + inputMember);

        // 로그인 처리
        String resultMessage = memberService.login(inputMember);
        log.info("result:" + resultMessage);
        model.addAttribute("result", resultMessage);

        if (resultMessage.equals("success")) {
            // 로그인이 성공하면 세션에 로그인한 유저정보 저장
            session.setAttribute("loginUser", memberService.getMember(inputMember.getAccount()));
//            model.addAttribute("loginUser", memberService.getMember(inputMember.getAccount()));
            return "redirect:/board/list";
        }
        return "member/login-result";
    }

    @GetMapping("/member/logout")
    public String logout(HttpSession session) {
        log.info("member/logout GET !");

        // 로그인을 한 유저라면 세션에 로그인회원정보가 있을 것임
        Object loginUser = (Member) session.getAttribute("loginUser");

        if (loginUser != null) {
            // 로그인을 한 사람은 세션을 무효화(지움)
            session.removeAttribute("loginUser");
            session.invalidate();
            return "redirect:/board/list"; // 홈으로 가기: "redirect:/"
        }
        return "redirect:/member/login";
    }


}
