package com.spring.mvc.web.v3;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AgeController {
    // 메서드 하나당 서블릿 하나


    // WEB-INF 폴더의 age.jsp 를 열어주는 요청 처리
    @GetMapping("/spring/age")
    public String springAge() {
        System.out.println("/spring/age GET 요청 발생!");
        return "/WEB-INF/age.jsp"; // 스프링 안에 view resuler 클래스에 리턴
    }

    // 입력받은 나이를 검증하는 요청 처리
    @GetMapping("/spring/check")
    public String check(int age, Model model) {

        String txt = (age > 19) ? "성인" : "미성년자";
        model.addAttribute("result", txt);

        return "/WEB-INF/result.jsp";
    }

}
