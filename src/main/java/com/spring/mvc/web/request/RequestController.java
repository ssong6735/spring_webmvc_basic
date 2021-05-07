package com.spring.mvc.web.request;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

// 스프링 컨테이너에 해당 클래스의 객체가 빈(컨트롤러기능)으로 등록됨
@Controller
public class RequestController {

    // 요청 처리 메서드 (서블릿 역할)
    // 해당 URL 에 따른 GET 요청을 처리하게 함.
    //@RequestMapping(value = "/req/test", method = RequestMethod.GET) // spring v3까지 사용
    @GetMapping("/req/test") // spring v4부터 사용
    public String test() {
        System.out.println("## /req/test GET 요청 발생!");
        //return "/WEB-INF/views/test.jsp"; // 리턴은 뷰 파일 포워딩 개념 : jsp 파일 열기
        return "test";
    }

}
