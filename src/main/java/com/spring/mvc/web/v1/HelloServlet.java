package com.spring.mvc.web.v1;

import org.springframework.http.MediaType;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/*
    # 서블릿: 웹 브라우저의 동적 요청을 처리하여
              서버에서 html 을 생성해서 응답하는 클래스
 */
// 아래 서블릿이 작동할수 있는 url 지정
@WebServlet(urlPatterns = "/hello")
public class HelloServlet extends HttpServlet {

    public HelloServlet() {
        System.out.println("헬로 서블릿 객체가 생성됨!");
    }

    // http 요청이 왔을때 WAS 에 의해 자동 호출되는 메서드
    // 용도: 핵심 로직을 수행할 메서드
    // 요청정보: HttpServletRequest req, 응답정보: HttpServletResponse resp
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //System.out.println("서블릿의 서비스 메서드 호출됨!");

        // 내 서버에 접속하는 클라이언트 IP 주소 표시
        String clientIp = req.getRemoteAddr();
        //System.out.println("clientIp");

        // 내 서버에 요청하는 파라미터 읽기
        String age = req.getParameter("age");
        String name = req.getParameter("name");
        System.out.println("age = " + age);
        System.out.println("name = " + name);

        // 리다이렉트 응답기능: 해당 url 로 이동시킴
        //resp.sendRedirect("https://www.daum.net");

        // 웹 브라우저에 텍스트 응답

        /*// 문서 타입, 문서 인코딩 설정
        resp.setContentType("text/plain");*/

        // 웹 브라우저에 html 응답: MIME TYPE
        resp.setContentType(MediaType.TEXT_PLAIN_VALUE);
        /*resp.setContentType("text/html");
        String m = MediaType.TEXT_PLAIN_VALUE;*/

        resp.setCharacterEncoding("utf-8");

        PrintWriter w = resp.getWriter();

        w.write("<ol>");
        w.write("<li>하이하이</li>");
        w.write("<li>하이하이2</li>");
        w.write("<li>하이하이3</li>");
        w.write("</ol>");

        w.close();

    }
}
