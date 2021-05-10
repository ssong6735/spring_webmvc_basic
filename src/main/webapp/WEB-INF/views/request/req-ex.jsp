<%@ page contentType="text/html; charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>req-ex.jsp</title>
</head>

<body>

    <h1>RequestController 를 이용한 요청 처리 작업</h1>
    <p>
        컨트롤러 테스트 중입니다.
    </p>

    <form action="/request/basic" method="GET">
        <button type="submit">GET 요청하기!</button>
    </form>

    <form action="/request/basic" method="POST">
        <button type="submit">POST 요청하기!</button>
    </form>

</body>

</html>