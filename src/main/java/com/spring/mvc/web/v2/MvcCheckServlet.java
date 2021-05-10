package com.spring.mvc.web.v2;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/mvc/check")
public class MvcCheckServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int age = Integer.parseInt(request.getParameter("age"));

        String txt = "";
        if (age > 19) {
            txt = "성인";
        } else {
            txt = "미성년자";
        }

        // 필요한 데이터를 model 에 담아 둠
        // model 로 사용할 수 있는 객체 (request, session, application)
        // 라이프 사이클별로 구분
        // request: 하나의 요청과 응답 사이
        // session: 웹페이지가 꺼지기 전까지
        // application: 서버가 꺼지기 전까지

        request.setAttribute("result", txt);

        // model 에 담아둔 데이터를 jsp 파일로 전송
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/result.jsp");
        dispatcher.forward(request, response);

    }




}
