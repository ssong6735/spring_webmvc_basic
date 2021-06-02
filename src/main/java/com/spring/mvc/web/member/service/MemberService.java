package com.spring.mvc.web.member.service;

import com.spring.mvc.web.member.domain.Member;
import com.spring.mvc.web.member.repository.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberMapper memberMapper;

    // 회원 가입 기능
    public void signUp(Member member) {
        /* // 도메인 클래스에 설정해서 주석처리
        String rp = member.getPassword(); // 평문비번 찾아서
        member.setPassword(new BCryptPasswordEncoder().encode(rp)); // 암호화 인코딩 후 다시 세팅*/
        memberMapper.register(member);
    }


    /**
     * 중복확인 기능
     * @param type // 중복 검사 유형 (계정, 이메일)
     * @param keyword // 중복 검사 값
     * @return // 중복되었으면 true, 중복되지 않았으면 false
     */
    public boolean inDuplicate(String type, String keyword) {
        Map<String, Object> checkDataMap = new HashMap<>();
        checkDataMap.put("type", type);
        checkDataMap.put("keyword", keyword);
        return memberMapper.isDuplicate(checkDataMap) == 1;
    }


    // 회원 정보 조회 기능
    public Member getMember(String account) {
        return memberMapper.getUser(account);
    }







}
