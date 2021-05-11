package com.spring.mvc.web.request;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

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

    // 요청 URL: /request/req-ex
    @GetMapping("/request/req-ex")
    public String reqEx() {
        return "request/req-ex"; // return: 어떤 페이지를 열 것인가.
    }

    // 같은 URL, 다른 전송방식(GET, POST)
    @GetMapping("/request/basic")
    public String basicGET() {
        System.out.println("/basic GET 요청 발생!");
        return "request/req-ex";
    }
    @PostMapping("/request/basic")
    public String basicPOST() {
        System.out.println("/basic POST 요청 발생!");
        return "request/req-ex";
    }

    // 요청 파라미터 받기 (/req/basic ? xxx=yyy&zzz=xxx)
    // HttpServletRequest : 세션받을때 사용하므로 알아두기
    @GetMapping("/request/param")
    public String param(HttpServletRequest request) {
        String money = request.getParameter("money");
        System.out.println("money = " + money);
        String name = request.getParameter("name");
        System.out.println("name = " + name);
        return "test";
    }

    // 요청 파라미터 받기2 - @RequestParam 이용하기
    @GetMapping("/request/param2")
    /*public String param2(@RequestParam int money) {
        System.out.println("money = " + (money*2));
        return "test";
    }*/
    /*public String param2(@RequestParam("money") int apple) {
        System.out.println("apple = " + (apple*2));
        return "test";
    }*/
    /*public String param2(@RequestParam("money") int apple, @RequestParam String id) {
        System.out.println("apple = " + (apple*2));
        System.out.println("id = " + id);
        return "test";
    }*/
    // 파라미터명과 변수명이 같다면 @RequestParam 생략 가능
    // 실무팁: 한줄 주석처리하기 쉽게 콤마나 괄호를 내려준다.
    public String param2(@RequestParam("money") int apple
            , String id
    ) {
        System.out.println("apple = " + (apple*2));
        System.out.println("id = " + id);
        return "test";
    }

    // 요청 파라미터 받기3 - 커맨드 객체 사용 (파라미터가 많을 경우)
    @GetMapping("/request/param3")
    public String param3(User user) { // User 클래스를 따로 만들어야 함.
        System.out.println("user = " + user);
        return "test";
    }

    /*@GetMapping("/request/join-form")
    public String form() {
        return "/request/join-form";
    }*/
    // 요청경로와 jsp view 경로가 같다면 리턴타입을 void 로
    @GetMapping("/request/join-form")
    public void form() {
    }

    //============================== Quiz ==============================//
    // 요청 URL: /request/quiz
    @GetMapping("/request/quiz")
    public String quiz() {
        return "request/req-quiz";
    }

    @PostMapping("/request/quiz")
    public String quiz(String userId, String userPw) {
        /*if (userId.equals("abc1234") && userPw.equals("xxx4321")) {
            return "request/success";
        }
        return "request/fail";*/
        return userId.equals("abc1234") && userPw.equals("xxx4321")
                ? "request/success" : "request/fail";
    }


}
