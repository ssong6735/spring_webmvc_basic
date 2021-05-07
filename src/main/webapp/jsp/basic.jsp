<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!-- 디렉티브 문법. 톰캣이 jsp 파일로 인식하게 적어주기 -->

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>basic.jsp</title>
</head>
<body>

    <h1>basic.jsp 입니다!</h1>

    <%
        // 스크립트릿: 이 태그 안에서는 자바코드를 사용할 수 있음.
        // jsp 파일에서만 사용 가능

        for (int i=1; i<=9; i++) {
            // out 객체는 PrintWriter 타입의 객체이며 html을 그릴 수 있음.
            out.println("2 X " + i + " = " + (2*i) + "<br>");
        }
    %>

</body>
</html>






